package com.frank.pdd.service.merchant;

import com.frank.pdd.common.Content;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkMallUrlGenRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkMerchantListGetRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkMallUrlGenResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkMerchantListGetResponse;
import org.springframework.stereotype.Component;

import java.util.List;

import static com.frank.pdd.common.Content.clientId;
import static com.frank.pdd.common.Content.clientSecret;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:47 2020-05-28
 * @ Description：店铺相关接口
 * @ Modified By：
 */
@Component
public class MerchantService {

    /**
     * pdd.ddk.merchant.list.get多多客查店铺列表接口
     * https://open.pinduoduo.com/application/document/api?id=pdd.ddk.cms.prom.url.generate&permissionId=2
     * @param request
     * @return
     * @throws Exception
     */
    public List<PddDdkMerchantListGetResponse.MerchantListResponseMallSearchInfoVoListItem> list(PddDdkMerchantListGetRequest request) throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddDdkMerchantListGetResponse response = client.syncInvoke(request);
        return response.getMerchantListResponse().getMallSearchInfoVoList();
    }


    public List<PddDdkMallUrlGenResponse.MallCouponGenerateUrlResponseListItem> getCouponUrl(PddDdkMallUrlGenRequest request) throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);
        PddDdkMallUrlGenResponse response = client.syncInvoke(request);
        return response.getMallCouponGenerateUrlResponse().getList();
    }

    public static void main(String[] args) throws Exception {
        MerchantService merchantService = new MerchantService();

        merchantService.list(new PddDdkMerchantListGetRequest());
    }






}
