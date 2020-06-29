package com.fjnu.kbms.bean;

public class Type {
    private Integer typeId;

    private String typeTitle;

    private Integer typeWeight;

    private Byte status;

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public String getTypeTitle() {
        return typeTitle;
    }

    public void setTypeTitle(String typeTitle) {
        this.typeTitle = typeTitle == null ? null : typeTitle.trim();
    }

    public Integer getTypeWeight() {
        return typeWeight;
    }

    public void setTypeWeight(Integer typeWeight) {
        this.typeWeight = typeWeight;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}