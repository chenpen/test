package com.fh.dao.plat;


import com.fh.entity.plat.PlatViolateHandler;
import com.fh.util.PageData;

public interface PlatViolateHandlerMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(PlatViolateHandler record);

    int insertSelective(PlatViolateHandler record);

    PlatViolateHandler selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(PlatViolateHandler record);

    int updateByPrimaryKey(PlatViolateHandler record);

    PlatViolateHandler findPlatViolateHandlerByInvalidId(PageData pd);
}