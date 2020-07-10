package com.frank.pdd.service;

import com.frank.common.DecimalUtil;
import com.frank.dto.req.ChainTransferReq;
import com.frank.dto.req.GoodsPromoteUrlGetReq;
import com.frank.dto.resp.ChainTransferResp;
import com.frank.dto.resp.GoodsPromoteUrlGetResp;
import com.frank.dto.resp.GoodsPromoteUrlGoodsDetailDto;
import com.frank.pdd.common.EnumType;
import com.frank.pdd.dto.req.GoodsListReq;
import com.frank.pdd.dto.resp.GoodsListResp;
import com.taobao.api.ApiException;
import com.taobao.api.DefaultTaobaoClient;
import com.taobao.api.TaobaoClient;
import com.taobao.api.request.TbkDgMaterialOptionalRequest;
import com.taobao.api.request.TbkItemInfoGetRequest;
import com.taobao.api.request.TbkTpwdCreateRequest;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import com.taobao.api.response.TbkItemInfoGetResponse;
import com.taobao.api.response.TbkTpwdCreateResponse;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:42 2020-06-24
 * @ Description：
 * @ Modified By：
 */
@Component
public class TBKGoodsService extends GoodsService{

    private static final String HTTP_URL = "http://gw.api.taobao.com/router/rest";
    private static final String HTTPS_URL = "https://eco.taobao.com/router/rest";
    private static final String APPKEY = "30078184";
    private static final String SECRET = "4d6e0dee7960e1295e1e4978c1797dd4";




    public TbkDgMaterialOptionalResponse goodsSearch(GoodsListReq req) throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(HTTP_URL, APPKEY, SECRET);
        TbkDgMaterialOptionalRequest request = new TbkDgMaterialOptionalRequest();
        request.setPageSize(Long.valueOf(req.getPageSize()));
        request.setPageNo(Long.valueOf(req.getPageNo()));

        String sort;
        //排序 0.默认综合 1.价格倒叙 2.价格升序 3.销量倒叙 4.销量升序 5.券后倒叙 6.券后升序
        //排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）
        switch (req.getSort()){
            case 1: sort = "price_des"; break;
            case 2: sort = "price_asc"; break;
            case 3: sort = "total_sales_des"; break;
            case 4: sort = "total_sales_asc"; break;
//            case 5: sort = 10; break;
//            case 6: sort = 9; break;
            default:sort=null;break;
        }
        if (sort!=null){
            request.setSort(sort);
        }
        request.setQ(req.getKeyword());
        request.setPlatform(2l);
        request.setMaterialId(17004l);
        //TODO 淘宝不支持单独商品id搜索
        request.setAdzoneId(121316362l);

        TbkDgMaterialOptionalResponse rsp = client.execute(request);
        System.out.println(rsp.getBody());
        return rsp;
    }


    @Override
    public GoodsPromoteUrlGetResp getGoodsPromoteUrl(GoodsPromoteUrlGetReq req) throws Exception {
        if (req.getType()!= EnumType.TBK.getCode()){
            return null;
        }
        String ip = null;
        List<TbkItemInfoGetResponse.NTbkItem> goodsDetailList =  goodsDetail(req.getGoodsId(),req.getPlatform(),ip);
        if (goodsDetailList==null||goodsDetailList.isEmpty()){
            return null;
        }

        TbkItemInfoGetResponse.NTbkItem nTbkItem = goodsDetailList.get(0);
        GoodsPromoteUrlGetResp resp = new GoodsPromoteUrlGetResp();

        GoodsPromoteUrlGoodsDetailDto detailDto = new GoodsPromoteUrlGoodsDetailDto();
        Long price = DecimalUtil.multiply(nTbkItem.getReservePrice(),100).longValue();
        Long finalPrice = DecimalUtil.multiply(nTbkItem.getZkFinalPrice(),100).longValue();

        detailDto.setPrice(price);
        detailDto.setName(nTbkItem.getTitle());
        detailDto.setImageUrl(nTbkItem.getPictUrl());
        detailDto.setCouponPrice(price-finalPrice);
        resp.setType(req.getType());
        resp.setPhoneUrl(nTbkItem.getItemUrl());
        resp.setPcUrl(nTbkItem.getItemUrl());
        resp.setGoodsDetailDto(detailDto);
        return resp;
    }

    @Override
    public GoodsListResp getGoodsList(GoodsListReq req) throws Exception {
        return null;
    }

    @Override
    public ChainTransferResp chainTransfer(ChainTransferReq req) throws Exception {

//        TbkItemConvertRequest
//        TbkCouponConvertRequest

        return null;
    }


//    public static void main(String[] args) throws ApiException {
//        TBKGoodsService tbkGoodsService = new TBKGoodsService();
//
//        GoodsListReq req = new GoodsListReq();
//        req.setKeyword("女装");
//        req.setSort(0);
//        req.setPageNo(1);
//        req.setPageSize(10);
//        req.setType(1);
//        tbkGoodsService.goodsSearch(req);
//    }





    public List<TbkItemInfoGetResponse.NTbkItem> goodsDetail(String goodsIdStr, Long platForm, String ip) throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(HTTP_URL, APPKEY, SECRET);
        TbkItemInfoGetRequest req = new TbkItemInfoGetRequest();
        req.setNumIids(goodsIdStr);
        req.setPlatform(platForm);
        req.setIp(ip);
        TbkItemInfoGetResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
        return rsp.getResults();
    }

    public void tpwdCreate() throws ApiException {
        TaobaoClient client = new DefaultTaobaoClient(HTTP_URL, APPKEY, SECRET);
        TbkTpwdCreateRequest req = new TbkTpwdCreateRequest();
        req.setUserId("123");
        req.setText("长度大于5个字符");
        req.setUrl("https://uland.taobao.com/");
        req.setLogo("https://uland.taobao.com/");
        req.setExt("{}");
        TbkTpwdCreateResponse rsp = client.execute(req);
        System.out.println(rsp.getBody());
    }
}

//请求参数
//start_dsr	Number	false	10	商品筛选(特定媒体支持)-店铺dsr评分。筛选大于等于当前设置的店铺dsr评分的商品0-50000之间
//page_size	Number	false	20	页大小，默认20，1~100
//page_no	Number	false	1	第几页，默认：１
//platform	Number	false	1	链接形式：1：PC，2：无线，默认：１
//end_tk_rate	Number	false	1234	商品筛选-淘客佣金比率上限。如：1234表示12.34%
//start_tk_rate	Number	false	1234	商品筛选-淘客佣金比率下限。如：1234表示12.34%
//end_price	Number	false	10	商品筛选-折扣价范围上限。单位：元
//start_price	Number	false	10	商品筛选-折扣价范围下限。单位：元
//is_overseas	Boolean	false	false	商品筛选-是否海外商品。true表示属于海外商品，false或不设置表示不限
//is_tmall	Boolean	false	false	商品筛选-是否天猫商品。true表示属于天猫商品，false或不设置表示不限
//sort	String	false	tk_rate_des	排序_des（降序），排序_asc（升序），销量（total_sales），淘客佣金比率（tk_rate）， 累计推广量（tk_total_sales），总支出佣金（tk_total_commi），价格（price）
//itemloc	String	false	杭州	商品筛选-所在地
//cat	String	false	16,18	商品筛选-后台类目ID。用,分割，最大10个，该ID可以通过taobao.itemcats.get接口获取到
//q	String	false	女装	商品筛选-查询词
//material_id	Number	false	2836	不传时默认物料id=2836；如果直接对消费者投放，可使用官方个性化算法优化的搜索物料id=17004
//has_coupon	Boolean	false	false	优惠券筛选-是否有优惠券。true表示该商品有优惠券，false或不设置表示不限
//ip	String	false	13.2.33.4	ip参数影响邮费获取，如果不传或者传入不准确，邮费无法精准提供
//adzone_id	Number	true	12345678	mm_xxx_xxx_12345678三段式的最后一段数字
//need_free_shipment	Boolean	false	true	商品筛选-是否包邮。true表示包邮，false或不设置表示不限
//need_prepay	Boolean	false	true	商品筛选-是否加入消费者保障。true表示加入，false或不设置表示不限
//include_pay_rate_30	Boolean	false	true	商品筛选(特定媒体支持)-成交转化是否高于行业均值。True表示大于等于，false或不设置表示不限
//include_good_rate	Boolean	false	true	商品筛选-好评率是否高于行业均值。True表示大于等于，false或不设置表示不限
//include_rfd_rate	Boolean	false	true	商品筛选(特定媒体支持)-退款率是否低于行业均值。True表示大于等于，false或不设置表示不限
//npx_level	Number	false	2	商品筛选-牛皮癣程度。取值：1不限，2无，3轻微
//end_ka_tk_rate	Number	false	1234	商品筛选-KA媒体淘客佣金比率上限。如：1234表示12.34%
//start_ka_tk_rate	Number	false	1234	商品筛选-KA媒体淘客佣金比率下限。如：1234表示12.34%
//device_encrypt	String	false	MD5	智能匹配-设备号加密类型：MD5
//device_value	String	false	xxx	智能匹配-设备号加密后的值（MD5加密需32位小写）
//device_type	String	false	IMEI	智能匹配-设备号类型：IMEI，或者IDFA，或者UTDID（UTDID不支持MD5加密），或者OAID
//lock_rate_end_time	Number	false	1567440000000	锁佣结束时间
//lock_rate_start_time	Number	false	1567440000000	锁佣开始时间
//longitude	String	false	121.473701	本地化业务入参-LBS信息-经度
//latitude	String	false	31.230370	本地化业务入参-LBS信息-纬度
//city_code	String	false	310000	本地化业务入参-LBS信息-国标城市码，仅支持单个请求，请求饿了么卡券物料时，该字段必填。 （详细城市ID见：https://mo.m.taobao.com/page_2020010315120200508）
//seller_ids	String	false	1,2,3,4	商家id，仅支持饿了么卡券商家ID，支持批量请求1-100以内，多个商家ID使用英文逗号分隔
