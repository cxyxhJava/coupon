package com.frank.pdd.dto.req;

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
public class GoodsBasicInfoGetReq extends BaseReq{

    private List<Long> goods_id_list;//必填	商品id

}
