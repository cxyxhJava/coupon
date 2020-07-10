package com.frank.pdd.service.pId;

import com.pdd.pop.sdk.common.util.JsonUtil;
import com.pdd.pop.sdk.http.PopClient;
import com.pdd.pop.sdk.http.PopHttpClient;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPidGenerateRequest;
import com.pdd.pop.sdk.http.api.pop.request.PddDdkGoodsPidQueryRequest;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPidGenerateResponse;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsPidQueryResponse;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

import static com.frank.pdd.common.Content.clientId;
import static com.frank.pdd.common.Content.clientSecret;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:16 2020-05-29
 * @ Description：
 * @ Modified By：
 */
@Component
public class PIdService {

//    public static void main(String[] args) throws Exception {
//        PIdService pIdService = new PIdService();
//        List<String> pidNameList = new ArrayList<>();
//        pidNameList.add("小哈1号");
//        pidNameList.add("小哈2号");
//        pIdService.addPid(pidNameList);
//        pIdService.getPidList();
//
//    }

    /**
     * 生成pid
     * @param nameList
     * @return
     * @throws Exception
     */
    public PddDdkGoodsPidGenerateResponse.PIdGenerateResponse addPid(List<String> nameList) throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddDdkGoodsPidGenerateRequest request = new PddDdkGoodsPidGenerateRequest();
        request.setNumber(Long.valueOf(nameList.size())); //要生成的推广位数量，默认为10，范围为：1~100
        request.setPIdNameList(nameList);
        PddDdkGoodsPidGenerateResponse response = client.syncInvoke(request);
        System.out.println(JsonUtil.transferToJson(response));
        return response.getPIdGenerateResponse();
    }


    /**
     * 查询已经生成的推广位信息：pdd.ddk.goods.pid.query
     * @return
     * @throws Exception
     */
    public PddDdkGoodsPidQueryResponse.PIdQueryResponse getPidList() throws Exception {
        PopClient client = new PopHttpClient(clientId, clientSecret);

        PddDdkGoodsPidQueryRequest request = new PddDdkGoodsPidQueryRequest();
        request.setPage(0);
        request.setPageSize(10);
        //List<String> pidList = new ArrayList<>();
        //pidList.add("str");
        //request.setPidList(pidList);
        PddDdkGoodsPidQueryResponse response = client.syncInvoke(request);
        System.out.println(JsonUtil.transferToJson(response));
        return response.getPIdQueryResponse();
    }




}
