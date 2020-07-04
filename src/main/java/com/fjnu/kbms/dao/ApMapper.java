package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.Ap;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

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

    List<Ap> getProblemList(@Param("offset") Integer offset, @Param("limit") Integer limit,
                            @Param("apid") Integer apid, @Param("typeId") Integer typeId,
                            @Param("publishTime") String publishTime, @Param("status") Byte status);
}