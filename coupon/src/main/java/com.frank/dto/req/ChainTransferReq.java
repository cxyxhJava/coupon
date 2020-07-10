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
 * @ Date       ：Created in 13:29 2020-06-25
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("商品转链传参")
public class ChainTransferReq {

    @NotBlank(message = "url不能为null")
    @ApiModelProperty(value = "链接",required = true)
    public String url;

    @Max(2)
    @Min(1)
    @NotNull(message = "type不能为null")
    @ApiModelProperty(value = "类型 1.拼多多 2.淘宝",required = true)
    public Integer type;

}
