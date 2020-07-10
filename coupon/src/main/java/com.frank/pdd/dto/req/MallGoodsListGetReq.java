package com.frank.pdd.dto.req;

import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 17:10 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
public class MallGoodsListGetReq extends BaseReq{

    private Long mall_id;//必填	店铺id
    private Integer page_number;//必填	分页数
    private Integer page_size;//必填	每页商品数量

}
