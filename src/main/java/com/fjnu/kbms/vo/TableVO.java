package com.fjnu.kbms.vo;

/**
 * @author aabbcczhy
 */
public class TableVO {
    private int code;
    private String msg;
    private int count;
    private Object data;

    public TableVO(int count, Object data) {
        this.code = 0;
        this.msg = "";
        this.count = count;
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
