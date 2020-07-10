package com.frank.pdd;

import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsSearchRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse;

import java.util.ArrayList;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 10:07 2020-05-28
 * @ Description：
 * @ Modified By：
 */
public class PddSdkService {
    private static String clientId = "1022c5e2c6e140e9b0a4f2434192a9e0";
    private static String  clientSecret = "895e51bdb865adea524aa5712c59ffff44967d0b";
    private static String  HTTP = "http://gw-api.pinduoduo.com/api/router";
    private static String  HTTPS = "https://gw-api.pinduoduo.com/api/router";

    public static void main(String[] args) throws Exception {

        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddDdkGoodsSearchRequest request = new PddDdkGoodsSearchRequest();
        List<Integer> activityTags = new ArrayList();
        activityTags.add(0);
        request.setActivityTags(activityTags);
        request.setCatId(0L);
        request.setCustomParameters("str");
        List goodsIdList = new ArrayList<Long>();
        goodsIdList.add(0L);
        request.setGoodsIdList(goodsIdList);
        request.setIsBrandGoods(false);
        request.setKeyword("str");
        request.setListId("str");
        request.setMerchantType(0);
        List merchantTypeList = new ArrayList<Integer>();
        merchantTypeList.add(0);
        request.setMerchantTypeList(merchantTypeList);
        request.setOptId(0L);
        request.setPage(0);
        request.setPageSize(0);
        request.setPid("str");
        List<PddDdkGoodsSearchRequest.RangeListItem> rangeList = new ArrayList();

        PddDdkGoodsSearchRequest.RangeListItem item = new PddDdkGoodsSearchRequest.RangeListItem();
        item.setRangeFrom(0L);
        item.setRangeId(0);
        item.setRangeTo(0L);
        rangeList.add(item);
        request.setRangeList(rangeList);
        request.setSortType(0);
        request.setWithCoupon(false);
        PddDdkGoodsSearchResponse response = client.syncInvoke(request);
        System.out.println(JsonUtil.transferToJson(response));
    }




}
