package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.dao.UserMapper;
import com.fjnu.kbms.service.UserService;
import com.fjnu.kbms.util.Md5;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author aabbcczhy
 */
@Service
public class UserServiceImpl implements UserService {

    private final UserMapper userMapper;

    public UserServiceImpl(UserMapper userMapper) {
        this.userMapper = userMapper;
    }

    @Override
    public User getUserById(Integer userId) {
        return userMapper.selectByPrimaryKey(userId);
    }

    @Override
    public User getUserByName(String username) {
        return userMapper.selectByUsername(username);
    }

    @Override
    public void addUser(User user) {
        userMapper.insertSelective(user);
    }

    @Override
    public void changePassword(String username, String oldPassword, String newPassword) {
        userMapper.updatePassword(username,
                Md5.encodePassword(oldPassword,username),
                Md5.encodePassword(newPassword,username));
    }

    @Override
    public void updateUserInfo(User user) {
        userMapper.updateByUsernameSelective(user);
    }

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
