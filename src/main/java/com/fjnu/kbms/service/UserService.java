package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User selectByPrimaryKey(Integer userId);
}
