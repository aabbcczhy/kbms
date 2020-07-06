package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> getCommentByApId(Integer apid);
}
