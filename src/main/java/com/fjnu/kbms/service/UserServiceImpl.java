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

    @Override
    public int editpw(Integer user_id, String password, String npassword) {
        return adminMapper.updateById(user_id,password,npassword);
    }

    @Override
    public int editac(Integer user_id, String email, String real_name, Byte sex, String birthday, String desc, String qq, String telephone, String website, String job) {
        return adminMapper.updateByUserId( user_id,  email,  real_name,  sex,  birthday,  desc,  qq,  telephone,  website,  job);
    }
}
