package com.frank.controller;

import com.frank.dto.req.ChainTransferReq;
import com.frank.dto.req.GoodsPromoteUrlGetReq;
import com.frank.dto.resp.ChainTransferResp;
import com.frank.dto.resp.GoodsPromoteUrlGetResp;
import com.frank.pdd.dto.req.GoodsListReq;
import com.frank.pdd.dto.resp.GoodsListResp;
import com.frank.pdd.service.PddGoodsService;
import com.frank.pdd.service.TBKGoodsService;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsZsUnitUrlGenRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:32 2020-05-28
 * @ Description：
 * @ Modified By：
 */
@RestController
@Api(value = "api", description = "商品")
public class GoodsController {
    @Autowired private PddGoodsService pddGoodsService;
    @Autowired private TBKGoodsService tbkGoodsService;

    @PostMapping("/goods/list")
    @ApiOperation(value = "获取商品列表",nickname = "goodsList",notes = "作者:杨晓波",tags = {"商品",})
    public GoodsListResp goodsList(
            @Validated @RequestBody GoodsListReq req
            ) throws Exception {
        if (req.getSort()==null){
            req.setSort(0);
        }
        if (req.getPageNo()==null){
            req.setPageNo(1);
        }
        if (req.getPageSize()==null){
            req.setPageSize(10);
        }
        //同时查询多个平台
        PddDdkGoodsSearchResponse.GoodsSearchResponse pddResp = null;
        TbkDgMaterialOptionalResponse tbkResp = null;

        Integer type = req.getType();
        //0.查全部 1.拼多多 2.淘宝
        switch (type){
            case 0:
                pddResp = pddGoodsService.goodsSearch(req);
                tbkResp = tbkGoodsService.goodsSearch(req);
                break;
            case 1: pddResp = pddGoodsService.goodsSearch(req);  break;
            case 2: tbkResp = tbkGoodsService.goodsSearch(req); break;
            default:
                pddResp = pddGoodsService.goodsSearch(req);
                tbkResp = tbkGoodsService.goodsSearch(req);
                break;
        }

        GoodsListResp resp = new GoodsListResp();
        resp.setType(type);
        resp.setPddResp(pddResp);
        resp.setTbkResp(tbkResp);
        return resp;
    }


    @PostMapping("/goods/url")
    @ApiOperation(value = "获取商品退广链接",nickname = "getUrl",notes = "作者:杨晓波",tags = {"商品",})
    public GoodsPromoteUrlGetResp getUrl(
            @Validated @RequestBody GoodsPromoteUrlGetReq req) throws Exception {
        Integer type = req.getType();
        //1.拼多多 2.淘宝
        switch (type){
            case 1: return pddGoodsService.getGoodsPromoteUrl(req);
            case 2: return tbkGoodsService.getGoodsPromoteUrl(req);
            default:
                break;
        }
        return null;
    }


    @PostMapping("/chain/transfer")
    public ChainTransferResp chainTransfer(@Validated @RequestBody ChainTransferReq req) throws Exception {
        ChainTransferResp resp = new ChainTransferResp();
        switch (req.getType()){
            case 1:
               return pddGoodsService.chainTransfer(req);
            case 2:
                return tbkGoodsService.chainTransfer(req);
        }
        return resp;
    }
}
