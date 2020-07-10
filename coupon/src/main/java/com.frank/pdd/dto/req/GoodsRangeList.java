package com.frank.pdd.dto.req;

import java.io.Serializable;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:05 2020-05-26
 * @ Description：
 * @ Modified By：
 */
public class GoodsRangeList implements Serializable {
    private Long range_from;//非必填	区间的开始值
    private Integer range_id;//非必填	0，最小成团价 1，券后价 2，佣金比例 3，优惠券价格 4，广告创建时间 5，销量 6，佣金金额 7，店铺描述分 8，店铺物流分 9，店铺服务分 10， 店铺描述分击败同行业百分比 11， 店铺物流分击败同行业百分比 12，店铺服务分击败同行业百分比 13，商品分 17 ，优惠券/最小团购价 18，过去两小时pv 19，过去两小时销量
    private Long range_to;//非必填	区间的结束值


    public Long getRange_from() {
        return range_from;
    }

    public void setRange_from(Long range_from) {
        this.range_from = range_from;
    }

    public Integer getRange_id() {
        return range_id;
    }

    public void setRange_id(Integer range_id) {
        this.range_id = range_id;
    }

    public Long getRange_to() {
        return range_to;
    }

    public void setRange_to(Long range_to) {
        this.range_to = range_to;
    }
}
