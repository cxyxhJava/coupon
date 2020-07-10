package com.frank.pdd.dto.req;

import lombok.Builder;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:36 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
public class GoodsDetailReq extends BaseReq {
    private String custom_parameters;//非必填	自定义参数
    private Long[] goods_id_list;//必填	商品ID，仅支持单个查询。例如：[123456]
    private String pid;//非必填	推广位id
    private Integer plan_type;//非必填	佣金优惠券对应推广类型，3：专属 4：招商
    private String search_id;//非必填	搜索id，建议填写，提高收益。来自pdd.ddk.goods.recommend.get、pdd.ddk.goods.search、pdd.ddk.top.goods.list.query等接口
    private Long zs_duo_id;//非必填	招商多多客ID
}

