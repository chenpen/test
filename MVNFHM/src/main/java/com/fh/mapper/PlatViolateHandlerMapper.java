package com.fh.mapper;

import com.fh.entity.youguanzi.PlatViolateHandler;

public interface PlatViolateHandlerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatViolateHandler record);

    int insertSelective(PlatViolateHandler record);

    PlatViolateHandler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatViolateHandler record);

    int updateByPrimaryKey(PlatViolateHandler record);

    PlatViolateHandler findPlatViolateHandlerByInvalidId(Integer invalidId);
}