package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.bean.Comment;
import com.fjnu.kbms.bean.Type;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@Mapper
public interface ColumnMapper {
    int deleteByPrimaryKey(Integer columnId);

    int insert(Column record);

    int insertSelective(Column record);

    Column selectByPrimaryKey(Integer columnId);

    List<Column> selectByColumnId();

    List<Comment> selectByForeignKey(Integer commentAp);

    int updateByPrimaryKeySelective(Column record);

    int updateByPrimaryKey(Column record);
}