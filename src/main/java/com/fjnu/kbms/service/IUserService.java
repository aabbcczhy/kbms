package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.User;

public interface IUserService {
    public User loginjudge(String user_name,String password);
    public int addUser(String user_name,String password);
}
