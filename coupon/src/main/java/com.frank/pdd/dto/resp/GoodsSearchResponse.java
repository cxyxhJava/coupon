package com.frank.pdd.dto.resp;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:39 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
public class GoodsSearchResponse {
    private List<GoodsList> goods_list;//商品列表;
    private String list_id;//翻页时必填前页返回的list_id值
    private String search_id;//搜索id，建议生成推广链接时候填写，提高收益
    private Integer total_count;//返回商品总数
}
