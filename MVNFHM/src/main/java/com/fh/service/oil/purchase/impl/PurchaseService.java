package com.fh.service.oil.purchase.impl;

import java.util.List;
import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.fh.dao.DaoSupport;
import com.fh.dao.oil.OilPurchaseMapper;
import com.fh.dao.plat.PlatViolateHandlerMapper;
import com.fh.entity.Page;
import com.fh.entity.oil.OilPurchase;
import com.fh.entity.plat.PlatViolateHandler;
import com.fh.util.PageData;
import com.fh.service.oil.purchase.PurchaseManager;

/** 
 * 说明： 求购管理
 * 创建人：FH Q313596790
 * 创建时间：2017-02-17
 * @version
 */
@Service("purchaseService")
public class PurchaseService implements PurchaseManager{

	@Resource(name = "daoSupport")
	private DaoSupport dao;
	@Autowired
    private OilPurchaseMapper oilPurchaseMapper;
	@Autowired
	private PlatViolateHandlerMapper platViolateHandlerMapper;
	
	/**新增
	 * @param pd
	 * @throws Exception
	 */
	public void save(PageData pd)throws Exception{
		dao.save("PurchaseMapper.save", pd);
	}
	
	/**删除
	 * @param pd
	 * @throws Exception
	 */
	public void delete(PageData pd)throws Exception{
		dao.delete("PurchaseMapper.delete", pd);
	}
	
	/**修改
	 * @param pd
	 * @throws Exception
	 */
	public void edit(PageData pd)throws Exception{
		dao.update("PurchaseMapper.edit", pd);
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> list(Page page)throws Exception{
		return (List<PageData>)dao.findForList("PurchaseMapper.datalistPage", page);
	}
	
	/**列表(全部)
	 * @param pd
	 * @throws Exception
	 */
	@SuppressWarnings("unchecked")
	public List<PageData> listAll(PageData pd)throws Exception{
		return (List<PageData>)dao.findForList("PurchaseMapper.listAll", pd);
	}
	
	/**通过id获取数据
	 * @param pd
	 * @throws Exception
	 */
	public PageData findById(PageData pd)throws Exception{
		return (PageData)dao.findForObject("PurchaseMapper.findById", pd);
	}
	
	/**批量删除
	 * @param ArrayDATA_IDS
	 * @throws Exception
	 */
	public void deleteAll(String[] ArrayDATA_IDS)throws Exception{
		dao.delete("PurchaseMapper.deleteAll", ArrayDATA_IDS);
	}
	
	/*
     * 通过id获取数据
     */
	public PlatViolateHandler findPlatViolateHandlerByInvalidId(PageData pd)throws Exception{
		//TODO
		return platViolateHandlerMapper.findPlatViolateHandlerByInvalidId(pd);
		}

	@Override
	public int updateViolationStatus(PlatViolateHandler platViolateHandler) {
		// TODO Auto-generated method stub
		platViolateHandler.setInvalidType("oil_purchase");
		platViolateHandler.setDealNo("VIO");
//		+ Tools.getRandomNum()
		platViolateHandlerMapper.insertSelective(platViolateHandler);
		if(platViolateHandler.getId()!=null){
			OilPurchase oilPurchase=new OilPurchase();
			oilPurchase.setId(platViolateHandler.getInvalidId());
			oilPurchase.setStatus(4);
			return oilPurchaseMapper.updateByPrimaryKeySelective(oilPurchase);
		}
		return 0;
	}
}

