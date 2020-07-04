package com.fjnu.kbms.service;

import com.fjnu.kbms.bean.Type;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface TypeService {
    Type selectByPrimaryKey(Integer typeId);

    List<Type> getAllTypes();

}
