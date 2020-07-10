package com.frank.pdd.dto.resp;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:17 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
public class MallGoodsListGetResp {
    private Long category_id;//商品类目id
    private String category_name;//商品类目名
    private Long cat_id;//商品类目ID
    private List<Long> cat_ids;//商品标签ID（多级）
    private Long coupon_discount;//优惠券面额（单位为分）
    private Long coupon_end_time;//优惠券结束时间（unix时间戳）
    private Long coupon_min_order_amount;//优惠券最小门槛价（单位为分）
    private Long coupon_price;//优惠券面额
    private Long coupon_remain_quantity;//优惠券剩余数量
    private Long coupon_start_time;//优惠券开始时间（unix时间戳）
    private Long coupon_total_quantity;//优惠券总数量
    private Long create_at;//商品创建时间（UNIX时间戳）
    private String desc_txt;//描述分
    private String goods_desc;//商品描述
    private Long goods_fact_price;//商品实际价格（单位为分）
    private String goods_gallery_urls;//商品轮播图
    private Long goods_id;//商品id
    private String goods_image_url;//商品主图
    private Long goods_mark_price;//商品市场价（单位为分）
    private String goods_name;//商品名称
    private Long goods_rate;//商品佣金比（千分比）
    private String goods_thumbnail_url;//商品缩略图
    private Integer goods_type;//商品类型，1-普通商品，2-进口商品，3-直供，4-直邮
    private Boolean has_coupon;//是否有优惠券
    private String lgst_txt;//物流分
    private Integer mall_cps;//该商品所在店铺是否参与全店推广，0：否，1：是
    private Long mall_id;//店铺id
    private String mall_name;//店铺名称
    private Long mall_rate;//全店推广店铺佣金比（千分比）
    private Long market_fee;//佣金（单位为分）
    private Integer merchant_type;//店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部）
    private Long min_group_price;//商品拼团价（单位为分）
    private Long min_normal_price;//商品单买价（单位为分）
    private Long opt_id;//商品标签id
    private List<Long> opt_ids;//商品标签ID
    private String opt_name;//商品标签名
    private Long promotion_rate;//佣金比（千分比）
    private String qr_code_image_url;//聊天二维码图片url
    private String sales_tip;//已售卖件数
    private String serv_txt;//服务分
    private String share_desc;//分享文案
}
