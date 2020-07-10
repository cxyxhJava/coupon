package com.frank.pdd.service;

import com.frank.common.Context;
import com.frank.dto.req.ChainTransferReq;
import com.frank.dto.req.GoodsPromoteUrlGetReq;
import com.frank.dto.resp.ChainTransferResp;
import com.frank.dto.resp.GoodsPromoteUrlGetResp;
import com.frank.dto.resp.GoodsPromoteUrlGoodsDetailDto;
import com.frank.pdd.common.EnumType;
import com.frank.pdd.dto.req.GoodsListReq;
import com.frank.pdd.dto.resp.GoodsListResp;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.*;
import com.pdd.pop.sdk.http.api.pop.response.*;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.frank.pdd.common.Content.clientId;
import static com.frank.pdd.common.Content.clientSecret;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 18:04 2020-05-29
 * @ Description：商品相关
 * @ Modified By：
 */
@Component
public class PddGoodsService extends GoodsService{


    /**
     * 搜索功能
     * @param req
     * @return
     * @throws Exception
     */
    public PddDdkGoodsSearchResponse.GoodsSearchResponse goodsSearch(GoodsListReq req)throws Exception{
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        request.setPage(req.getPageNo());
        request.setPageSize(req.getPageSize());
        request.setKeyword(req.getKeyword());

//        List<String> goodsIdStrList = req.getGoodsIdList();
//        if (!goodsIdStrList.isEmpty()){
//            List<Long> goodsIdList = new ArrayList<>();
//            goodsIdStrList.forEach(
//                    goodsIdStr-> goodsIdList.add(Long.valueOf(goodsIdStr))
//            );
//            request.setGoodsIdList(goodsIdList);
//        }
        //排序 0.默认综合 1.价格倒叙 2.价格升序 3.销量倒叙 4.销量升序 5.券后倒叙 6.券后升序
        //排序方式:0-综合排序;1-按佣金比率升序;2-按佣金比例降序;3-按价格升序;4-按价格降序;5-按销量升序;6-按销量降序;7-优惠券金额排序升序;8-优惠券金额排序降序;9-券后价升序排序;10-券后价降序排序;11-按照加入多多进宝时间升序;12-按照加入多多进宝时间降序;13-按佣金金额升序排序;14-按佣金金额降序排序;15-店铺描述评分升序;16-店铺描述评分降序;17-店铺物流评分升序;18-店铺物流评分降序;19-店铺服务评分升序;20-店铺服务评分降序;27-描述评分击败同类店铺百分比升序，28-描述评分击败同类店铺百分比降序，29-物流评分击败同类店铺百分比升序，30-物流评分击败同类店铺百分比降序，31-服务评分击败同类店铺百分比升序，32-服务评分击败同类店铺百分比降序
        Integer sort = 0;
        switch (req.getSort()){
            case 1: sort = 4; break;
            case 2: sort = 3; break;
            case 3: sort = 6; break;
            case 4: sort = 5; break;
            case 5: sort = 10; break;
            case 6: sort = 9; break;
        }
        request.setSortType(sort);
        PddDdkGoodsSearchResponse response = client.syncInvoke(request);
        return response.getGoodsSearchResponse();
    }


    /**
     * 多多进宝商品详情查询：pdd.ddk.goods.detail
     * @param request
     * @return
     * @throws Exception
     */
    public PddDdkGoodsDetailResponse.GoodsDetailResponse goodsDetail(PddDdkGoodsDetailRequest request)throws Exception{
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkGoodsDetailResponse response = client.syncInvoke(request);
        return response.getGoodsDetailResponse();
    }


    /**
     *一、支持入参筛选条件有：标题；拼团价/券后价；佣金比例/佣金金额区间；优惠券金额区间；是否有优惠券；商品标签；商品类目。
     * l 某一个标签id的商品、某一个分类id的商品。二者的区别在于：标签是一个商品有多个同级标签，例：某商品既属于一级标签服饰，也属于一级标签男装。 分类是一个商品仅有一个同级分类。
     * 获取标签id/分类id的方法，请查看以下接口
     * 商品API——》pdd.goods.opt.get（查询商品标签列表）
     * 进宝网站单品推广首页类目映射对应如下：
     *
     * opt_id	15	4	1	14	18	1281	1282	16	743	13	818	2478	1451	590	2048	1917	2974	3279
     * 网站类目映射	百货	母婴	食品	女装	电器	鞋包	内衣	美妆	男装	水果	家纺	文具	运动	虚拟	汽车	家装	家具	医药
     *
     * 二、支持入参排序条件有：由入参range_list字段控制，range_id映射值如下：0-最小成团价； 1-券后价； 2-佣金比例； 3-优惠券价格； 4-广告创建时间； 5-销量； 6-佣金金额； 7-店铺描述分； 8-店铺物流分； 9-店铺服务分； 10-店铺描述分击败同行业百分比； 11-店铺物流分击败同行业百分比； 12-店铺服务分击败同行业百分比； 13-商品分； 17-优惠券/最小团购价； 18-过去两小时pv ；19-过去两小时销量
     * @param request
     * @return
     * @throws Exception
     */
    public PddDdkGoodsSearchResponse.GoodsSearchResponse goodsSearch(PddDdkGoodsSearchRequest request)throws Exception{
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkGoodsSearchResponse response = client.syncInvoke(request);
        return response.getGoodsSearchResponse();
    }


    /**
     * pdd.goods.cats.get商品标准类目接口
     * @param parentCatId	LONG	必填	值=0时为顶点cat_id,通过树顶级节点获取cat树
     * @return
     * @throws Exception
     */
    public PddGoodsCatsGetResponse.GoodsCatsGetResponse goodsCatsGet(Long parentCatId) throws Exception {
        PddGoodsCatsGetRequest request = new PddGoodsCatsGetRequest();
        request.setParentCatId(parentCatId);
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddGoodsCatsGetResponse response = client.syncInvoke(request);
        System.out.println(JsonUtil.transferToJson(response));
        return response.getGoodsCatsGetResponse();
    }


    /**
     * 多多进宝推广链接生成：pdd.ddk.goods.promotion.url.generate
     * @param request
     * @return
     * @throws Exception
     */
    public PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponse goodsPromotionUrlGenerate(PddDdkGoodsPromotionUrlGenerateRequest request) throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkGoodsPromotionUrlGenerateResponse response = client.syncInvoke(request);

        return response.getGoodsPromotionUrlGenerateResponse();
    }

    /**
     * 多多进宝转链接口：pdd.ddk.goods.zs.unit.url.gen
     * 本接口用于将其他推广者的推广链接直接转换为自己的，如果您的推广场景为采集群，可直接使用此接口
     * @param request
     * @return
     * @throws Exception
     */
    public PddDdkGoodsZsUnitUrlGenResponse.GoodsZsUnitGenerateResponse goodsZsUnitUrlGen(PddDdkGoodsZsUnitUrlGenRequest request) throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkGoodsZsUnitUrlGenResponse response = client.syncInvoke(request);
        return response.getGoodsZsUnitGenerateResponse();

    }

    @Override
    public GoodsPromoteUrlGetResp getGoodsPromoteUrl(GoodsPromoteUrlGetReq req) throws Exception {
        if (req.getType()!= EnumType.PDD.getCode()){
            return null;
        }
        //调用搜索接口+获取链接接口
        List<Long> goodsListList = new ArrayList<>();
        goodsListList.add(Long.valueOf(req.getGoodsId()));
        //调用搜索接口
        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        request.setGoodsIdList(goodsListList);
        request.setPid(Context.WX_PID);
        request.setPageSize(1);
        PddDdkGoodsSearchResponse.GoodsSearchResponse response = goodsSearch(request);
        if (response==null||response.getGoodsList()==null||response.getGoodsList().isEmpty()){
            return null;
        }
        //调用获取链接接口
        PddDdkGoodsPromotionUrlGenerateRequest urlGenerateRequest = new PddDdkGoodsPromotionUrlGenerateRequest();
        urlGenerateRequest.setSearchId(response.getSearchId());
        urlGenerateRequest.setPId(Context.WX_PID);
        urlGenerateRequest.setGoodsIdList(goodsListList);
        PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponse urlGenerateResponse = goodsPromotionUrlGenerate(urlGenerateRequest);
        if (urlGenerateResponse==null||urlGenerateResponse.getGoodsPromotionUrlList()==null||urlGenerateResponse.getGoodsPromotionUrlList().isEmpty()){
            return null;
        }

        //封装返回值
        PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem item = urlGenerateResponse.getGoodsPromotionUrlList().get(0);

        PddDdkGoodsSearchResponse.GoodsSearchResponseGoodsListItem goodsListItem = response.getGoodsList().get(0);
        GoodsPromoteUrlGoodsDetailDto detailDto = new GoodsPromoteUrlGoodsDetailDto();
        detailDto.setCouponPrice(goodsListItem.getCouponDiscount());
        detailDto.setImageUrl(goodsListItem.getGoodsImageUrl());
        detailDto.setName(goodsListItem.getGoodsName());
        detailDto.setPrice(goodsListItem.getMinGroupPrice());

        GoodsPromoteUrlGetResp resp = new GoodsPromoteUrlGetResp();
        resp.setPcUrl(item.getShortUrl());
        resp.setPhoneUrl(item.getMobileShortUrl());
        resp.setGoodsDetailDto(detailDto);
        resp.setType(EnumType.PDD.getCode());

        return resp;
    }

    @Override
    public GoodsListResp getGoodsList(GoodsListReq req) throws Exception{
        return null;
    }

    @Override
    public ChainTransferResp chainTransfer(ChainTransferReq req) throws Exception{
        PddDdkGoodsZsUnitUrlGenRequest request = new PddDdkGoodsZsUnitUrlGenRequest();
        request.setSourceUrl(req.getUrl());
        request.setPid(Context.WX_PID);
        PddDdkGoodsZsUnitUrlGenResponse.GoodsZsUnitGenerateResponse response = goodsZsUnitUrlGen(request);
        return ChainTransferResp.builder()
                .pcUrl(response.getShortUrl())
                .phoneUrl(response.getMobileShortUrl())
                .groupPhoneUrl(response.getMultiGroupMobileShortUrl())
                .groupPcUrl(response.getMultiGroupShortUrl())
                .type(req.getType())
                .build();
    }


//    public static void main(String[] args) throws Exception {
//        PddGoodsService goodsService = new PddGoodsService();
////        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
////        goodsService.goodsSearch(request);
////        goodsService.goodsCatsGet(0l);
//        PddDdkGoodsDetailRequest request = new PddDdkGoodsDetailRequest();
//        request.setGoodsIdList();
//        goodsService.goodsDetail(request);
//    }

}
