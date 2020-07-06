package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface UserMapper {
    int deleteByPrimaryKey(Integer userId);

    int delete(Integer userId);

    int insert(User record);

    int insertSelective(User record);

    User selectByPrimaryKey(Integer userId);

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    List<User> getUsersList(@Param("offset") Integer offset, @Param("limit") Integer limit,
                              @Param("userId") Integer userId, @Param("userName") String userName,
                              @Param("status") Byte status);
}