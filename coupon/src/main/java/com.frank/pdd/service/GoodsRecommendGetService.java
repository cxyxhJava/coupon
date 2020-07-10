package com.frank.pdd.service;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:04 2020-05-27
 * @ Description：
 * @ Modified By：
 * 多多进宝商品推荐API：pdd.ddk.goods.recommend.get
 * 本接口用于查询进宝频道推广商品（入参channel_type：0-1.9包邮；1-今日爆款；2-品牌清仓； 非必填 ,默认是1。）
 */
public class GoodsRecommendGetService {
//package com.pdd.pop.sdk.http.demo;
//
//import com.pdd.pop.sdk.common.util.JsonUtil;
//import com.pdd.pop.sdk.http.api.request.PddDdkGoodsRecommendGetRequest;
//import com.pdd.pop.sdk.http.api.response.PddDdkGoodsRecommendGetResponse;
//import com.pdd.pop.sdk.http.PopClient;
//import com.pdd.pop.sdk.http.PopHttpClient;
//
//import java.util.*;
//
//    public class PopClientDemo {
//
//        public static void main(String[] args) throws Exception {
//
//            String clientId = "your clientId";
//            String clientSecret = "your clientSecret";
//            PopClient client = new PopHttpClient(clientId, clientSecret);
//
//            PddDdkGoodsRecommendGetRequest request = new PddDdkGoodsRecommendGetRequest();
//            request.setChannelType(0);
//            request.setCustomParameters('str');
//            request.setLimit(0);
//            request.setListId('str');
//            request.setOffset(0);
//            request.setPid('str');
//            request.setCatId(0L);
//            List<Long> goodsIds = new ArrayList<>();
//            goodsIds.add(0L);
//            request.setGoodsIds(goodsIds);
//            PddDdkGoodsRecommendGetResponse response = client.syncInvoke(request);
//            System.out.println(JsonUtil.transferToJson(response));
//        }
//    }
}
