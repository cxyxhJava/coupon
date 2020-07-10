package com.frank.controller.pdd;

import com.frank.pdd.service.top.TopGoodsService;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkOauthTopGoodsListQueryRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkTopGoodsListQueryRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkTopGoodsListQueryResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:32 2020-05-28
 * @ Description：
 * @ Modified By：拼多多爆品推荐
 */
@RestController
public class PddTopGoodsController {
    @Autowired private TopGoodsService topGoodsService;


    @GetMapping("/top/goods/list")
    public PddDdkTopGoodsListQueryResponse.TopGoodsListGetResponse goodsList(@RequestParam(value = "pageSize",required = false, defaultValue = "10") Integer pageSize,
                                                                             @RequestParam(value = "pageNo",required = false, defaultValue = "0") Integer pageNo
    ) throws Exception {
        PddDdkTopGoodsListQueryRequest request = new PddDdkTopGoodsListQueryRequest();
        //全非必填
        request.setSortType(1);//1-实时热销榜；2-实时收益榜
        //request.setOffset(pageSize*pageNo);//从多少位置开始请求；默认值 ： 0
        //request.setListId();//翻页时建议填写前页返回的list_id值
        //request.setLimit(pageSize);// 请求数量；默认值 ： 400
        //request.setPId("9678463_142395993");//推广位id
        return topGoodsService.topGoodsList(request);
    }

    @GetMapping("/top/goods/recommend")
    public PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse goodsRecommend()throws Exception{
        PddDdkGoodsRecommendGetRequest request = new PddDdkGoodsRecommendGetRequest();
        return topGoodsService.goodsRecommend(request);
    }






}
