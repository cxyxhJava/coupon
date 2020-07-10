package com.frank.pdd.dto.resp;

import lombok.Builder;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:39 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
public class GoodsDetail {
    private Long category_id;//商品类目ID，使用pdd.goods.cats.get接口获取
    private String category_name;//商品类目名
    private Long cat_id;//商品类目ID，使用pdd.goods.cats.get接口获取
    private Integer[] cat_ids;//商品一~四级类目ID列表
    private String clt_cpn_batch_sn;//店铺收藏券id
    private Long clt_cpn_discount;//店铺收藏券面额,单位为分
    private Long clt_cpn_end_time;//店铺收藏券截止时间
    private Long clt_cpn_min_amt;//店铺收藏券使用门槛价格,单位为分
    private Long clt_cpn_quantity;//店铺收藏券总量
    private Long clt_cpn_remain_quantity;//店铺收藏券剩余量
    private Long clt_cpn_start_time;//店铺收藏券起始时间
    private Long coupon_discount;//优惠券面额，单位为分
    private Long coupon_end_time;//优惠券失效时间，UNIX时间戳
    private Long coupon_min_order_amount;//优惠券门槛金额，单位为分
    private Long coupon_remain_quantity;//优惠券剩余数量
    private Long coupon_start_time;//优惠券生效时间，UNIX时间戳
    private Long coupon_total_quantity;//优惠券总数量
    private Long create_at;//创建时间（unix时间戳）
    private String desc_txt;//描述分
    private String goods_desc;//参与多多进宝的商品描述
    private String[] goods_gallery_urls;//商品轮播图
    private Long goods_id;//参与多多进宝的商品ID
    private String goods_image_url;//多多进宝商品主图
    private String goods_name;//参与多多进宝的商品标题
    private String goods_thumbnail_url;//商品缩略图
    private Boolean has_coupon;//商品是否有优惠券 true-有，false-没有
    private Boolean has_mall_coupon;//是否有店铺券
    private String lgst_txt;//物流分
    private Integer mall_coupon_discount_pct;//店铺折扣
    private Long mall_coupon_end_time;//店铺券使用结束时间
    private Integer mall_coupon_max_discount_amount;//最大使用金额
    private Integer mall_coupon_min_order_amount;//最小使用金额
    private Long mall_coupon_remain_quantity;//店铺券余量
    private Long mall_coupon_start_time;//店铺券使用开始时间
    private Long mall_coupon_total_quantity;//店铺券总量
    private Integer mall_cps;//该商品所在店铺是否参与全店推广，0：否，1：是
    private Long mall_id;//商家id
    private String mall_name;//店铺名称
    private Integer merchant_type;//店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部）
    private Long min_group_price;//最低价sku的拼团价，单位为分
    private Long min_normal_price;//最低价sku的单买价，单位为分
    private Boolean only_scene_auth;//快手专享
    private Long opt_id;//商品标签ID，使用pdd.goods.opt.get接口获取
    private Integer[] opt_ids;//商品标签ID
    private String opt_name;//商品标签名称
    private Integer plan_type;//推广计划类型
    private Long promotion_rate;//佣金比例，千分比
    private String sales_tip;//已售卖件数
    private Integer[] service_tags;//服务标签: 4-送货入户并安装,5-送货入户,6-电子发票,9-坏果包赔,11-闪电退款,12-24小时发货,13-48小时发货,17-顺丰包邮,18-只换不修,1可定制化,29-预约配送,1000001-正品发票,1000002-送货入户并安装
    private String serv_txt;//服务分
    private Long zs_duo_id;//招商团长id
    private String[] video_urls;//商品视频url

}
