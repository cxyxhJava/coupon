package com.frank.dto.resp;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:17 2020-06-25
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("获取推广链接 商品信息")
public class GoodsPromoteUrlGoodsDetailDto {

    @ApiModelProperty("商品图片")
    private String imageUrl;

    @ApiModelProperty("商品名称")
    private String name;

    @ApiModelProperty("商品价格")
    private Long price;

    @ApiModelProperty("优惠券价格")
    private Long couponPrice;


}
