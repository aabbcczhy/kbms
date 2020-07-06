package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.Type;
import com.fjnu.kbms.dao.TypeMapper;

import com.fjnu.kbms.service.TypeManageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Vector;

/**
 * <h3>kbms</h3>
 * <p>分类管理service实现类</p>
 *
 * @author : guoweicheng
 * @date : 2020-07-05 23:33
 **/
@Service
public class TypeManageServiceImpl implements TypeManageService {

    @Autowired
    TypeMapper typeMapper;

    @Override
    public Vector<Type> getAllType() {
        return typeMapper.selectAll();
    }

    @Override
    public int typeEdit(Type type) {

        return typeMapper.updateByPrimaryKeySelective(type);
    }

    @Override
    public Type typeSearch(int typeId) {
        return typeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public int typeAdd(Type type) {
        return typeMapper.insertSelective(type);
    }

}
