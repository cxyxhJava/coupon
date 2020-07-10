package com.frank.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:50 2020-06-24
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("商品推广链接获取返回值")
public class GoodsPromoteUrlGetResp {

    @ApiModelProperty("手机端退关地址")
    public String phoneUrl;

    @ApiModelProperty("PC推广地址")
    public String pcUrl;

    @ApiModelProperty("商品详情")
    public GoodsPromoteUrlGoodsDetailDto goodsDetailDto;

    @ApiModelProperty("")
    public Integer type;




}
