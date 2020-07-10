package com.frank.pdd.dto.resp;

import lombok.Builder;
import lombok.Data;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:23 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
public class GoodsBasicInfoGetResp{
    private List<GoodsBasicInfoGetList> goods_list;//list
}
