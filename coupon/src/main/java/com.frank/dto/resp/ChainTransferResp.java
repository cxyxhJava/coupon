package com.frank.dto.resp;

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
@ApiModel("商品转链返回值")
public class ChainTransferResp {

    @ApiModelProperty("手机端推广地址")
    public String phoneUrl;

    @ApiModelProperty("手机端 团购地址 拼多多独有")
    public String groupPhoneUrl;

    @ApiModelProperty("PC端 团购地址 拼多多独有")
    public String groupPcUrl;

    @ApiModelProperty("PC推广地址 拼多多设置手机地址")
    public String pcUrl;

    @ApiModelProperty("类型 1.拼多多 2.淘宝")
    public Integer type;

}
