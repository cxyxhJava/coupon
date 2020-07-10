package com.frank.pdd.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:23 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
public class GoodsBasicInfoGetList {
    private Long goods_id;//商品id
    private String goods_name;//商品标题
    private String goods_pic;//商品缩略图
    private Long min_group_price;//最小成团价格，单位分
    private Long min_normal_price;//最小单买价格，单位分
}
