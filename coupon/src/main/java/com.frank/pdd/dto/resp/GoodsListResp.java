package com.frank.pdd.dto.resp;

import com.pdd.pop.sdk.http.api.pop.response.PddDdkGoodsSearchResponse;
import com.taobao.api.response.TbkDgMaterialOptionalResponse;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 16:05 2020-05-26
 * @ Description：物料搜索接口返回值
 * @ Modified By：
 */
public class GoodsListResp {
    private Integer type;
    private PddDdkGoodsSearchResponse.GoodsSearchResponse pddResp;
    private TbkDgMaterialOptionalResponse tbkResp;

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public PddDdkGoodsSearchResponse.GoodsSearchResponse getPddResp() {
        return pddResp;
    }

    public void setPddResp(PddDdkGoodsSearchResponse.GoodsSearchResponse pddResp) {
        this.pddResp = pddResp;
    }

    public TbkDgMaterialOptionalResponse getTbkResp() {
        return tbkResp;
    }

    public void setTbkResp(TbkDgMaterialOptionalResponse tbkResp) {
        this.tbkResp = tbkResp;
    }
}
