package com.fjnu.kbms.vo;

public class CommentVO {
    private Integer commentId;

    private String commentContent;

    private String commentTime;

    private Integer commentAp;

    private Integer commentUser;

    private String commentUserName;

    private String commentUserHeadPicture;

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
        this.commentContent = commentContent;
    }

    public String getCommentTime() {
        return commentTime;
    }

    public void setCommentTime(String commentTime) {
        this.commentTime = commentTime;
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

    public String getCommentUserName() {
        return commentUserName;
    }

    public void setCommentUserName(String commentUserName) {
        this.commentUserName = commentUserName;
    }

    public String getCommentUserHeadPicture() {
        return commentUserHeadPicture;
    }

    public void setCommentUserHeadPicture(String commentUserHeadPicture) {
        this.commentUserHeadPicture = commentUserHeadPicture;
    }
}
