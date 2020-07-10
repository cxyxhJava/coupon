package com.frank.pdd.dto.req;

import lombok.Builder;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:09 2020-06-04
 * @ Description：
 * @ Modified By：
 */
public class PddGoodsPromotionUrlGenerateReq implements Serializable {
    private String customParameters;//非必填	自定义参数，为链接打上自定义标签；自定义参数最长限制64个字节；格式为： {"uid":"11111","sid":"22222"} ，其中 uid 用户唯一标识，可自行加密后传入，每个用户仅且对应一个标识，必填； sid 上下文信息标识，例如sessionId等，非必填。该json字符串中也可以加入其他自定义的key
    private Boolean generateMallCollectCoupon;//	BOOLEAN	非必填	是否生成店铺收藏券推广链接
    private Boolean generateQqApp;//	BOOLEAN	非必填	是否生成qq小程序
    private Boolean generateSchemaUrl;//	BOOLEAN	非必填	是否返回 schema URL
    private Boolean generateShortUrl;//	BOOLEAN	非必填	是否生成短链接，true-是，false-否
    private Boolean generateWeappWebview;//	BOOLEAN	非必填	是否生成唤起微信客户端链接，true-是，false-否，默认false
    private Boolean generateWeiboappWebview;//	BOOLEAN	非必填	是否生成微博推广链接
    private Boolean generateWeApp;//	BOOLEAN	非必填	是否生成小程序推广
    private List<Long> goodsIdList;//	LONG[]	必填	商品ID，仅支持单个查询
    private Boolean multiGroup;//	BOOLEAN	非必填	true--生成多人团推广链接 false--生成单人团推广链接（默认false）1、单人团推广链接：用户访问单人团推广链接，可直接购买商品无需拼团。2、多人团推广链接：用户访问双人团推广链接开团，若用户分享给他人参团，则开团者和参团者的佣金均结算给推手
    private String pId;//	STRING	必填	推广位ID
    private String searchId;//	STRING	非必填	搜索id，建议填写，提高收益。来自pdd.ddk.goods.recommend.get、pdd.ddk.goods.search、pdd.ddk.top.goods.list.query等接口
    private Long zsDuoId;//	LONG	非必填	招商多多客ID

    public String getCustomParameters() {
        return customParameters;
    }

    public void setCustomParameters(String customParameters) {
        this.customParameters = customParameters;
    }

    public Boolean getGenerateMallCollectCoupon() {
        return generateMallCollectCoupon;
    }

    public void setGenerateMallCollectCoupon(Boolean generateMallCollectCoupon) {
        this.generateMallCollectCoupon = generateMallCollectCoupon;
    }

    public Boolean getGenerateQqApp() {
        return generateQqApp;
    }

    public void setGenerateQqApp(Boolean generateQqApp) {
        this.generateQqApp = generateQqApp;
    }

    public Boolean getGenerateSchemaUrl() {
        return generateSchemaUrl;
    }

    public void setGenerateSchemaUrl(Boolean generateSchemaUrl) {
        this.generateSchemaUrl = generateSchemaUrl;
    }

    public Boolean getGenerateShortUrl() {
        return generateShortUrl;
    }

    public void setGenerateShortUrl(Boolean generateShortUrl) {
        this.generateShortUrl = generateShortUrl;
    }

    public Boolean getGenerateWeappWebview() {
        return generateWeappWebview;
    }

    public void setGenerateWeappWebview(Boolean generateWeappWebview) {
        this.generateWeappWebview = generateWeappWebview;
    }

    public Boolean getGenerateWeiboappWebview() {
        return generateWeiboappWebview;
    }

    public void setGenerateWeiboappWebview(Boolean generateWeiboappWebview) {
        this.generateWeiboappWebview = generateWeiboappWebview;
    }

    public Boolean getGenerateWeApp() {
        return generateWeApp;
    }

    public void setGenerateWeApp(Boolean generateWeApp) {
        this.generateWeApp = generateWeApp;
    }

    public List<Long> getGoodsIdList() {
        return goodsIdList;
    }

    public void setGoodsIdList(List<Long> goodsIdList) {
        this.goodsIdList = goodsIdList;
    }

    public Boolean getMultiGroup() {
        return multiGroup;
    }

    public void setMultiGroup(Boolean multiGroup) {
        this.multiGroup = multiGroup;
    }

    public String getpId() {
        return pId;
    }

    public void setpId(String pId) {
        this.pId = pId;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public Long getZsDuoId() {
        return zsDuoId;
    }

    public void setZsDuoId(Long zsDuoId) {
        this.zsDuoId = zsDuoId;
    }
}
