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

    int insert(User record);

    int insertSelective(User record);//注册

    User selectByPrimaryKey(Integer userId);

    User selectByLogin(@Param("user_name")String user_name,@Param("password")String password);//登录

    int updateByPrimaryKeySelective(User record);

    int updateByPrimaryKey(User record);

    int updateById(@Param("user_id")Integer user_id,@Param("password")String password,@Param("npassword")String npassword);//改密码

    int updateByUserId(@Param("user_id")Integer user_id,@Param("email")String email,@Param("real_name")String real_name,
                       @Param("sex")Byte sex,@Param("birthday")String birthday,@Param("desc")String desc,@Param("qq")String qq,
                       @Param("telephone")String telephone,@Param("website")String website,@Param("job")String job);//账户设置
}