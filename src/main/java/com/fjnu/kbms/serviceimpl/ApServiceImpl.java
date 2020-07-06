package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.Ap;
import com.fjnu.kbms.dao.ApMapper;
import com.fjnu.kbms.service.ApService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ApServiceImpl implements ApService {

    private final ApMapper apMapper;

    public ApServiceImpl(ApMapper apMapper) {
        this.apMapper = apMapper;
    }

    @Override
    public Ap getApById(Integer apid) {
        return apMapper.selectByPrimaryKey(apid);
    }

    @Override
    public void updateScan(Integer apid) {
        apMapper.updateScan(apid);
    }
}
