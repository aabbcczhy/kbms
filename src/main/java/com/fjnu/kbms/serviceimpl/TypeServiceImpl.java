package com.fjnu.kbms.serviceimpl;

import com.fjnu.kbms.bean.Type;
import com.fjnu.kbms.dao.TypeMapper;
import com.fjnu.kbms.service.TypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeServiceImpl implements TypeService {
    @Autowired
    TypeMapper typeMapper;
    @Override
    public Type selectByPrimaryKey(Integer typeId) {
        return typeMapper.selectByPrimaryKey(typeId);
    }

    @Override
    public List<Type> getAllTypes() {
        return typeMapper.selectByTypeId();
    }
}
