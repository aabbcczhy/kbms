package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.dao.UserMapper;
import com.fjnu.kbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }
}
