package com.frank.jd;

import com.jd.open.api.sdk.DefaultJdClient;
import com.jd.open.api.sdk.JdClient;
import com.jd.open.api.sdk.JdException;
import jd.union.open.category.goods.get.request.CategoryReq;
import jd.union.open.category.goods.get.request.UnionOpenCategoryGoodsGetRequest;
import jd.union.open.category.goods.get.response.CategoryResp;
import jd.union.open.category.goods.get.response.UnionOpenCategoryGoodsGetResponse;
import jd.union.open.goods.jingfen.query.request.JFGoodsReq;
import jd.union.open.goods.jingfen.query.request.UnionOpenGoodsJingfenQueryRequest;
import jd.union.open.goods.jingfen.query.response.JFGoodsResp;
import jd.union.open.goods.jingfen.query.response.UnionOpenGoodsJingfenQueryResponse;

import java.util.Arrays;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 09:10 2020-05-28
 * @ Description：
 * @ Modified By：
 */

public class JdSdkService {
    private static final String SERVER_URL = "https://router.jd.com/api";
    private static final String accessToken="";
    private static final String appKey = "410ce7d2f891853237d0c56cc899ddac";
    private static final String appSecret = "06080558c8af43f3b754ac18ca9f2ad7";


    /**
     * jd.union.open.goods.jingfen.query 京粉精选商品查询接口
     * https://union.jd.com/openplatform/api/10417
     * @return
     * @throws JdException
     */
    public List<JFGoodsResp> goodsJingfenQuery(JFGoodsReq goodsReq) throws JdException {
        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
        UnionOpenGoodsJingfenQueryRequest request=new UnionOpenGoodsJingfenQueryRequest();
        request.setGoodsReq(goodsReq);
        UnionOpenGoodsJingfenQueryResponse response=client.execute(request);
        if (response.getData()==null){
           //TODO 添加错误日志
        }
        return Arrays.asList(response.getData());
    }

//    public (){
//        30162117836
//    }


//    public static void main(String[] args) throws JdException {
//        String SERVER_URL = "https://router.jd.com/api";
//        String accessToken="";
//        String appKey = "410ce7d2f891853237d0c56cc899ddac";
//        String appSecret = "06080558c8af43f3b754ac18ca9f2ad7";
//
//        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
//        UnionOpenGoodsQueryRequest request=new UnionOpenGoodsQueryRequest();
//        GoodsReq goodsReqDTO=new GoodsReq();
//        request.setGoodsReqDTO(goodsReqDTO);
//        UnionOpenGoodsQueryResponse response=client.execute(request);
//        System.out.println(response);
//    }
//    public static void main(String[] args) throws JdException {
//        String SERVER_URL = "https://router.jd.com/api";
//        String accessToken="";
//        String appKey = "410ce7d2f891853237d0c56cc899ddac";
//        String appSecret = "06080558c8af43f3b754ac18ca9f2ad7";
//        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
//        UnionOpenPromotionCommonGetRequest request=new UnionOpenPromotionCommonGetRequest();
//        PromotionCodeReq req = new PromotionCodeReq();
//        req.setMaterialId("https://item.jd.com/64512247153.html");
//        req.setSiteId("4000172950");
//        request.setPromotionCodeReq(req);
//        PromotionCodeReq promotionCodeReq=new PromotionCodeReq();
//        request.setPromotionCodeReq(promotionCodeReq);
//        UnionOpenPromotionCommonGetResponse response = client.execute(request);
//
//        System.out.println(response.getCode());
//        System.out.println(response.getData());
//        System.out.println(response.getMessage());
//        System.out.println(response.getSysOriginalMsg());
//        System.out.println(response.getSysOriginalMsg());
//
//    }

    public static void main(String[] args) throws JdException {
        JdSdkService jdSdkService = new JdSdkService();
        //jdSdkService.categoryGoodsGet();
        JFGoodsReq req = new JFGoodsReq();
        req.setEliteId(1);
        List<JFGoodsResp> respList = jdSdkService.goodsJingfenQuery(req);
        System.out.println(respList.size());
    }

    /**
     * 获取商品类目
     */
    public void categoryGoodsGet() throws JdException {
        JdClient client=new DefaultJdClient(SERVER_URL,accessToken,appKey,appSecret);
        UnionOpenCategoryGoodsGetRequest request=new UnionOpenCategoryGoodsGetRequest();
        CategoryReq req=new CategoryReq();
        req.setGrade(2);
        req.setParentId(654);
        request.setReq(req);
        UnionOpenCategoryGoodsGetResponse response=client.execute(request);
        CategoryResp[] categoryResps = response.getData();
        List<CategoryResp> list = Arrays.asList(categoryResps);
        for (CategoryResp categoryResp : list) {
            System.out.println(categoryResp.toString());
            System.out.println("id:"+categoryResp.getId()+"name:"+categoryResp.getName()+"parentId:"+categoryResp.getParentId()+"grade:"+categoryResp.getGrade());
        }
//        System.out.println(response.getCode());
//        System.out.println(response.getData());
//        System.out.println(response.getMessage());
//        System.out.println(response.getSysOriginalMsg());
//        System.out.println(response.getSysOriginalMsg());
    }





}
