package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.Ap;
import com.fjnu.kbms.dao.ApMapper;
import com.fjnu.kbms.service.ApService;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ApServiceImpl implements ApService {

    private final ApMapper apMapper;

    public ApServiceImpl(ApMapper apMapper) {
        this.apMapper = apMapper;
    }

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
    public int addArticle(Ap ap) {
        return apMapper.insertSelective(ap);
    }

    @Override
    public List<Ap> getArticleAndProblemListAll(Integer page, Integer limit) {
        return apMapper.getArticleAndProblemListAll(page,limit);
    }

    @Override
    public java.util.List<com.fjnu.kbms.bean.Ap> getArticleAndProblemListByColumn(Integer page, Integer limit, Integer columnId) {
        return apMapper.getArticleAndProblemListByColumn(page, limit, columnId);
    }

    @Override
    public Ap getApById(Integer apid){
        return apMapper.selectByPrimaryKey(apid);
    }

    @Override
    public void updateScan(Integer apid) {
        apMapper.updateScan(apid);
    }

    @Override
    public Ap getArticleById(Integer apid) {
        return apMapper.selectByPrimaryKey(apid);
    }
}
