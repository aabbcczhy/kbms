package com.fjnu.kbms.bean;

public class Comment {
    private Integer commentId;

    private String commentContent;

    private String commentTime;

    private Integer commentAp;

    private Integer commentUser;

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getCommentContent() {
        return commentContent;
    }

    public void setCommentContent(String commentContent) {
        this.commentContent = commentContent == null ? null : commentContent.trim();
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime == null ? null : commentTime.trim();
    }

    public Integer getCommentAp() {
        return commentAp;
    }

    public void setCommentAp(Integer commentAp) {
        this.commentAp = commentAp;
    }

    public Integer getCommentUser() {
        return commentUser;
    }

    public void setCommentUser(Integer commentUser) {
        this.commentUser = commentUser;
    }
}