package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.User;
import org.apache.ibatis.annotations.Param;

public interface IUserService {
    public User loginjudge(String user_name,String password);
    public int addUser(String user_name,String password);
    public int editpw(Integer user_id,String password,String npassword);//改密码
    public int editac(Integer user_id, String email, String real_name, Byte sex,
                      String birthday, String desc, String qq, String telephone, String website, String job);//账户设置
}
