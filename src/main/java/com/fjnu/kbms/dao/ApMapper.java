package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.Ap;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ApMapper {
    int deleteByPrimaryKey(Integer apid);

    int insert(Ap record);

    int insertSelective(Ap record);

    Ap selectByPrimaryKey(Integer apid);

    int updateByPrimaryKeySelective(Ap record);

    int updateByPrimaryKeyWithBLOBs(Ap record);

    int updateByPrimaryKey(Ap record);
}