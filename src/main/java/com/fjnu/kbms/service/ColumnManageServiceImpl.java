package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.dao.ColumnMapper;
import com.fjnu.kbms.vo.ColumnListVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

@Service
public class ColumnManageServiceImpl implements ColumnManageService{
    @Autowired
    ColumnMapper columnMapper;

    @Override
    public Vector<ColumnListVO> getAllColumn() {
        return columnMapper.selectAll();
    }


}
