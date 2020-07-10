package com.frank.pdd.service.top;

import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsRecommendGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkMerchantListGetRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkOauthTopGoodsListQueryRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkTopGoodsListQueryRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsRecommendGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkMerchantListGetResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkOauthTopGoodsListQueryResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkTopGoodsListQueryResponse;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.frank.pdd.common.Content.clientId;
import static com.frank.pdd.common.Content.clientSecret;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:27 2020-05-29
 * @ Description：爆品推荐
 * @ Modified By：
 *
 * 权限包“爆品推荐”共包含2个API：
 * 1. 多多客获取爆款排行商品接口：pdd.ddk.top.goods.list.query
 * 2. 运营频道商品查询API：pdd.ddk.goods.recommend.get
 */
@Component
public class TopGoodsService {

    /**
     * 多多客获取爆款排行商品接口
     * @param request
     * @return
     * @throws Exception
     */
    public PddDdkTopGoodsListQueryResponse.TopGoodsListGetResponse topGoodsList(PddDdkTopGoodsListQueryRequest request)throws Exception{
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkTopGoodsListQueryResponse response = client.syncInvoke(request);
        return response.getTopGoodsListGetResponse();
    }

    /**
     * 运营频道商品查询API：pdd.ddk.goods.recommend.get
     * 本接口用于查询进宝频道推广商品（入参channel_type：0-1.9包邮； 1-今日爆款；2-品牌清仓； 非必填 ,默认是1。
     * @param request
     * @return
     * @throws Exception
     */
    public PddDdkGoodsRecommendGetResponse.GoodsBasicDetailResponse goodsRecommend(PddDdkGoodsRecommendGetRequest request)throws Exception{
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkGoodsRecommendGetResponse response = client.syncInvoke(request);
        return response.getGoodsBasicDetailResponse();
    }

    public static void main(String[] args) throws Exception {
        TopGoodsService topGoodsService = new TopGoodsService();
        topGoodsService.topGoodsList(new PddDdkTopGoodsListQueryRequest());
    }

}
