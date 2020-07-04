package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.Ap;
import com.fjnu.kbms.error.BusinessException;
import com.fjnu.kbms.error.EmError;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.ApService;
import com.fjnu.kbms.service.CommentService;
import com.fjnu.kbms.service.TypeService;
import com.fjnu.kbms.service.UserService;
import com.fjnu.kbms.vo.ProblemListVO;
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
public class ContentController {
    private final ApService apService;
    private final CommentService commentService;
    private final TypeService typeService;
    private final UserService userService;

    @Autowired
    public ContentController(ApService apService, CommentService commentService, TypeService typeService, UserService userService) {
        this.apService = apService;
        this.commentService = commentService;
        this.typeService = typeService;
        this.userService = userService;
    }

    @RequestMapping("/problem_list")
    public ModelAndView toList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("problem_manage");
        return modelAndView;
    }
    @RequestMapping("/getProblems")
    @ResponseBody
    public TableVO getProblems(Integer page,Integer limit,Integer apid,Integer typeId,String publishTime,Byte status){
        List<Ap> Ap_list = apService.getProblemList(page,limit,apid,typeId,publishTime,status);
        List<ProblemListVO> problemListVOList = new ArrayList<>();
        for (Ap ap : Ap_list) {
            ProblemListVO problemListVO = new ProblemListVO();
            BeanUtils.copyProperties(problemListVO,ap);
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
    public ModelAndView toUpdate(){
        ModelAndView modelAndView = new ModelAndView();
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






}
