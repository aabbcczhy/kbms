package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Comment;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.CommentService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/comment")
@RequiresRoles("0")
public class CommentController {

    private final CommentService commentService;

    @Autowired
    public CommentController(CommentService commentService) {
        this.commentService = commentService;
    }

    @PostMapping("/doComment")
    public Response comment(Comment comment){
        Integer userId = (Integer) SecurityUtils.getSubject().getSession().getAttribute("userId");
        comment.setCommentUser(userId);
        commentService.addComment(comment);
        return Response.create("评论成功");
    }
}
