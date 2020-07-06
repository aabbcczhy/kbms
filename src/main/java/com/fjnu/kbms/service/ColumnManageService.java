package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.vo.ColumnListVO;
import com.fjnu.kbms.vo.TableVO;

import java.util.Vector;

public interface ColumnManageService {
    public Vector<ColumnListVO> getAllColumn();

    public int columnEdit(Column column);

    public Column columnSearch(int columnId);

    public int columnAdd(Column column);

}
