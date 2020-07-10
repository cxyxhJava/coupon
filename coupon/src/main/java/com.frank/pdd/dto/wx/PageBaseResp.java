package com.frank.pdd.dto.wx;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 15:19 2020-06-17
 * @ Description：
 * @ Modified By：
 */
public class PageBaseResp<T> {

    private Integer pageSize;

    private Integer pageNo;

    private Long total;

    private List<T> list;

    private String searchId;

    public String getSearchId() {
        return searchId;
    }

    public void setSearchId(String searchId) {
        this.searchId = searchId;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Long getTotal() {
        return total;
    }

    public void setTotal(Long total) {
        this.total = total;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}
