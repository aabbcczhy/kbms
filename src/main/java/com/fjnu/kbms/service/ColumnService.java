package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Column;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface ColumnService {
    Column selectByPrimaryKey(Integer columnId);
    List<Column> getAllColumns();
}
