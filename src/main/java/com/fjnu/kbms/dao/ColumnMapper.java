package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.vo.ColumnListVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Vector;

@Repository
@Mapper
public interface ColumnMapper {
    int deleteByPrimaryKey(Integer columnId);

    int insert(Column record);

    int insertSelective(Column record);

    Column selectByPrimaryKey(Integer columnId);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);

    Vector<ColumnListVO> selectAll();
}