package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.Column;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface ColumnMapper {
    int deleteByPrimaryKey(Integer columnId);

    int insert(Column record);

    int insertSelective(Column record);

    Column selectByPrimaryKey(Integer columnId);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);
}