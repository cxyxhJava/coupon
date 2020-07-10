package com.frank.pdd.dto.req;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:59 2020-05-27
 * @ Description：
 * @ Modified By：
 */
@Data
public class GoodsRecommendGetReq extends BaseReq {
    private Integer channel_type;//非必填	0-1.9包邮, 1-今日爆款, 2-品牌清仓,3-相似商品推荐,4-猜你喜欢,5-实时热销,6-实时收益,7-今日畅销,8-高佣榜单，默认1
    private String custom_parameters;//非必填	自定义参数，为链接打上自定义标签；自定义参数最长限制64个字节；格式为： {"uid":"11111","sid":"22222"} ，其中 uid 用户唯一标识，可自行加密后传入，每个用户仅且对应一个标识，必填； sid 上下文信息标识，例如sessionId等，非必填。该json字符串中也可以加入其他自定义的key
    private Integer limit;//非必填	请求数量；默认值 ： 400
    private String list_id;//非必填	翻页时建议填写前页返回的list_id值
    private Integer offset;//非必填	从多少位置开始请求；默认值 ： 0，offset需是limit的整数倍，仅支持整页翻页
    private String pid;//非必填	推广位id
    private Long cat_id;//非必填	猜你喜欢场景的商品类目，20100-百货，20200-母婴，20300-食品，20400-女装，20500-电器，20600-鞋包，20700-内衣，20800-美妆，20900-男装，21000-水果，21100-家纺，21200-文具,21300-运动,21400-虚拟,21500-汽车,21600-家装,21700-家具,21800-医药;
    private List<Long> goods_ids;//非必填	相似商品推荐场景时必传。商品Id，请求相似商品时，仅取数组的第一位
}
