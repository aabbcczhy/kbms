package com.fjnu.kbms.vo;

public class ProblemListVO {
    private Integer apid;

    private String title;

    private Byte isArticle;

    private String typeName;

    private Integer scan;

    private Integer answer;

    private Byte status;

    private String authorName;

    private String publishTime;

    private String content;

    public Integer getApid() {
        return apid;
    }

    public void setApid(Integer apid) {
        this.apid = apid;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Byte getIsArticle() {
        return isArticle;
    }

    public void setIsArticle(Byte isArticle) {
        this.isArticle = isArticle;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getScan() {
        return scan;
    }

    public void setScan(Integer scan) {
        this.scan = scan;
    }

    public Integer getAnswer() {
        return answer;
    }

    public void setAnswer(Integer answer) {
        this.answer = answer;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String authorName) {
        this.authorName = authorName;
    }

    public String getPublishTime() {
        return publishTime;
    }

    public void setPublishTime(String publishTime) {
        this.publishTime = publishTime;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
