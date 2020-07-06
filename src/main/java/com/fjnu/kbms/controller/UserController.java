package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.IUserService;
import com.fjnu.kbms.vo.TableVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpSession;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    IUserService use;
    @Autowired
    HttpSession session;

    @RequestMapping("/doLogin")
    public Response login(String user_name,String password){

        User loginUser=use.loginjudge(user_name,password);
        if(loginUser!=null){
            return Response.create(loginUser,"登录成功");
        }else {
            return Response.create("登录失败");
        }
    }

    @RequestMapping("/doacsetting")
    public Response acset(Integer user_id, String email, String real_name, Byte sex, String birthday,
                          String desc, String qq, String telephone, String website, String job){
        int id=0;
        session.setAttribute("user_id",id);
        return Response.create("");

    }

    @RequestMapping("/doRegister")
    public int regist(String user_name,String password){
        int i=use.addUser(user_name,password);
        return i;
    }

    @RequestMapping("/doPwsetting")
    public Response pwsetting(String password,String npassword){
        int user_id=0;
        session.setAttribute("user_id",user_id);
        int i=use.editpw(user_id, password, npassword);
        if(i!=0){
            return Response.create(i,"修改成功");
        }else{
            return Response.create("修改失败");

        }

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
