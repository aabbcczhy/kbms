package com.fjnu.kbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @org.springframework.beans.factory.annotation.Autowired
    com.fjnu.kbms.service.ApService apService;
    @org.springframework.beans.factory.annotation.Autowired
    com.fjnu.kbms.service.ColumnService columnService;
    @RequestMapping("/index")
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
        modelAndView.addObject("articles",articles);
        modelAndView.setViewName("front_index.html");
        return modelAndView;
    }
    @RequestMapping("/column")
    public ModelAndView columnIndex(){
        ModelAndView modelAndView = new ModelAndView();
        java.util.List<com.fjnu.kbms.bean.Column> columns = columnService.getAllColumns();
        modelAndView.addObject("columns",columns);
        modelAndView.setViewName("column.html");
        return modelAndView;
    }

    /**
     * @Method 添加文章
     * @Author QuanJiaXing
     * @Version  1.0
     * @Description
     * @Return 
     * @Exception 
     * @Date 2020/7/6 1:04
     */
    @RequestMapping("/add_article")
    public ModelAndView addArticle(){
        ModelAndView modelAndView = new ModelAndView();
        java.util.List<com.fjnu.kbms.bean.Ap> articles=apService.getArticleAndProblemListAll(1,10);
        modelAndView.addObject("articles",articles);
        modelAndView.setViewName("publish_article.html");
        return modelAndView;
    }

}
