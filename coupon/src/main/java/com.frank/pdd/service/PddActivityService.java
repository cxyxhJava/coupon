package com.frank.pdd.service;

import com.frank.pdd.dto.resp.PddResourceUrlDto;
import com.frank.pdd.dto.resp.PddResourceUrlResp;
import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkResourceUrlGenRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkRpPromUrlGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkThemeGoodsSearchRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkThemeListGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkResourceUrlGenResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkRpPromUrlGenerateResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkThemeGoodsSearchResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkThemeListGetResponse;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.frank.pdd.common.Content.clientId;
import static com.frank.pdd.common.Content.clientSecret;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:17 2020-05-30
 * @ Description：拼多多活动相关
 * @ Modified By：
 */
@Component
public class PddActivityService {

    /**
     * 多多进宝主题列表查询：pdd.ddk.theme.list.get
     * 本接口用于获取官方主题列表（主题id、主题名称、主题banner图）
     * @param request
     * @return
     * @throws Exception
     */
    public PddDdkThemeListGetResponse.ThemeListGetResponse getThemeList(PddDdkThemeListGetRequest request) throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);
        request.setPageSize(8);
        PddDdkThemeListGetResponse response = client.syncInvoke(request);
        return response.getThemeListGetResponse();
    }


    /**
     * 多多进宝主题商品查询：pdd.ddk.theme.goods.search
     * 本接口用于查询某个官方主题中商品信息
     * @param themeId
     * @return
     * @throws Exception
     */
    public PddDdkThemeGoodsSearchResponse.ThemeListGetResponse getThemeGoodsList(Long themeId) throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkThemeGoodsSearchRequest request = new PddDdkThemeGoodsSearchRequest();
        request.setThemeId(themeId);
        PddDdkThemeGoodsSearchResponse response = client.syncInvoke(request);
        return response.getThemeListGetResponse();
    }


    /**
     * 生成多多进宝频道推广：pdd.ddk.resource.url.gen
     * 本接口用于进行平台大促活动（如618、双十一活动）、平台优惠频道转链（电器城、限时秒杀等）（入参resource_type：4-限时秒杀,39997-充值中心, 39998-转链type，39999-电器城，39996-百亿补贴）
     * @param
     * @return
     * @throws Exception
     */
    public PddResourceUrlResp getResourceUrl(Integer resourceType) throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkResourceUrlGenRequest request = new PddDdkResourceUrlGenRequest();
        request.setPid("9678463_142395993");
        request.setResourceType(resourceType); //esource_type：4-限时秒杀,39997-充值中心, 39998-转链type，39999-电器城，39996-百亿补贴
        request.setGenerateQqApp(false);
        request.setGenerateWeApp(false);
        PddResourceUrlResp result = new PddResourceUrlResp();
        List<PddResourceUrlDto> pddResourceUrlDtoList = new ArrayList<>();

        PddDdkResourceUrlGenResponse response;
        if (resourceType==0){
            request.setResourceType(4);
            PddResourceUrlDto pddResourceUrlDto = new PddResourceUrlDto();
            response = client.syncInvoke(request);
            BeanUtils.copyProperties(response.getResourceUrlResponse(),pddResourceUrlDto);
            pddResourceUrlDto.setImgUrl("resource-4.jpg");
            pddResourceUrlDto.setName("限时秒杀");
            pddResourceUrlDtoList.add(pddResourceUrlDto);

            request.setResourceType(39996);
            pddResourceUrlDto = new PddResourceUrlDto();
            response = client.syncInvoke(request);
            BeanUtils.copyProperties(response.getResourceUrlResponse(),pddResourceUrlDto);
            pddResourceUrlDto.setImgUrl("resource-39996.jpg");
            pddResourceUrlDto.setName("百亿补贴");
            pddResourceUrlDtoList.add(pddResourceUrlDto);

            request.setResourceType(39997);
            pddResourceUrlDto = new PddResourceUrlDto();
            response = client.syncInvoke(request);
            BeanUtils.copyProperties(response.getResourceUrlResponse(),pddResourceUrlDto);
            pddResourceUrlDto.setImgUrl("resource-39997.jpg");
            pddResourceUrlDto.setName("充值中心");
            pddResourceUrlDtoList.add(pddResourceUrlDto);

            request.setResourceType(39998);
            pddResourceUrlDto = new PddResourceUrlDto();
            response = client.syncInvoke(request);
            BeanUtils.copyProperties(response.getResourceUrlResponse(),pddResourceUrlDto);
            pddResourceUrlDto.setImgUrl("resource-39998.jpg");
            pddResourceUrlDto.setName("每日活动");
            pddResourceUrlDtoList.add(pddResourceUrlDto);

            request.setResourceType(39999);
            pddResourceUrlDto = new PddResourceUrlDto();
            response = client.syncInvoke(request);
            BeanUtils.copyProperties(response.getResourceUrlResponse(),pddResourceUrlDto);
            pddResourceUrlDto.setImgUrl("resource-39999.jpg");
            pddResourceUrlDto.setName("电器城");
            pddResourceUrlDtoList.add(pddResourceUrlDto);

        }else {
            PddResourceUrlDto pddResourceUrlDto = new PddResourceUrlDto();
            if (resourceType==4){
                request.setResourceType(4);
                pddResourceUrlDto.setName("限时秒杀");
            }else if (resourceType==39996){
                pddResourceUrlDto.setName("百亿补贴");
            }else if (resourceType==39997){
                pddResourceUrlDto.setName("充值中心");
            }
            else if (resourceType==39998){
                pddResourceUrlDto.setName("每日活动");
            }
            else if (resourceType==39999){
                pddResourceUrlDto.setName("电器城");
            }
            request.setResourceType(resourceType);
            response = client.syncInvoke(request);
            BeanUtils.copyProperties(response.getResourceUrlResponse(),pddResourceUrlDto);
            pddResourceUrlDto.setImgUrl("resource-"+resourceType+".jpg");
            pddResourceUrlDtoList.add(pddResourceUrlDto);
        }
        result.setPddResourceUrlDtoList(pddResourceUrlDtoList);
        return result;

    }

//    private PddResourceUrlDto pddResourceUrlDto(PddDdkResourceUrlGenResponse.ResourceUrlResponse response){
//        PddResourceUrlDto pddResourceUrlDto = new PddResourceUrlDto();
//        pddResourceUrlDto.set
//        response.getSingleUrlList();
//    }

//    public static void main(String[] args) throws Exception {
//        PddActivityService pddActivityService = new PddActivityService();
//        PddDdkResourceUrlGenResponse.ResourceUrlResponse resourceUrlResponse = pddActivityService.getResourceUrl(4);
//        System.out.println(JsonUtil.transferToJson(resourceUrlResponse));
//    }


//    public PddDdkRpPromUrlGenerateResponse test(){
//        PopClient client = new PopHttpClient(clientId, clientSecret);
//        PddDdkRpPromUrlGenerateRequest request = new PddDdkRpPromUrlGenerateRequest();
//        reques
//        PddDdkThemeGoodsSearchResponse response = client.syncInvoke(request);
//        return response.getThemeListGetResponse();
//
//    }




}
