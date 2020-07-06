package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.dao.ColumnMapper;
import com.fjnu.kbms.service.ColumnService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class ColumnServiceImpl implements ColumnService {
    @Autowired
    ColumnMapper columnMapper;
    @Override
    public Column selectByPrimaryKey(Integer columnId) {
        return columnMapper.selectByPrimaryKey(columnId);
    }

    @Override
    public List<Column> getAllColumns() {
        return columnMapper.selectByColumnId();
    }
}
