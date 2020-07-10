package com.frank.pdd.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:11 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
public class GoodsUnitQueryResp{
   private Long coupon_end_time;//优惠券结束时间，单位：秒
   private String coupon_id;//优惠券id
   private Long coupon_start_time;//优惠券开始时间，单位：秒
   private Integer discount;//优惠券面额，单位：厘
   private Long init_quantity;//优惠券总数量
   private Integer rate;//商品的佣金比例，单位：千分位，比如100，表示10%
   private Long remain_quantity;//优惠券剩余数量
   private Integer unit_type;//商品的推广计划类型，1-通用推广，2-专属推广，3-招商推广，4-全店推广
}
