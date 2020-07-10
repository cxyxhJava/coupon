package com.frank.pdd.dto.resp;

import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:33 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
public class GoodsList {
    private Integer[] activity_tags;//商品活动标记数组，例：[4,7]，24-品牌高佣；7-百亿补贴；20-行业精选；21-金牌商家；10044-潜力爆品；4-限时秒杀
    private Integer activity_type;//0-无活动;1-秒杀;3-限量折扣;12-限时折扣;13-大促活动;14-名品折扣;15-品牌清仓;16-食品超市;17-一元幸运团;18-爱逛街;19-时尚穿搭;20-男人帮;21-9块9;22-竞价活动;23-榜单活动;24-幸运半价购;25-定金预售;26-幸运人气购;27-特色主题活动;28-断码清仓;29-一元话费;30-电器城;31-每日好店;32-品牌卡;33-个性化首页;34-百亿补贴;35-推文;36-超级品类日;37-新衣馆;38-医药馆;101-大促搜索池;102-大促品类分会场;201-新人专享;202-月卡专享;300-定时开售;400-拼内购小程序特惠;
    private Long category_id;//商品类目ID，使用pdd.goods.cats.get接口获取
    private String category_name;//商品类目名
    private Long[] cat_ids;	//商品类目id
    private String clt_cpn_batch_sn;//店铺收藏券id
    private Long clt_cpn_discount;//店铺收藏券面额,单位为分
    private Long clt_cpn_end_time;//店铺收藏券截止时间
    private Long clt_cpn_min_amt;//店铺收藏券使用门槛价格,单位为分
    private Long clt_cpn_quantity;//店铺收藏券总量
    private Long clt_cpn_remain_quantity;//店铺收藏券剩余量
    private Long clt_cpn_start_time;//店铺收藏券起始时间
    private Long coupon_discount;//优惠券面额，单位为分
    private Long coupon_end_time;//优惠券失效时间，UNIX时间戳
    private Long coupon_min_order_amount;//优惠券门槛价格，单位为分
    private Long coupon_remain_quantity;//优惠券剩余数量
    private Long coupon_start_time;//优惠券生效时间，UNIX时间戳
    private Long coupon_total_quantity;//优惠券总数量
    private Long create_at;//创建时间（unix时间戳）
    private String desc_txt;//描述分
    private String goods_desc;//商品描述
    private String[] goods_gallery_urls;//商品轮播图
    private Long goods_id;//商品id
    private String goods_image_url;//商品主图
    private String goods_name;//商品名称
    private String goods_thumbnail_url;//商品缩略图
    private Boolean has_coupon;//商品是否有优惠券 true-有，false-没有
    private Boolean has_mall_coupon;//是否有店铺券
    private String lgst_txt;//物流分
    private Integer mall_coupon_discount_pct;//店铺券折扣
    private Long mall_coupon_end_time;//店铺券结束使用时间
    private Long mall_coupon_id;//店铺券id
    private Integer mall_coupon_max_discount_amount;//最大使用金额
    private Integer mall_coupon_min_order_amount;//最小使用金额
    private Long mall_coupon_remain_quantity;//店铺券余量
    private Long mall_coupon_start_time;//店铺券开始使用时间
    private Long mall_coupon_total_quantity;//店铺券总量
    private Integer mall_cps;//该商品所在店铺是否参与全店推广，0：否，1：是
    private Long mall_id;//店铺id
    private String mall_name;//店铺名字
    private Integer merchant_type;//店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店
    private Long min_group_price;//最小拼团价（单位为分）
    private Long min_normal_price;//最小单买价格（单位为分）
    private Boolean only_scene_auth;//快手专享
    private Long opt_id;//商品标签ID，使用pdd.goods.opts.get接口获取
    private Long[] opt_ids;//商品标签id
    private String opt_name;//商品标签名
    private Integer plan_type;//推广计划类型 3:定向 4:招商
    private Long promotion_rate;//佣金比例，千分比
    private String sales_tip;//已售卖件数
    private String search_id;//搜索id，建议生成推广链接时候填写，提高收益
    private Long[] service_tags;//服务标签: 4-送货入户并安装,5-送货入户,6-电子发票,9-坏果包赔,11-闪电退款,12-24小时发货,13-48小时发货,17-顺丰包邮,18-只换不修,19-全国联保,20-分期付款,24-极速退款,25-品质保障,26-缺重包退,27-当日发货,28-可定制化,29-预约配送,1000001-正品发票,1000002-送货入户并安装
    private String serv_txt;//服务分
    private Long zs_duo_id;//招商团长id
}
