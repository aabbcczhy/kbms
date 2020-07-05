package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.IUserService;
import com.fjnu.kbms.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService use;

    @RequestMapping("/doLogin")
    public Response login(String user_name,String password){

        User loginUser=use.loginjudge(user_name,password);
        if(loginUser!=null){
            return Response.create(loginUser,"登录成功");
        }
        return Response.create("登录失败");
    }

    @RequestMapping("/doRegister")
    public int regist(String user_name,String password){
        int i=use.addUser(user_name,password);
        return i;
    }



    @RequestMapping("/toLogin")
    public ModelAndView toLogin(){
        System.out.println("进入登录页面……");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("login");
        return mv;
    }

    @RequestMapping("/toRegister")
    public ModelAndView toRegister(){
        System.out.println("进入注册页面……");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

    @RequestMapping("/toacsetting")
    public ModelAndView toacsetting(){
        System.out.println("进入账户设置页面……");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("acsetting");
        return mv;
    }

    @RequestMapping("/topwsetting")
    public ModelAndView topwsetting(){
        System.out.println("进入密码设置页面……");
        ModelAndView mv=new ModelAndView();
        mv.setViewName("pwsetting");
        return mv;
    }

}
