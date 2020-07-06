package com.fjnu.kbms.controller;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.error.BusinessException;
import com.fjnu.kbms.error.EmError;
import com.fjnu.kbms.response.Response;
import com.fjnu.kbms.service.UserService;
import com.fjnu.kbms.vo.TableVO;
import org.apache.shiro.SecurityUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

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

    @RequestMapping("/user_list")
    public ModelAndView toList(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_manage");
        return modelAndView;
    }


    @RequestMapping("/toUserDetails")
    public ModelAndView toUserDetails(){
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("user_details");
        return modelAndView;
    }



    @RequestMapping("/delete")
    public Response delete(Integer userId)throws BusinessException {
        if(userService.deleteByPrimaryKey(userId)==1) {
            return Response.create("null");
        }else {
            throw new BusinessException(EmError.UNKNOWN_ERROR);
        }
    }
    @RequestMapping("/reset")
    public String reset(Integer userId){
        User user = new User();
        user.setUserId(userId);
        user.setPassword("123456");
        userService.updateByPrimaryKeySelective(user);
        return "success";
    }


    @RequestMapping("/getUsers")
    @ResponseBody
    public TableVO getUsers(Integer page, Integer limit, Integer userId, String userName, Byte status){
        if(status!=null && status == 2){
            status = null;
        }
        List<User> User_list = userService.getUsersList(page,limit,userId,userName,status);
        List<UserVO> userListVOSList = new ArrayList<>();
        for (User user : User_list) {
            UserVO userVO = new UserVO();
            BeanUtils.copyProperties(user,userVO);
            userListVOSList.add(userVO);
        }
        return new TableVO(userListVOSList.size(),userListVOSList);
    }

}
