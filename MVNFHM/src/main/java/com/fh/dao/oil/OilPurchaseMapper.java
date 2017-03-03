package com.fh.dao.oil;

import java.util.HashMap;
import java.util.List;

import com.fh.entity.oil.OilPurchase;
import com.fh.entity.vo.OilPurchaseQuery;

public interface OilPurchaseMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(OilPurchase record);

    int insertSelective(OilPurchase record);

    OilPurchase selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(OilPurchase record);

    int updateByPrimaryKey(OilPurchase record);
    
    List<OilPurchase> listPurchasePage(OilPurchaseQuery oilPurchase);

}