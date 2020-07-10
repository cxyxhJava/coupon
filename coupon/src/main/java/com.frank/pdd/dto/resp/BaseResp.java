package com.frank.pdd.dto.resp;

import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 14:56 2020-05-27
 * @ Description：
 * @ Modified By：
 */
@Data
public class BaseResp<T> {
    private List<T> list;//商品列表
    private String list_id;//翻页时建议填写前页返回的list_id值
    private String search_id;//搜索id，建议生成推广链接时候填写，提高收益
    private Long total;//返回商品总数
}
