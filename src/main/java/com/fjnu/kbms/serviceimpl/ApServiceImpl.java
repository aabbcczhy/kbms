package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.Ap;
import com.fjnu.kbms.dao.ApMapper;
import com.fjnu.kbms.service.ApService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApServiceImpl implements ApService {
    @Autowired
    ApMapper apMapper;
    @Override
    public List<Ap> getProblemList(Integer page,Integer limit,Integer apid,Integer typeId,
                                   String publishTime,Byte status) {
        return apMapper.getProblemList((page-1)*limit,limit,apid,typeId,publishTime,status);
    }

    @Override
    public List<Ap> getArticlesList(Integer page, Integer limit, Integer apid, String title, Integer typeId, Integer columnId, String publishTime, Byte status) {
        return apMapper.getArticleList((page-1)*limit,limit,apid,title,typeId,columnId,publishTime,status);
    }


    @Override
    public int deleteByPrimaryKey(Integer apid) {
        return apMapper.delete(apid);
    }

    @Override
    public int updateByPrimaryKeySelective(Ap record) {
        return apMapper.updateByPrimaryKeySelective(record);
    }

    @Override
    public List<Ap> getArticleAndProblemListAll(Integer page, Integer limit) {
        return apMapper.getArticleAndProblemListAll(page,limit);
    }

    @Override
    public java.util.List<com.fjnu.kbms.bean.Ap> getArticleAndProblemListByType(Integer page, Integer limit, Integer type) {
        return apMapper.getArticleAndProblemListByType(page,limit,type);
    }

    @Override
    public Ap getArticleById(Integer apid) {
        return apMapper.selectByPrimaryKey(apid);
    }
}
