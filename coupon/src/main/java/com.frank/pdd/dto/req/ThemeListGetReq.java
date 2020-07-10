package com.frank.pdd.dto.req;

import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:11 2020-05-27
 * @ Description：
 * @ Modified By：
 */
@Data
public class ThemeListGetReq extends BaseReq{
    private Integer page;//非必填	 返回的页码
    private Integer page_size;//非必填返回的一页数据数量
}
