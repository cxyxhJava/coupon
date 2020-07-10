package com.frank.pdd.service;

import com.frank.dto.req.ChainTransferReq;
import com.frank.dto.req.GoodsPromoteUrlGetReq;
import com.frank.dto.resp.ChainTransferResp;
import com.frank.dto.resp.GoodsPromoteUrlGetResp;
import com.frank.pdd.dto.req.GoodsListReq;
import com.frank.pdd.dto.resp.GoodsListResp;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:25 2020-06-25
 * @ Description：
 * @ Modified By：
 */
@Slf4j
@Component
public abstract class GoodsService {

    /**
     * 获取推广url
     * @param req
     * @return
     */
    public abstract GoodsPromoteUrlGetResp getGoodsPromoteUrl(GoodsPromoteUrlGetReq req) throws Exception;

    /**
     * 获取列表
     * @param req
     * @return
     */
    public abstract GoodsListResp getGoodsList(GoodsListReq req)throws Exception;


    /**
     * 转链
     * @param req
     * @return
     */
    public abstract ChainTransferResp chainTransfer(ChainTransferReq req)throws Exception;

}
