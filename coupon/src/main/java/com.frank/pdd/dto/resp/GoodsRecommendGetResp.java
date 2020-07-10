package com.frank.pdd.dto.resp;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:01 2020-05-27
 * @ Description：
 * @ Modified By：
 */
@Data
public class GoodsRecommendGetResp {
    private String category_id;//类目id
    private String category_name;//分类名称
    private String cat_id;//商品类目id
    private List<Long> cat_ids;//商品一~四级类目ID列表
    private Long coupon_discount;//优惠券面额,单位为分
    private Long coupon_end_time;//优惠券失效时间,UNIX时间戳
    private Long coupon_min_order_amount;//优惠券门槛价格,单位为分
    private Long coupon_price;//优惠券金额
    private Long coupon_remain_quantity;//优惠券剩余数量
    private Long coupon_start_time;//优惠券生效时间,UNIX时间戳
    private Long coupon_total_quantity;//优惠券总数量
    private Long create_at;//创建时间
    private String desc_txt;//描述分
    private String goods_desc;//商品描述
    private Long goods_fact_price;//商品实际价格
    private String goods_gallery_urls;//商品详情图列表
    private Long goods_id;//商品id
    private String goods_image_url;//商品主图
    private Long goods_mark_price;//商品标准价格
    private String goods_name;//商品名称
    private Long goods_rate;//商品等级
    private String goods_thumbnail_url;//商品缩略图
    private Integer goods_type;//商品类型
    private Boolean has_coupon;//商品是否带券,true-带券,false-不带券
    private String lgst_txt;//物流分
    private Long mall_id;//商家id
    private String mall_name;//店铺名称
    private Long market_fee;//市场服务费
    private String merchant_type;//商家类型
    private Long  min_group_price;//最小成团价格，单位分
    private Long  min_normal_price;//最小单买价格，单位分
    private String opt_id;//商品标签类目ID,使用pdd.goods.opt.get获取
    private List<Long> opt_ids;//商品一~四级标签类目ID列表
    private String opt_name;//商品标签名
    private Long promotion_rate;//佣金比例,千分比
    private String qr_code_image_url;//二维码主图
    private String sales_tip;//销售量
    private String search_id;//搜索id，建议生成推广链接时候填写，提高收益。
    private String serv_txt;//服务分
    private String share_desc;//分享描述

}
