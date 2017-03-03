package com.fh.entity.youguanzi;

import java.io.Serializable;
import java.util.Date;

public class PlatViolateHandler implements Serializable {
    private static final long serialVersionUID = 1451119516403670398L;

    private Integer id;

    private String invalidType;

    private Integer invalidId;

    private String dealNo;

    private String dealReason;

    private String dealExplanation;

    private Date dealTime;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getInvalidType() {
        return invalidType;
    }

    public void setInvalidType(String invalidType) {
        this.invalidType = invalidType;
    }

    public Integer getInvalidId() {
        return invalidId;
    }

    public void setInvalidId(Integer invalidId) {
        this.invalidId = invalidId;
    }

    public String getDealNo() {
        return dealNo;
    }

    public void setDealNo(String dealNo) {
        this.dealNo = dealNo;
    }

    public String getDealReason() {
        return dealReason;
    }

    public void setDealReason(String dealReason) {
        this.dealReason = dealReason;
    }

    public String getDealExplanation() {
        return dealExplanation;
    }

    public void setDealExplanation(String dealExplanation) {
        this.dealExplanation = dealExplanation;
    }

    public Date getDealTime() {
        return dealTime;
    }

    public void setDealTime(Date dealTime) {
        this.dealTime = dealTime;
    }
}