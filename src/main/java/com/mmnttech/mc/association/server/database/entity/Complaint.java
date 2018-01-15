package com.mmnttech.mc.association.server.database.entity;

import java.util.Date;

public class Complaint {
    private String recId;

    private String merchantId;

    private String integrityCode;

    private String orderId;

    private Long amt;

    private String type;

    private Date date;

    private String addr;

    private String message;

    private String userId;

    private String userTel;

    private String step;

    private String resultMessage;

    private String fairId;

    private String status;

    private Long evaluation;

    private Date createDate;

    public String getRecId() {
        return recId;
    }

    public void setRecId(String recId) {
        this.recId = recId == null ? null : recId.trim();
    }

    public String getMerchantId() {
        return merchantId;
    }

    public void setMerchantId(String merchantId) {
        this.merchantId = merchantId == null ? null : merchantId.trim();
    }

    public String getIntegrityCode() {
        return integrityCode;
    }

    public void setIntegrityCode(String integrityCode) {
        this.integrityCode = integrityCode == null ? null : integrityCode.trim();
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId == null ? null : orderId.trim();
    }

    public Long getAmt() {
        return amt;
    }

    public void setAmt(Long amt) {
        this.amt = amt;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getAddr() {
        return addr;
    }

    public void setAddr(String addr) {
        this.addr = addr == null ? null : addr.trim();
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message == null ? null : message.trim();
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId == null ? null : userId.trim();
    }

    public String getUserTel() {
        return userTel;
    }

    public void setUserTel(String userTel) {
        this.userTel = userTel == null ? null : userTel.trim();
    }

    public String getStep() {
        return step;
    }

    public void setStep(String step) {
        this.step = step == null ? null : step.trim();
    }

    public String getResultMessage() {
        return resultMessage;
    }

    public void setResultMessage(String resultMessage) {
        this.resultMessage = resultMessage == null ? null : resultMessage.trim();
    }

    public String getFairId() {
        return fairId;
    }

    public void setFairId(String fairId) {
        this.fairId = fairId == null ? null : fairId.trim();
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    public Long getEvaluation() {
        return evaluation;
    }

    public void setEvaluation(Long evaluation) {
        this.evaluation = evaluation;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }
}