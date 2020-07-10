package com.frank.pdd.service;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:05 2020-05-26
 * @ Description：
 * @ Modified By：
 * 本接口用于以优惠券id维度查询商品优惠券详情信息（优惠券开始时间、结束时间、剩余张数），这些信息在goods.search和goods.detail接口也会随商品一起出现在您的查询接口，如果您没有以优惠券id为维度展示的需求，可直接用以上两个接口满足您的前端展示
 */
public class CouponInfoQueryService {

//import com.pdd.pop.sdk.common.util.JsonUtil;
//import com.pdd.pop.sdk.http.api.request.PddDdkCouponInfoQueryRequest;
//import com.pdd.pop.sdk.http.api.response.PddDdkCouponInfoQueryResponse;
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
//            PddDdkCouponInfoQueryRequest request = new PddDdkCouponInfoQueryRequest();
//            List<String> couponIds = new ArrayList<>();
//            couponIds.add('str');
//            request.setCouponIds(couponIds);
//            List<Long> mallIds = new ArrayList<>();
//            mallIds.add(0L);
//            request.setMallIds(mallIds);
//            PddDdkCouponInfoQueryResponse response = client.syncInvoke(request);
//            System.out.println(JsonUtil.transferToJson(response));
//        }
//    }
}
