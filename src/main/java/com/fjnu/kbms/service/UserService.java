package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.User;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    User selectByPrimaryKey(Integer userId);

    int deleteByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    List<User> getUsersList(Integer page, Integer limit, Integer userId, String userName, Byte status);
}
