package com.frank.pdd.dto.req;

import javax.validation.constraints.NotBlank;
import java.io.Serializable;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:58 2020-06-09
 * @ Description：
 * @ Modified By：
 */

public class PddDdkGoodsZsUnitUrlGenReq implements Serializable {

    @NotBlank(message = "sourceUrl不能为空")
    private String sourceUrl;

    public String getSourceUrl() {
        return sourceUrl;
    }

    public void setSourceUrl(String sourceUrl) {
        this.sourceUrl = sourceUrl;
    }
}
