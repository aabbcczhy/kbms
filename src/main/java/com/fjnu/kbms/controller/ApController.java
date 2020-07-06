package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Ap;
import com.fjnu.kbms.error.BusinessException;
import com.fjnu.kbms.error.EmError;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.*;
import com.fjnu.kbms.vo.ArticleListVO;
import com.fjnu.kbms.vo.ProblemListVO;
import com.fjnu.kbms.vo.TableVO;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/content")
public class ApController {
    private final ApService apService;
    private final CommentService commentService;
    private final TypeService typeService;
    private final UserService userService;
    private final ColumnService columnService;

    @Autowired
    public ApController(ApService apService, CommentService commentService, TypeService typeService,
                        UserService userService, ColumnService columnService) {
        this.apService = apService;
        this.commentService = commentService;
        this.typeService = typeService;
        this.userService = userService;
        this.columnService = columnService;
    }

    @RequestMapping("/problem_list")
    public ModelAndView toProblemList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("problem_manage");
        return modelAndView;
    }
    @RequestMapping("/getProblems")
    @ResponseBody
    public TableVO getProblems(Integer page, Integer limit, Integer apid, Integer typeId, String publishTime,
                               Byte status){
        if(status!=null && status == 4){
            status = null;
        }
        List<Ap> Ap_list = apService.getProblemList(page,limit,apid,typeId,publishTime,status);
        List<ProblemListVO> problemListVOList = new ArrayList<>();
        for (Ap ap : Ap_list) {
            ProblemListVO problemListVO = new ProblemListVO();
            BeanUtils.copyProperties(ap,problemListVO);
            problemListVO.setTypeName(typeService.selectByPrimaryKey(ap.getTypeId()).getTypeTitle());
            problemListVO.setAuthorName(userService.selectByPrimaryKey(ap.getAuthorId()).getUserName());
            problemListVO.setAnswer((commentService.selectByForeignKey(ap.getApid())).size());
            problemListVOList.add(problemListVO);
        }
        return new TableVO(problemListVOList.size(),problemListVOList);
    }



    @RequestMapping("/toDetails")
    public ModelAndView toDetails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("problem_details");
        return modelAndView;
    }

    @RequestMapping("/toAudit")
    public ModelAndView toUpdate(Integer apid){
        ModelAndView modelAndView = new ModelAndView();
        if(apid != null){
            Ap ap = apService.getArticleById(apid);
            modelAndView.addObject("ap",ap);
        }
        modelAndView.setViewName("problem_audit");
        return modelAndView;
    }

    @RequestMapping("/delete")
    public Response delete(Integer apid) throws BusinessException{
        if(apService.deleteByPrimaryKey(apid)==1) {
            return Response.create("null");
        }else {
            throw new BusinessException(EmError.UNKNOWN_ERROR);
        }
    }
    @RequestMapping("/audit")
    public String audit(Integer apid,Byte status){
        Ap ap = new Ap();
        ap.setApid(apid);
        ap.setStatus(status);
        apService.updateByPrimaryKeySelective(ap);
        return "success";
    }

    @RequestMapping("/article_list")
    public ModelAndView toArticleList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article_manage");
        return modelAndView;
    }

    @RequestMapping("/getArticles")
    @ResponseBody
    public TableVO getArticles(Integer page, Integer limit, Integer apid, String title,Integer typeId, Integer columnId,
                               String publishTime, Byte status){
        if(status!=null && status == 4){
            status = null;
        }
        List<Ap> Ap_list = apService.getArticlesList(page,limit,apid,title,typeId,columnId,publishTime,status);
        List<ArticleListVO> articleListVOSList = new ArrayList<>();
        for (Ap ap : Ap_list) {
            ArticleListVO articleListVO = new ArticleListVO();
            BeanUtils.copyProperties(ap,articleListVO);
            articleListVO.setTypeName(typeService.selectByPrimaryKey(ap.getTypeId()).getTypeTitle());
            articleListVO.setColumnName(columnService.selectByPrimaryKey(ap.getColumnId()).getColumnName());
            articleListVO.setAuthorName(userService.selectByPrimaryKey(ap.getAuthorId()).getUserName());
            articleListVO.setAnswer((commentService.selectByForeignKey(ap.getApid())).size());
            articleListVOSList.add(articleListVO);
        }
        return new TableVO(articleListVOSList.size(),articleListVOSList);
    }

    @RequestMapping("/toArticleDetails")
    public ModelAndView toArticleDetails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("article_details");
        return modelAndView;
    }




}
