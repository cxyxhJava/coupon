package com.frank.pdd.dto.resp;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:52 2020-05-27
 * @ Description：
 * @ Modified By：
 */
@Data
public class TopGoodsListQueryResp {
    private List<Long> cat_ids;//商品类目id
    private Long coupon_discount;//优惠券面额，单位为分
    private Long coupon_end_time;//优惠券失效时间，UNIX时间戳
    private Long coupon_min_order_amount;//优惠券门槛价格，单位为分
    private Long coupon_remain_quantity;//优惠券剩余数量
    private Long coupon_start_time;//优惠券生效时间，UNIX时间戳
    private Long coupon_total_quantity;//优惠券总数量
    private String desc_txt;//描述评分
    private String goods_desc;//商品描述
    private List<String> goods_gallery_urls;//商品轮播图
    private Long goods_id;//商品id
    private String goods_image_url;//商品主图
    private String goods_name;//商品名称
    private String goods_thumbnail_url;//商品缩略图
    private String lgst_txt;//服务评分
    private Long mall_id;//店铺id
    private String mall_name;//店铺名字
    private Long min_group_price;//最小拼团价（单位为分）
    private Long min_normal_price;//最小单买价格（单位为分）
    private Long opt_id;//商品标签ID，使用pdd.goods.opts.get接口获取
    private List<Long> opt_ids;//商品标签id
    private String opt_name;//商品标签名
    private Long promotion_rate;//佣金比例，千分比
    private String sales_tip;//已售卖件数
    private String search_id;//搜索id，建议生成推广链接时候填写，提高收益
    private String serv_txt;//物流评分
}
