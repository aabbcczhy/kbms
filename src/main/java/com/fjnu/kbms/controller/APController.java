package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Ap;
import com.fjnu.kbms.bean.Comment;
import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.service.ApService;
import com.fjnu.kbms.service.CommentService;
import com.fjnu.kbms.service.UserService;
import com.fjnu.kbms.vo.ApDetailVO;
import com.fjnu.kbms.vo.CommentVO;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

/**
 * @author aabbcczhy
 */
@RestController
public class APController {

    private final ApService apService;

    private final UserService userService;

    private final CommentService commentService;

    public APController(ApService apService, UserService userService, CommentService commentService) {
        this.apService = apService;
        this.userService = userService;
        this.commentService = commentService;
    }

    @RequestMapping("/detail/{apid}")
    public ModelAndView apDetail(@PathVariable Integer apid){
        ApDetailVO apDetailVO = new ApDetailVO();
        Ap ap = apService.getApById(apid);
        if(ap != null){
            //数据库浏览量加1
            apService.updateScan(apid);
            //本次详情页的浏览量也要手动加1
            ap.setScan(ap.getScan() + 1);
            BeanUtils.copyProperties(ap,apDetailVO);
            List<Comment> commentList = commentService.getCommentByApId(apid);
            List<CommentVO> commentVOList = new ArrayList<>();
            for (Comment comment : commentList) {
                CommentVO commentVO = new CommentVO();
                BeanUtils.copyProperties(comment,commentVO);
                User commentUser = userService.getUserById(comment.getCommentUser());
                commentVO.setCommentUserName(commentUser.getUserName());
                commentVO.setCommentUserHeadPicture(commentUser.getHeadPicture());
                commentVOList.add(commentVO);
            }
            apDetailVO.setCommentVOList(commentVOList);
            /*
             *  TODO 此处应该取出session中的userid与Ap的authorid比对，来判断这篇文章是否是登录用户写的以获得相应的权限
             *   1.如果session不存在userid，说明未登录，以游客访问，最普通权限，只能看文章，不能做其他事
             *   2.如果比对成功，说明是作者，可以获得删除文章，编辑文章权限，给自己的文章评论
             *   3.如果比对失败，说明已经登录，但不是作者，可以评论。不能做其他事
             */
            apDetailVO.setAuthor(false);
            // 作者详细信息
            User author = userService.getUserById(ap.getAuthorId());
            apDetailVO.setAuthorName(author.getUserName());
            apDetailVO.setAuthorPicture(author.getHeadPicture());
            apDetailVO.setAuthorRealName(author.getRealName());
            // 此处根据Role字段来判断是否是管理员，从而获得相应权限
            apDetailVO.setManager(author.getRole()==1);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show_detail");
        modelAndView.addObject("apDetail",apDetailVO);
        return modelAndView;
    }

}
