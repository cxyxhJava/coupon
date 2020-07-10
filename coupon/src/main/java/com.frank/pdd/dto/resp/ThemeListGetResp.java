package com.frank.pdd.dto.resp;

import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:11 2020-05-27
 * @ Description：
 * @ Modified By：
 */
@Data
public class ThemeListGetResp {
    private Long goods_num;//主题包含的商品数量
    private Long id;//主题ID
    private String image_url;//主题图片
    private String name;//主题名称
}
