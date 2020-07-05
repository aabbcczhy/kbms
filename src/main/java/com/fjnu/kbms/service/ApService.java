package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Ap;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public interface ApService {

    List<Ap> getProblemList(Integer page, Integer limit, Integer apid, Integer typeId,
                            String publishTime, Byte status,Byte isArticle);

    List<Ap> getArticlesList(Integer page, Integer limit, Integer apid, String title,
                             Integer typeId, Integer columnId, String publishTime,
                             Byte status,Byte isArticle);

    int deleteByPrimaryKey(Integer apid);

    int updateByPrimaryKeySelective(Ap record);
    /**
     * @Method 返回整个问题和文章列表目前直接按时间倒序排列
     * @Author QuanJiaXing
     * @Version  1.0
     * @Description
     * @Return 
     * @Exception
     * @Date 2020/7/6 1:48
     */
    List<Ap> getArticleAndProblemListAll(Integer page, Integer limit);

}