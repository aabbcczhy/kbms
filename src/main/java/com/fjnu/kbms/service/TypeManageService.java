package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Column;
import com.fjnu.kbms.bean.Type;
import com.fjnu.kbms.vo.ColumnListVO;

import java.util.Vector;

/**
 * <h3>kbms</h3>
 * <p>分类管理service接口</p>
 *
 * @author : guoweicheng
 * @date : 2020-07-05 23:31
 **/
public interface TypeManageService {
    public Vector<Type> getAllType();

    public int typeEdit(Type type);

    public Type typeSearch(int typeId);

    public int typeAdd(Type type);

}
