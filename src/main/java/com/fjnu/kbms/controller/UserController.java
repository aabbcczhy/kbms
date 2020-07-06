package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.UserService;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserService userService;

    @PostMapping("/changePassword")
    public Response changePassword(String password, String newPassword){
        String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
        userService.changePassword(username,password,newPassword);
        // 将session清除并退出登录
        SecurityUtils.getSubject().getSession().removeAttribute("username");
        SecurityUtils.getSubject().logout();
        return Response.create("修改成功");
    }

    @PostMapping("/updateUserInfo")
    public Response updateUserInfo(User user){
        String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
        user.setUserName(username);
        userService.updateUserInfo(user);
        return Response.create("修改成功");
    }

    @RequestMapping("/pwSetting")
    public ModelAndView toPwSetting(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("pwsetting");
        return mv;
    }

    @RequestMapping("/acSetting")
    public ModelAndView toAcSetting(){
        String username = (String) SecurityUtils.getSubject().getSession().getAttribute("username");
        User user = userService.getUserByName(username);
        ModelAndView mv=new ModelAndView();
        mv.setViewName("acsetting");
        mv.addObject("user",user);
        return mv;
    }

}
