package com.fh.entity.vo;

import java.util.Date;

/**
 * 求购信息查询类
 * @author dolly
 * @since 2016-12-31
 */
public class OilPurchaseQuery extends BaseQuery {
    private Integer id;

    private Integer merchantId;

    private Integer publisherId;

    private Integer quantity;

    private Integer status;

    private Integer oilLevelId;

    private Integer oilCategoryId;

    private Integer oilFlagId;

    private Integer oilAreaId;

    private String title;

    private Date createTime;
    private Date createTimeBegin;
    private Date createTimeEnd;

    private Integer acceptOffer;//1表示有offer

    public Integer getAcceptOffer() {
        return acceptOffer;
    }

    public void setAcceptOffer(Integer acceptOffer) {
        this.acceptOffer = acceptOffer;
    }

    public Date getCreateTimeBegin() {
        return createTimeBegin;
    }

    public void setCreateTimeBegin(Date createTimeBegin) {
        this.createTimeBegin = createTimeBegin;
    }

    public Date getCreateTimeEnd() {
        return createTimeEnd;
    }

    public void setCreateTimeEnd(Date createTimeEnd) {
        this.createTimeEnd = createTimeEnd;
    }

    private String remark;

    private String instruction;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(Integer merchantId) {
        this.merchantId = merchantId;
    }

    public Integer getPublisherId() {
        return publisherId;
    }

    public void setPublisherId(Integer publisherId) {
        this.publisherId = publisherId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getOilLevelId() {
        return oilLevelId;
    }

    public void setOilLevelId(Integer oilLevelId) {
        this.oilLevelId = oilLevelId;
    }

    public Integer getOilCategoryId() {
        return oilCategoryId;
    }

    public void setOilCategoryId(Integer oilCategoryId) {
        this.oilCategoryId = oilCategoryId;
    }

    public Integer getOilFlagId() {
        return oilFlagId;
    }

    public void setOilFlagId(Integer oilFlagId) {
        this.oilFlagId = oilFlagId;
    }

    public Integer getOilAreaId() {
        return oilAreaId;
    }

    public void setOilAreaId(Integer oilAreaId) {
        this.oilAreaId = oilAreaId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getInstruction() {
        return instruction;
    }

    public void setInstruction(String instruction) {
        this.instruction = instruction;
    }
}