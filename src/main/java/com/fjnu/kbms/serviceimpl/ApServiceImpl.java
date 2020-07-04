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
    public List<Ap> getProblemList(Integer page,Integer limit,Integer apid,Integer typeId,String publishTime,Byte status) {
        return apMapper.getProblemList((page-1)*limit,limit,apid,typeId,publishTime,status);
    }

    @Override
    public int deleteByPrimaryKey(Integer apid) {
        return apMapper.deleteByPrimaryKey(apid);
    }

    @Override
    public int updateByPrimaryKeySelective(Ap record) {
        return apMapper.updateByPrimaryKeySelective(record);
    }
}
