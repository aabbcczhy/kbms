package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.dao.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements IUserService{
    @Autowired
    UserMapper adminMapper;

    @Override
    public User loginjudge(String user_name, String password) {
        return adminMapper.selectByLogin(user_name,password);
    }

    @Override
    public int addUser(String user_name,String password) {
        User user=new User();
        user.setPassword(password);
        user.setUserName(user_name);
        return adminMapper.insertSelective(user);
    }
}
