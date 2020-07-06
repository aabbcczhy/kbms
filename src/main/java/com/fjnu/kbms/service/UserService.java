package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {

    User getUserById(Integer userId);

    User getUserByName(String username);

    void addUser(User user);

    void changePassword(String username,String oldPassword,String newPassword);

    void updateUserInfo(User user);

    User selectByPrimaryKey(Integer userId);

    int deleteByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    List<User> getUsersList(Integer page, Integer limit, Integer userId, String userName, Byte status);
}
