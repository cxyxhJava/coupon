package com.frank.controller.pdd.wx;

import com.frank.common.Context;
import com.frank.common.DecimalUtil;
import com.frank.pdd.dto.wx.PageBaseResp;
import com.frank.pdd.dto.wx.req.PddWxGoodsListReq;
import com.frank.pdd.dto.wx.req.PddWxGetGoodsCouponByUrlReq;
import com.frank.pdd.dto.wx.resp.PddWxGoodsListResp;
import com.frank.pdd.service.PddGoodsService;
import com.frank.pdd.service.top.TopGoodsService;
import com.pdd.pop.sdk.http.api.pop.request.*;
import com.pdd.pop.sdk.http.api.pop.response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:32 2020-05-30
 * @ Description：
 * @ Modified By：
 */
@RestController
@RequestMapping("/wx/pdd/goods")
public class PddWxGoodsController {
    @Autowired private PddGoodsService pddGoodsService;
    @Autowired private TopGoodsService topGoodsService;


    @PostMapping("/list")
    public PageBaseResp<PddDdkGoodsSearchResponse.GoodsSearchResponseGoodsListItem> list(
            @RequestBody @Validated PddWxGoodsListReq req
    )throws Exception {
        PddDdkGoodsSearchRequest searchRequest = new PddDdkGoodsSearchRequest();
        BeanUtils.copyProperties(req,searchRequest);
        if (req.getPage()==null){
            searchRequest.setPage(1);
            req.setPage(1);
        }else {
            searchRequest.setPage(req.getPage());
        }
        if (req.getPageSize()==null){
            searchRequest.setPageSize(10);
            req.setPageSize(10);
        }else {
            searchRequest.setPageSize(req.getPageSize());
        }
        searchRequest.setPid(Context.WX_PID);
        PddDdkGoodsSearchResponse.GoodsSearchResponse response = pddGoodsService.goodsSearch(searchRequest);

        PageBaseResp<PddDdkGoodsSearchResponse.GoodsSearchResponseGoodsListItem> resp = new PageBaseResp<>();
        //List<PddWxGoodsListResp> list = new ArrayList<>();

        resp.setPageNo(req.getPage());
        resp.setPageSize(req.getPageSize());
        resp.setSearchId(response.getSearchId());
        if (response==null||response.getGoodsList()==null||response.getGoodsList().size()==0){
            resp.setTotal(0l);
            resp.setList(new ArrayList<>());
            return resp;
        }

        resp.setTotal(Long.valueOf(response.getTotalCount()));
        List<PddDdkGoodsSearchResponse.GoodsSearchResponseGoodsListItem> goodsListItemList = response.getGoodsList();
//        goodsListItemList.forEach(
//                item -> {
//                    PddWxGoodsListResp pddWxGoodsListResp = new PddWxGoodsListResp();
//                    pddWxGoodsListResp.setCouponDiscount(DecimalUtil.divide(item.getCouponDiscount(),100));
//                    pddWxGoodsListResp.setGoodsDesc(item.getGoodsDesc());
//                    pddWxGoodsListResp.setGoodsId(item.getGoodsId());
//                    pddWxGoodsListResp.setGoodsImageUrl(item.getGoodsImageUrl());
//                    pddWxGoodsListResp.setGoodsName(item.getGoodsName());
//                    pddWxGoodsListResp.setMallId(item.getMallId());
//                    pddWxGoodsListResp.setMallName(item.getMallName());
//                    pddWxGoodsListResp.setMinGroupPrice(DecimalUtil.divide(item.getMinGroupPrice(),100));
//                    pddWxGoodsListResp.setMinNormalPrice(DecimalUtil.divide(item.getMinNormalPrice(),100));
//                    pddWxGoodsListResp.setSalesTip(item.getSalesTip());
//                    list.add(pddWxGoodsListResp);
//                }
//        );
        resp.setList(goodsListItemList);
        return resp;
    }

    @GetMapping("/detail/{goodsId}")
    public PddDdkGoodsDetailResponse.GoodsDetailResponse goodsDetail(@PathVariable("goodsId") Long goodsId
    ) throws Exception {
        PddDdkGoodsDetailRequest request = new PddDdkGoodsDetailRequest();
        List<Long> goodsIdList = new ArrayList<>();
        goodsIdList.add(goodsId);
        request.setGoodsIdList(goodsIdList);
        request.setPid(Context.WX_PID);
        return pddGoodsService.goodsDetail(request);
    }

    /**
     * 获取推广链接
     * @param req
     * @return
     * @throws Exception
     */
    @PostMapping("/coupon/url")
    public PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem getPddWxGetGoodsCouponByUrl(@RequestBody @Validated PddWxGetGoodsCouponByUrlReq req) throws Exception {

        PddDdkGoodsPromotionUrlGenerateRequest request = new PddDdkGoodsPromotionUrlGenerateRequest();
        List<Long> goodsList = new ArrayList<>();

        Long goodsId;
        if (req.getGoodsId()!=null){
            goodsId = req.getGoodsId();
        }else if (!StringUtils.isEmpty(req.getUrl())){
            goodsId = Long.valueOf(req.getUrl().split("&goods_id=")[1].split("&")[0]);
        }else {
            return null;
        }
        goodsList.add(goodsId);
        request.setGoodsIdList(goodsList);
        request.setPId(Context.WX_PID);
        request.setGenerateWeApp(true);
        request.setSearchId(req.getSearchId());
        PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponse pddResp = pddGoodsService.goodsPromotionUrlGenerate(request);
        List<PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem> list =  pddResp.getGoodsPromotionUrlList();
        if (list==null||list.size()<1){
            return null;
        }
        PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponseGoodsPromotionUrlListItem item = list.get(0);
        return item;
    }


    /**
     * 热销
     * @param pageSize
     * @param pageNo
     * @return
     * @throws Exception
     */
    @GetMapping("/top")
    public PddDdkTopGoodsListQueryResponse.TopGoodsListGetResponse goodsList(@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize,
                                                                             @RequestParam(value = "pageNo",required = false, defaultValue = "1") Integer pageNo
    ) throws Exception {
        PddDdkTopGoodsListQueryRequest request = new PddDdkTopGoodsListQueryRequest();
        //全非必填
        request.setSortType(1);//1-实时热销榜；2-实时收益榜
        request.setOffset(pageSize*(pageNo-1));//从多少位置开始请求；默认值 ： 0
        //request.setListId();//翻页时建议填写前页返回的list_id值
        request.setLimit(pageSize);// 请求数量；默认值 ： 400
        request.setPId(Context.WX_PID);//推广位id
        return topGoodsService.topGoodsList(request);
    }



    /**
     * 热销
     * @param pageSize
     * @param pageNo
     * @return
     * @throws Exception
     */
    @GetMapping("/recommend")
    public PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse recommend(@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize,
                                                                             @RequestParam(value = "pageNo",required = false, defaultValue = "1") Integer pageNo,
                                                                              @RequestParam(value = "channelType",required = false, defaultValue = "1") Integer channelType,
                                                                              @RequestParam(value = "catId",required = false) Long catId
    ) throws Exception {
        PddDdkGoodsRecommendGetRequest request = new PddDdkGoodsRecommendGetRequest();
        //全非必填
        request.setChannelType(channelType);//	0-1.9包邮, 1-今日爆款, 2-品牌清仓,3-相似商品推荐,4-猜你喜欢,5-实时热销,6-实时收益,7-今日畅销,8-高佣榜单，默认1
        request.setOffset(pageSize*(pageNo-1));//从多少位置开始请求；默认值 ： 0
        //request.setListId();//翻页时建议填写前页返回的list_id值
        request.setLimit(pageSize);// 请求数量；默认值 ： 400
        request.setPid(Context.WX_PID);//推广位id
        if (catId!=null){
            request.setCatId(catId);//	猜你喜欢场景的商品类目，20100-百货，20200-母婴，20300-食品，20400-女装，20500-电器，20600-鞋包，20700-内衣，20800-美妆，20900-男装，21000-水果，21100-家纺，21200-文具,21300-运动,21400-虚拟,21500-汽车,21600-家装,21700-家具,21800-医药;
        }
        return topGoodsService.goodsRecommend(request);
    }









}
