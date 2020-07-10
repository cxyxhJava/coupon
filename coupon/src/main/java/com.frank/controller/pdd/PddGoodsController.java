package com.frank.controller.pdd;

import com.frank.pdd.dto.req.PddDdkGoodsZsUnitUrlGenReq;
import com.frank.pdd.dto.req.PddGoodsPromotionUrlGenerateReq;
import com.frank.pdd.dto.req.PddGoodsSearchListReq;
import com.frank.pdd.service.PddGoodsService;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsDetailRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPromotionUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsSearchRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsZsUnitUrlGenRequest;
import com.pdd.pop.sdk.http.api.pop.response.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:32 2020-05-28
 * @ Description：
 * @ Modified By：
 */
@RestController

public class PddGoodsController {
    @Autowired private PddGoodsService pddGoodsService;

    @PostMapping("/pdd/goods/search")
    public PddDdkGoodsSearchResponse.GoodsSearchResponse goodsList(@RequestBody PddGoodsSearchListReq request) throws Exception {
        PddDdkGoodsSearchRequest searchRequest = new PddDdkGoodsSearchRequest();
        BeanUtils.copyProperties(request,searchRequest);
        return pddGoodsService.goodsSearch(searchRequest);
    }

    @GetMapping("/pdd/goods/detail/{goodsId}")
    public PddDdkGoodsDetailResponse.GoodsDetailResponse goodsDetail(@PathVariable("goodsId") Long goodsId) throws Exception {
        PddDdkGoodsDetailRequest request = new PddDdkGoodsDetailRequest();
        List<Long> goodsIdList = new ArrayList<>();
        goodsIdList.add(goodsId);
        request.setGoodsIdList(goodsIdList);
        return pddGoodsService.goodsDetail(request);
    }

    @GetMapping("/pdd/goods/cats/list/{parentCatId}")
    public PddGoodsCatsGetResponse.GoodsCatsGetResponse goodsList(
            @PathVariable(value = "parentCatId",required = false) Long parentCatId) throws Exception {
        if (parentCatId==null){parentCatId = 0l;};
        return pddGoodsService.goodsCatsGet(parentCatId);
    }

    /**
     * 生成推广链接
     * @param
     * @return
     * @throws Exception
     */
    @PostMapping("/pdd/goods/zs/url/generate")
    public PddDdkGoodsZsUnitUrlGenResponse.GoodsZsUnitGenerateResponse goodsZsUnitUrlGen(@RequestBody PddDdkGoodsZsUnitUrlGenReq request) throws Exception {
        PddDdkGoodsZsUnitUrlGenRequest realRequest = new PddDdkGoodsZsUnitUrlGenRequest();
        realRequest.setPid("9678463_142395993");
        realRequest.setSourceUrl(request.getSourceUrl());
        return pddGoodsService.goodsZsUnitUrlGen(realRequest);
    }



    /**
     * 生成推广链接
     * @param
     * @return
     * @throws Exception
     */
    @PostMapping("/pdd/goods/promotion/url/generate")
    public PddDdkGoodsPromotionUrlGenerateResponse.GoodsPromotionUrlGenerateResponse goodsPromotionUrlGenerate(
            @RequestBody PddGoodsPromotionUrlGenerateReq request) throws Exception {
        PddDdkGoodsPromotionUrlGenerateRequest searchRequest = new PddDdkGoodsPromotionUrlGenerateRequest();
        BeanUtils.copyProperties(request,searchRequest);
        searchRequest.setPId("9678463_142395993");
        return pddGoodsService.goodsPromotionUrlGenerate(searchRequest);
    }

}
