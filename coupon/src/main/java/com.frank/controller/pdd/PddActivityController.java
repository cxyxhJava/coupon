package com.frank.controller.pdd;

import com.frank.pdd.dto.resp.PddResourceUrlResp;
import com.frank.pdd.service.PddActivityService;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkThemeListGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkThemeGoodsSearchResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkThemeListGetResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:32 2020-05-30
 * @ Description：
 * @ Modified By：
 */
@RestController
public class PddActivityController {
    @Autowired private PddActivityService pddActivityService;

    @GetMapping("/pdd/theme/list")
    public PddDdkThemeListGetResponse.ThemeListGetResponse themeList()throws Exception {
        PddDdkThemeListGetRequest request = new PddDdkThemeListGetRequest();
        return pddActivityService.getThemeList(request);
    }

    @GetMapping("/pdd/theme/goods/list/{themeId}")
    public PddDdkThemeGoodsSearchResponse.ThemeListGetResponse themeGoodsList(@PathVariable(value = "themeId") Long themeId) throws Exception {
        return pddActivityService.getThemeGoodsList(themeId);
    }


    @GetMapping("/pdd/resource/url/gen/{resourceType}")
    public PddResourceUrlResp getResourceUrl(@PathVariable(value = "resourceType") Integer resourceType) throws Exception {
        //频道来源：4-限时秒杀,39997-充值中心, 39998-转链type，39999-电器城，39996-百亿补贴 0获取全部
        return pddActivityService.getResourceUrl(resourceType);
    }


//    @GetMapping("/pdd/prom/url/generate")
//    public PddResourceUrlResp getPromUrl(@PathVariable(value = "resourceType") Integer resourceType) throws Exception {
//        return pddActivityService.getPromUrl(resourceType);
//    }




}
