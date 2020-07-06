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
                            @Param("publishTime") String publishTime, @Param("status") Byte status,
                            @Param("isArticle") Byte isArticle);

    List<Ap> getArticleList(@Param("offset") Integer offset, @Param("limit") Integer limit,
                            @Param("apid") Integer apid, @Param("title")String title,@Param("typeId") Integer typeId,
                            @Param("columnId") Integer columnId, @Param("publishTime") String publishTime, @Param("status") Byte status,
                            @Param("isArticle") Byte isArticle);
    /**
     * @Method
     * @Author QuanJiaXing
     * @Version  1.0
     * @Description 返回整个问题和文章列表目前直接按时间倒序排列
     * @param null
     * @Return
     * @Exception
     * @Date 2020/7/6 1:43
     */
    List<Ap> getArticleAndProblemListAll(@Param("offset") Integer offset, @Param("limit") Integer limit);
    /**
     * @Method
     * @Author QuanJiaXing
     * @Version  1.0
     * @Description
     * @Return
     * @Exception 根据typeid查询
     * @Date 2020/7/6 16:01
     */
    List<Ap> getArticleAndProblemListByType(@Param("offset") Integer offset, @Param("limit") Integer limit,@Param("typeId") Integer typeId);

    int updateScan(Integer apid);
}