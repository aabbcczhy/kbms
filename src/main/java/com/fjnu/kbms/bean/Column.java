package com.fjnu.kbms.bean;

public class Column {
    private Integer columnId;

    private String columnName;

    private String columnPicture;

    private String columnDesc;

    private Integer creatorId;

    private Integer scan;

    private String createTime;

    private Byte status;

    public Integer getColumnId() {
        return columnId;
    }

    public void setColumnId(Integer columnId) {
        this.columnId = columnId;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName == null ? null : columnName.trim();
    }

    public String getColumnPicture() {
        return columnPicture;
    }

    public void setColumnPicture(String columnPicture) {
        this.columnPicture = columnPicture == null ? null : columnPicture.trim();
    }

    public String getColumnDesc() {
        return columnDesc;
    }

    public void setColumnDesc(String columnDesc) {
        this.columnDesc = columnDesc == null ? null : columnDesc.trim();
    }

    public Integer getCreatorId() {
        return creatorId;
    }

    public void setCreatorId(Integer creatorId) {
        this.creatorId = creatorId;
    }

    public Integer getScan() {
        return scan;
    }

    public void setScan(Integer scan) {
        this.scan = scan;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime == null ? null : createTime.trim();
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }
}