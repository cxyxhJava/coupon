package com.frank.pdd.dto.wx.req;

import com.frank.pdd.dto.req.GoodsRangeList;

import java.util.List;

/**
 * @ Author     ：杨晓波
 * @ Date       ：Created in 13:25 2020-06-17
 * @ Description：微信小程序 pdd商品列表查询传参
 * @ Modified By：
 */
public class PddWxGoodsListReq {

    private List<Integer> activityTags;//非必填	商品活动标记数组，例：[4,7]，24-品牌高佣；7-百亿补贴；20-行业精选；21-金牌商家；10044-潜力爆品；4-限时秒杀
    private Long catId;//非必填	商品类目ID，使用pdd.goods.cats.get接口获取
    private String customParameters;//非必填	自定义参数，为链接打上自定义标签；自定义参数最长限制64个字节；格式为： {"uid":"11111","sid":"22222"} ，其中 uid 用户唯一标识，可自行加密后传入，每个用户仅且对应一个标识，必填； sid 上下文信息标识，例如sessionId等，非必填。该json字符串中也可以加入其他自定义的key
    private List<Long> goodsIdList;//非必填	商品ID列表。例如：[123456,123]，当入参带有goods_id_list字段，将不会以opt_id、 cat_id、keyword维度筛选商品
    private Boolean isBrandGoods;//非必填	是否为品牌商品
    private String keyword;//非必填	商品关键词，与opt_id字段选填一个或全部填写
    private String listId;//非必填	翻页时建议填写前页返回的list_id值
    private Integer merchantType;//非必填	店铺类型，1-个人，2-企业，3-旗舰店，4-专卖店，5-专营店，6-普通店（未传为全部）
    private List<Integer> merchantTypeList;//非必填	店铺类型数组
    private Long optId;//非必填	商品标签类目ID，使用pdd.goods.opt.get获取
    private Integer page;//非必填	默认值1，商品分页数
    private Integer pageSize;//非必填	默认100，每页商品数量
    private String pid;//非必填	推广位id

    private List<GoodsRangeList> rangeList;//非必填	筛选范围列表 样例：[{"range_id":0,"range_from":1,"range_to":1500},{"range_id":1,"range_from":1,"range_to":1500}]
    private Integer sortType;//非必填	排序方式:0-综合排序;1-按佣金比率升序;2-按佣金比例降序;3-按价格升序;4-按价格降序;5-按销量升序;6-按销量降序;7-优惠券金额排序升序;8-优惠券金额排序降序;9-券后价升序排序;10-券后价降序排序;11-按照加入多多进宝时间升序;12-按照加入多多进宝时间降序;13-按佣金金额升序排序;14-按佣金金额降序排序;15-店铺描述评分升序;16-店铺描述评分降序;17-店铺物流评分升序;18-店铺物流评分降序;19-店铺服务评分升序;20-店铺服务评分降序;27-描述评分击败同类店铺百分比升序，28-描述评分击败同类店铺百分比降序，29-物流评分击败同类店铺百分比升序，30-物流评分击败同类店铺百分比降序，31-服务评分击败同类店铺百分比升序，32-服务评分击败同类店铺百分比降序
    private Boolean withCoupon;//非必填	是否只返回优惠券的商品，false返回所有商品，true只返回有优惠券的商品

    public List<Integer> getActivityTags() {
        return activityTags;
    }

    public void setActivityTags(List<Integer> activityTags) {
        this.activityTags = activityTags;
    }

    public Long getCatId() {
        return catId;
    }

    public void setCatId(Long catId) {
        this.catId = catId;
    }

    public String getCustomParameters() {
        return customParameters;
    }

    public void setCustomParameters(String customParameters) {
        this.customParameters = customParameters;
    }

    public List<Long> getGoodsIdList() {
        return goodsIdList;
    }

    public void setGoodsIdList(List<Long> goodsIdList) {
        this.goodsIdList = goodsIdList;
    }

    public Boolean getBrandGoods() {
        return isBrandGoods;
    }

    public void setBrandGoods(Boolean brandGoods) {
        isBrandGoods = brandGoods;
    }

    public String getKeyword() {
        return keyword;
    }

    public void setKeyword(String keyword) {
        this.keyword = keyword;
    }

    public String getListId() {
        return listId;
    }

    public void setListId(String listId) {
        this.listId = listId;
    }

    public Integer getMerchantType() {
        return merchantType;
    }

    public void setMerchantType(Integer merchantType) {
        this.merchantType = merchantType;
    }

    public List<Integer> getMerchantTypeList() {
        return merchantTypeList;
    }

    public void setMerchantTypeList(List<Integer> merchantTypeList) {
        this.merchantTypeList = merchantTypeList;
    }

    public Long getOptId() {
        return optId;
    }

    public void setOptId(Long optId) {
        this.optId = optId;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public String getPid() {
        return pid;
    }

    public void setPid(String pid) {
        this.pid = pid;
    }

    public List<GoodsRangeList> getRangeList() {
        return rangeList;
    }

    public void setRangeList(List<GoodsRangeList> rangeList) {
        this.rangeList = rangeList;
    }

    public Integer getSortType() {
        return sortType;
    }

    public void setSortType(Integer sortType) {
        this.sortType = sortType;
    }

    public Boolean getWithCoupon() {
        return withCoupon;
    }

    public void setWithCoupon(Boolean withCoupon) {
        this.withCoupon = withCoupon;
    }








}
