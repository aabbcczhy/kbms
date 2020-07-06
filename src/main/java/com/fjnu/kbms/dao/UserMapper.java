package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    User selectByUsername(String username);

    int updateByUsernameSelective(User user);

    int updatePassword(@Param("userName") String userName,
                       @Param("password") String password,
                       @Param("newPassword") String newPassword);
}