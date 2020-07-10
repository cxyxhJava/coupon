package com.frank.pdd.dto.wx.resp;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:25 2020-06-17
 * @ Description：微信小程序 pdd商品列表查询传参
 * @ Modified By：
 */
public class PddWxGoodsListResp {

    /**
     * 商品描述
     */
    private String goodsDesc;

    /**
     * 商品主图
     */
    private String goodsImageUrl;

    /**
     * 商品名称
     */
    private String goodsName;

    /**
     * 商品id
     */
    private Long goodsId;

    /**
     * 店铺id
     */
    private Long mallId;

    /**
     * 店铺名称
     */
    private String mallName;

    /**
     * 最小 团购价格
     */
    private Double minGroupPrice;

    /**
     * 最小单买价格
     */
    private Double minNormalPrice;

    /**
     * 优惠券价格
     */
    private Double couponDiscount;

    /**
     * 已售
     */
    private String salesTip;

    public String getSalesTip() {
        return salesTip;
    }

    public void setSalesTip(String salesTip) {
        this.salesTip = salesTip;
    }

    public String getGoodsDesc() {
        return goodsDesc;
    }

    public void setGoodsDesc(String goodsDesc) {
        this.goodsDesc = goodsDesc;
    }

    public String getGoodsImageUrl() {
        return goodsImageUrl;
    }

    public void setGoodsImageUrl(String goodsImageUrl) {
        this.goodsImageUrl = goodsImageUrl;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public Long getMallId() {
        return mallId;
    }

    public void setMallId(Long mallId) {
        this.mallId = mallId;
    }

    public String getMallName() {
        return mallName;
    }

    public void setMallName(String mallName) {
        this.mallName = mallName;
    }

    public Double getMinGroupPrice() {
        return minGroupPrice;
    }

    public void setMinGroupPrice(Double minGroupPrice) {
        this.minGroupPrice = minGroupPrice;
    }

    public Double getMinNormalPrice() {
        return minNormalPrice;
    }

    public void setMinNormalPrice(Double minNormalPrice) {
        this.minNormalPrice = minNormalPrice;
    }

    public Double getCouponDiscount() {
        return couponDiscount;
    }

    public void setCouponDiscount(Double couponDiscount) {
        this.couponDiscount = couponDiscount;
    }
}
