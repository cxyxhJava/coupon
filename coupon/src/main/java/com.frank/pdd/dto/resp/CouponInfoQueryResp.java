package com.frank.pdd.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:05 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
public class CouponInfoQueryResp {
    private Long coupon_end_time;//优惠券结束时间
    private String coupon_id;//优惠券id
    private Long  coupon_start_time;//优惠券开始时间
    private Integer coupon_type;//优惠券类型
    private Long  discount;//优惠券面额 单位：厘
    private Long  init_quantity;//优惠券总量
    private Long  remain_quantity;//优惠券剩余数量
}
