package com.fjnu.kbms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class IndexController {
    @RequestMapping("/index")
    public ModelAndView toIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("index");
        return modelAndView;
    }
    @RequestMapping("/front_index")
    public ModelAndView toFrontIndex(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("front_index.html");
        return modelAndView;
    }

}
