package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.Type;
import com.fjnu.kbms.vo.ColumnListVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
@Mapper
public interface TypeMapper {
    int deleteByPrimaryKey(Integer typeId);

    int insert(Type record);

    int insertSelective(Type record);

    Type selectByPrimaryKey(Integer typeId);

    int updateByPrimaryKeySelective(Type record);

    int updateByPrimaryKey(Type record);

    Vector<Type> selectAll();
}