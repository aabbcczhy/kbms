package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.dao.UserMapper;
import com.fjnu.kbms.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserMapper userMapper;
    @Override
    public User selectByPrimaryKey(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public int deleteByPrimaryKey(Integer userId) {
        return userMapper.delete(userId);
    }

    @Override
    public int updateByPrimaryKeySelective(User record) {
        return userMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<User> getUsersList(Integer page, Integer limit, Integer userId, String userName,Byte status) {
        return userMapper.getUsersList((page-1)*limit,limit,userId,userName,status);
    }
}
