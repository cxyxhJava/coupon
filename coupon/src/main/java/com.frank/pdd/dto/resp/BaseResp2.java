package com.frank.pdd.dto.resp;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:09 2020-05-27
 * @ Description：
 * @ Modified By：
 */
public class BaseResp2<T> {
    private List<T> goods_list;//商品列表对象
    private Long total;//返回商品总数
}
