package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.User;
import com.fjnu.kbms.dao.UserMapper;
import com.fjnu.kbms.service.UserService;
import com.fjnu.kbms.util.Md5;
import org.springframework.stereotype.Service;

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
}
