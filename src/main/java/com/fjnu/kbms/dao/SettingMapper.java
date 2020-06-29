package com.fjnu.kbms.dao;

import com.fjnu.kbms.bean.Setting;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface SettingMapper {
    int deleteByPrimaryKey(Integer settingId);

    int insert(Setting record);

    int insertSelective(Setting record);

    Setting selectByPrimaryKey(Integer settingId);

    int updateByPrimaryKeySelective(Setting record);

    int updateByPrimaryKey(Setting record);
}