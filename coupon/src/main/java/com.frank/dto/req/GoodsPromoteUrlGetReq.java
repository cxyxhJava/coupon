package com.frank.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

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
@ApiModel("商品推广链接获取传参")
public class GoodsPromoteUrlGetReq {

    @Max(2)
    @Min(1)
    @NotNull(message = "type不能为空")
    @ApiModelProperty(value = "类型 1.拼多多 2.淘宝",required = true)
    private Integer type;

    @NotBlank(message = "商品id不能为空")
    @ApiModelProperty(value = "商品id",required = true)
    private String goodsId;

    @NotNull(message = "platform不能为空")
    @ApiModelProperty(value = "平台 1：PC，2：无线",required = true)
    private Long platform;

}
