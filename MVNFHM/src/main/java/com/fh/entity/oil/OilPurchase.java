package com.fh.entity.oil;

import java.math.BigDecimal;
import java.util.Date;

public class OilPurchase {
    private Integer id;

    private Integer merchantId;

    private Integer publisherId;

    private Integer quantity;

    private Integer status;

    private Integer oilLevelId;

    private Integer oilCategoryId;

    private Integer oilFlagId;

    private Integer oilAreaId;

    private Date createTime;

    private String remark;

    private String description;

    private BigDecimal price;

    private String purchaseNo;

    private Date takeTime;

    private Date lastUpdatedAt;
    private Date fetchTime;
    private Date lastUpdateTime;

    public Date getLastUpdateTime() {
        return lastUpdateTime;
    }

    public void setLastUpdateTime(Date lastUpdateTime) {
        this.lastUpdateTime = lastUpdateTime;
    }

    public Date getFetchTime() {
        return fetchTime;
    }

    public void setFetchTime(Date fetchTime) {
        this.fetchTime = fetchTime;
    }

    public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public BigDecimal getPrice() {
		return price;
	}

	public void setPrice(BigDecimal price) {
		this.price = price;
	}

	public String getPurchaseNo() {
		return purchaseNo;
	}

	public void setPurchaseNo(String purchaseNo) {
		this.purchaseNo = purchaseNo;
	}

	public Date getTakeTime() {
		return takeTime;
	}

	public void setTakeTime(Date takeTime) {
		this.takeTime = takeTime;
	}

	public Date getLastUpdatedAt() {
		return lastUpdatedAt;
	}

	public void setLastUpdatedAt(Date lastUpdatedAt) {
		this.lastUpdatedAt = lastUpdatedAt;
	}

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

}