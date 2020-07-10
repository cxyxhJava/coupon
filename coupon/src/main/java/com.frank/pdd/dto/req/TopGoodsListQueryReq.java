package com.frank.pdd.dto.req;

import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:29 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
public class TopGoodsListQueryReq extends BaseReq{
    private Integer limit;//非必填	请求数量；默认值 ： 400
    private String list_id;//非必填	翻页时建议填写前页返回的list_id值
    private Integer offset;//非必填	从多少位置开始请求；默认值 ： 0
    private String p_id;//非必填	推广位id
    private Integer sort_type;//非必填	1-实时热销榜；2-实时收益榜

}
