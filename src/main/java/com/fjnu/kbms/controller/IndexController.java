package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Ap;
import com.fjnu.kbms.bean.Comment;
import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.service.*;
import com.fjnu.kbms.vo.ApDetailVO;
import com.fjnu.kbms.vo.CommentVO;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

@Controller
public class IndexController {

    private final ApService apService;
    private final UserService userService;
    private final ColumnService columnService;
    private final CommentService commentService;
    private final TypeService typeService;

    @Autowired
    public IndexController(ApService apService, UserService userService, ColumnService columnService, CommentService commentService, TypeService typeService) {
        this.apService = apService;
        this.userService = userService;
        this.columnService = columnService;
        this.commentService = commentService;
        this.typeService = typeService;
    }

    @RequestMapping("/index")
    @RequiresRoles("1")
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    /**
     * @Method 前台显示主页
     * @Author QuanJiaXing
     * @Version  1.0
     * @Description
     * @Return 
     * @Exception 
     * @Date 2020/7/6 1:03
     */
    @RequestMapping("/front_index")
    public ModelAndView toFrontIndex(){
        ModelAndView modelAndView = new ModelAndView();
        java.util.List<com.fjnu.kbms.bean.Ap> articles=apService.getArticleAndProblemListAll(1,10);
        java.util.List<com.fjnu.kbms.bean.Type> types = typeService.getAllTypes();
        modelAndView.addObject("articles",articles);
        modelAndView.addObject("type",types);
        modelAndView.setViewName("front_index");
        return modelAndView;
    }
    @RequestMapping("/column")
    public ModelAndView columnIndex(){
        ModelAndView modelAndView = new ModelAndView();
        java.util.List<com.fjnu.kbms.bean.Column> columns = columnService.getAllColumns();
        java.util.List<com.fjnu.kbms.bean.Ap> articles=apService.getArticleAndProblemListAll(1,10);
        modelAndView.addObject("columns",columns);
        modelAndView.addObject("articles",articles);
        modelAndView.setViewName("column");
        return modelAndView;
    }

    @RequestMapping("/column_list/{columnId}")
    public ModelAndView getColumnList(@PathVariable Integer columnId){
        ModelAndView modelAndView = new ModelAndView();
        java.util.List<com.fjnu.kbms.bean.Ap> articles=apService.getArticleAndProblemListByColumn(1,10,columnId);
        modelAndView.addObject("articles",articles);
        modelAndView.setViewName("column_list");
        return modelAndView;
    }

    @RequestMapping("/publish")
    @RequiresRoles("0")
    public ModelAndView publish(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("publish");
        return modelAndView;
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
            apDetailVO.setAuthor(false);
            // 作者详细信息
            User author = userService.getUserById(ap.getAuthorId());
            apDetailVO.setAuthorName(author.getUserName());
            apDetailVO.setAuthorPicture(author.getHeadPicture());
            apDetailVO.setAuthorRealName(author.getRealName());
            apDetailVO.setManager(author.getRole()==1);
        }
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("show_detail");
        modelAndView.addObject("apDetail",apDetailVO);
        return modelAndView;
    }

    @RequestMapping("/welcome")
    @RequiresRoles("1")
    public ModelAndView welcome(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("welcome");
        return modelAndView;
    }

    @RequestMapping("/error-404")
    public ModelAndView pageNotFound(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("404");
        return modelAndView;
    }

}
