package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.error.BusinessException;
import com.fjnu.kbms.error.EmError;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.UserService;
import com.fjnu.kbms.shiro.UserToken;
import com.fjnu.kbms.util.Md5;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

/**
 * @author aabbcczhy
 */
@RestController
public class LoginController {

    private final UserService userService;

    public LoginController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/loginCheck")
    public Response login(String username, String password) throws BusinessException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(username,password);
        Map<String, Boolean> map = new HashMap<>(1);
        try{
            subject.login(token);
            if(subject.hasRole("1")){
                map.put("isAdmin",true);
                return Response.create(map);
            }
            User user = userService.getUserByName(username);
            subject.getSession().setAttribute("userId",user.getUserId());
            subject.getSession().setAttribute("username", username);
        }catch (Exception e){
            throw new BusinessException(EmError.WRONG_USERNAME_OR_PASSWORD);
        }
        map.put("isAdmin", false);
        return Response.create(map);
    }

    @RequestMapping("/logout")
    public RedirectView logout() {
        SecurityUtils.getSubject().logout();
        RedirectView redirectTarget = new RedirectView();
        redirectTarget.setContextRelative(true);
        redirectTarget.setUrl("/login");
        return redirectTarget;
    }

    @PostMapping("/doRegister")
    public Response doRegister(User user) throws BusinessException {
        if(user.getUserName()==null || user.getPassword()==null){
            throw new BusinessException(EmError.PARAMETER_VALIDATION_ERROR);
        }
        user.setPassword(Md5.encodePassword(user.getPassword(),user.getUserName()));
        userService.addUser(user);
        return Response.create("注册成功");
    }

    @RequestMapping("/login")
    public ModelAndView toLogin(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("login");
        return modelAndView;
    }

    @RequestMapping("/register")
    public ModelAndView toRegister(){
        ModelAndView mv=new ModelAndView();
        mv.setViewName("register");
        return mv;
    }

}
