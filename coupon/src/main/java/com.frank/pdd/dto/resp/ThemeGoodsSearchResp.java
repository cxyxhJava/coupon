package com.frank.pdd.dto.resp;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:06 2020-05-27
 * @ Description：
 * @ Modified By：
 */
@Data
public class ThemeGoodsSearchResp {
    private List<Integer> cat_ids;//商品一~四级类目ID列表
    private Long coupon_discount;//优惠券面额,单位为分
    private Long coupon_end_time;//优惠券失效时间,UNIX时间戳
    private Long coupon_min_order_amount;//优惠券门槛价格,单位为分
    private Long coupon_remain_quantity;//优惠券剩余数量
    private Long coupon_start_time;//优惠券生效时间,UNIX时间戳
    private Long coupon_total_quantity;//优惠券总数量
    private String desc_txt;//描述分
    private String goods_desc;//商品描述
    private List<String> goods_gallery_urls;//商品详情图列表
    private Long goods_id;//商品编码
    private String goods_image_url;//商品主图
    private String goods_name;//商品名称
    private String goods_thumbnail_url;//商品缩略图
    private Boolean has_coupon;//商品是否带券,true-带券,false-不带券
    private String lgst_txt;//物流分
    private String mall_name;//店铺名称
    private Long min_group_price;//最小拼团价格,单位为分
    private Long min_normal_price;//最小单买价格,单位为分
    private Long opt_id;//商品标签类目ID,使用pdd.goods.opt.get获取
    private String opt_name;//商品标签名
    private Long promotion_rate;//佣金比例,千分比
    private String sales_tip;//已售卖件数
    private String serv_txt;//服务分


}
