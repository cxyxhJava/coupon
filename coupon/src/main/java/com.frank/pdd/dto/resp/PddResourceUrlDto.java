package com.frank.pdd.dto.resp;

import com.pdd.pop.ext.fasterxml.jackson.annotation.JsonProperty;
import com.pdd.pop.sdk.http.api.pop.response.PddDdkResourceUrlGenResponse;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:03 2020-06-01
 * @ Description：
 * @ Modified By：
 */
@Data
public class PddResourceUrlDto{


    private PddDdkResourceUrlGenResponse.ResourceUrlResponseMultiUrlList multiUrlList;

    private PddDdkResourceUrlGenResponse.ResourceUrlResponseQqAppInfo qqAppInfo;

    private String sign;

    private PddDdkResourceUrlGenResponse.ResourceUrlResponseSingleUrlList singleUrlList;

    private PddDdkResourceUrlGenResponse.ResourceUrlResponseWeAppInfo weAppInfo;

    private String name;

    private String imgUrl;
}
