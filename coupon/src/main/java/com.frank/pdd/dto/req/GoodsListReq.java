package com.frank.pdd.dto.req;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 12:25 2020-06-24
 * @ Description：商品搜索传参
 * @ Modified By：
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ApiModel("商品搜索传参")
public class GoodsListReq {

    @Min(1)
    @Max(2)
    @NotNull(message = "type不能为null")
    @ApiModelProperty(value = "1.拼多多 2.淘宝",required = true)
    private Integer type;

    //搜索关键字
    @ApiModelProperty("搜索关键字")
    private String keyword;

    //商品idList  有这个 优先这个
    @ApiModelProperty("商品idList  有这个 优先这个")
    private List<String> goodsIdList;

    @ApiModelProperty("排序 0.默认综合 1.价格倒叙 2.价格升序 3.销量倒叙 4.销量升序 5.券后倒叙 6.券后升序")
    private Integer sort;

    @ApiModelProperty("页数 从1开始 默认1")
    private Integer pageNo;

    @Min(10)
    @ApiModelProperty("每页个数 最小为10 默认10")
    private Integer pageSize;
}
