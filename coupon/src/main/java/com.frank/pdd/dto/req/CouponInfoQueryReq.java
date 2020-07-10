package com.frank.pdd.dto.req;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:06 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
public class CouponInfoQueryReq extends BaseReq{
    private List<String> coupon_ids;//必填	优惠券id
    private List<Long> mall_ids;//非必填	店铺id
}
