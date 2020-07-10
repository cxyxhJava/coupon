package com.frank.pdd.dto.wx.req;

import java.io.Serializable;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:40 2020-06-17
 * @ Description：
 * @ Modified By：
 */
public class PddWxGetGoodsCouponByUrlReq implements Serializable {

    private String url;

    private Integer type;

    private Long goodsId;

    private String searchId;

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Long getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Long goodsId) {
        this.goodsId = goodsId;
    }

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }
}
