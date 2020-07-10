package com.frank.pdd.dto.req;

import lombok.Builder;
import lombok.Data;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:11 2020-05-26
 * @ Description：
 * @ Modified By：
 */
@Data
@Builder
public class GoodsUnitQueryReq extends BaseReq {

   private Long goods_id;//必填	商品id
   private Long zs_duo_id;//非必填	招商duoId

}
