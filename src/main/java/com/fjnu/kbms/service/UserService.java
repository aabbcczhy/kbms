package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.User;

public interface UserService {

    User getUserById(Integer userId);

    User getUserByName(String username);

    void addUser(User user);

    void changePassword(String username,String oldPassword,String newPassword);

    void updateUserInfo(User user);

}
