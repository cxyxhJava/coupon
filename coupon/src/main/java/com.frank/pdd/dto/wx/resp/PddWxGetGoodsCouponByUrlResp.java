package com.frank.pdd.dto.wx.resp;

import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:40 2020-06-17
 * @ Description：
 * @ Modified By：
 */
public class PddWxGetGoodsCouponByUrlResp {

    private String appId;

    private String bannerUrl;

    private String desc;

    private String pagePath;

    private String sourceDisplayName;

    private String title;

    private String userName;

    public String getAppId() {
        return appId;
    }

    public void setAppId(String appId) {
        this.appId = appId;
    }

    public String getBannerUrl() {
        return bannerUrl;
    }

    public void setBannerUrl(String bannerUrl) {
        this.bannerUrl = bannerUrl;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getPagePath() {
        return pagePath;
    }

    public void setPagePath(String pagePath) {
        this.pagePath = pagePath;
    }

    public String getSourceDisplayName() {
        return sourceDisplayName;
    }

    public void setSourceDisplayName(String sourceDisplayName) {
        this.sourceDisplayName = sourceDisplayName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getWeAppIconUrl() {
        return weAppIconUrl;
    }

    public void setWeAppIconUrl(String weAppIconUrl) {
        this.weAppIconUrl = weAppIconUrl;
    }

    private String weAppIconUrl;





}
