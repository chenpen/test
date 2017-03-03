package com.fh.controller.oil.purchase;

import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.annotation.Resource;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import com.fh.controller.base.BaseController;
import com.fh.entity.Page;
import com.fh.entity.plat.PlatViolateHandler;
import com.fh.util.AppUtil;
import com.fh.util.ObjectExcelView;
import com.fh.util.PageData;
import com.fh.util.Jurisdiction;
import com.fh.util.Tools;
import com.fh.service.oil.purchase.PurchaseManager;

/** 
 * 说明：求购管理
 * 创建人：FH Q313596790
 * 创建时间：2017-02-17
 */
@Controller
@RequestMapping(value="/purchase")
public class PurchaseController extends BaseController {
	
	String menuUrl = "purchase/list.do"; //菜单地址(权限用)
	@Resource(name="purchaseService")
	private PurchaseManager purchaseService;
//	@Resource(name="")
//	private PurchaseManager purchaseService;
	
	/**保存
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/save")
	public ModelAndView save() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"新增Purchase");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "add")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		pd.put("PURCHASE_ID", this.get32UUID());	//主键
		purchaseService.save(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**
	 * 标记违规
	 */
	@RequestMapping(value="/updateViolationStatus")
	public ModelAndView updateViolationStatus(PlatViolateHandler platViolateHandler) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"标记违规/updateViolationStatus");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		HashMap resMap=new HashMap();
		int count=purchaseService.updateViolationStatus(platViolateHandler);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}

	/**删除
	 * @param out
	 * @throws Exception
	 */
	@RequestMapping(value="/delete")
	public void delete(PrintWriter out) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"删除Purchase");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return;} //校验权限
		PageData pd = new PageData();
		pd = this.getPageData();
		purchaseService.delete(pd);
		out.write("success");
		out.close();
	}
	
	/**修改
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/edit")
	public ModelAndView edit() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"修改Purchase");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "edit")){return null;} //校验权限
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		purchaseService.edit(pd);
		mv.addObject("msg","success");
		mv.setViewName("save_result");
		return mv;
	}
	
	/**列表
	 * @param page
	 * @throws Exception
	 */
	@RequestMapping(value="/list")
	public ModelAndView list(Page page) throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"列表Purchase");
		//if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;} //校验权限(无权查看时页面会有提示,如果不注释掉这句代码就无法进入列表页面,所以根据情况是否加入本句代码)
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		String keywords = pd.getString("keywords");				//关键词检索条件
		if(null != keywords && !"".equals(keywords)){
			pd.put("keywords", keywords.trim());
		}
		page.setPd(pd);
		List<PageData>	varList = purchaseService.list(page);	//列出Purchase列表
		mv.setViewName("oil/purchase/purchase_list");
		mv.addObject("varList", varList);
		mv.addObject("pd", pd);
//		mv.addObject("categoryList", categoryList);
		mv.addObject("QX",Jurisdiction.getHC());	//按钮权限
		return mv;
	}
	
	/**去新增页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goAdd")
	public ModelAndView goAdd()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("oil/purchase/purchase_edit");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
	}	
	
	 /**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goEdit")
	public ModelAndView goEdit()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		HashMap purchase = purchaseService.findById(pd);	//根据ID读取
		pd.put("purchase", purchase);
		pd.put("plat_violate_handler", "oil_purchase");
		pd.put("invalid_id", pd.get("id"));
		PlatViolateHandler platViolateHandler=purchaseService.findPlatViolateHandlerByInvalidId(pd);
		pd.put("platViolateHandler", platViolateHandler);
		mv.setViewName("oil/purchase/purchase_edit");
		mv.addObject("msg", "updateViolationStatus");
		mv.addObject("pd", pd);
		
		return mv;
	}	
	/**去修改页面
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/goUpdateViolationStatus")
	public ModelAndView goUpdateViolationStatus()throws Exception{
		ModelAndView mv = this.getModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		mv.setViewName("oil/purchase/goUpdateViolationStatus");
		mv.addObject("msg", "save");
		mv.addObject("pd", pd);
		return mv;
		
	}	
	
	 /**批量删除
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/deleteAll")
	@ResponseBody
	public Object deleteAll() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"批量删除Purchase");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "del")){return null;} //校验权限
		PageData pd = new PageData();		
		Map<String,Object> map = new HashMap<String,Object>();
		pd = this.getPageData();
		List<PageData> pdList = new ArrayList<PageData>();
		String DATA_IDS = pd.getString("DATA_IDS");
		if(null != DATA_IDS && !"".equals(DATA_IDS)){
			String ArrayDATA_IDS[] = DATA_IDS.split(",");
			purchaseService.deleteAll(ArrayDATA_IDS);
			pd.put("msg", "ok");
		}else{
			pd.put("msg", "no");
		}
		pdList.add(pd);
		map.put("list", pdList);
		return AppUtil.returnObject(pd, map);
	}
	
	 /**导出到excel
	 * @param
	 * @throws Exception
	 */
	@RequestMapping(value="/excel")
	public ModelAndView exportExcel() throws Exception{
		logBefore(logger, Jurisdiction.getUsername()+"导出Purchase到excel");
		if(!Jurisdiction.buttonJurisdiction(menuUrl, "cha")){return null;}
		ModelAndView mv = new ModelAndView();
		PageData pd = new PageData();
		pd = this.getPageData();
		Map<String,Object> dataMap = new HashMap<String,Object>();
		List<String> titles = new ArrayList<String>();
		titles.add("备注1");	//1
		titles.add("备注2");	//2
		titles.add("备注3");	//3
		titles.add("备注4");	//4
		titles.add("备注5");	//5
		titles.add("备注6");	//6
		titles.add("备注7");	//7
		titles.add("备注8");	//8
		titles.add("备注9");	//9
		titles.add("备注10");	//10
		titles.add("备注11");	//11
		titles.add("备注12");	//12
		titles.add("备注13");	//13
		titles.add("备注14");	//14
		titles.add("备注15");	//15
		titles.add("备注16");	//16
		dataMap.put("titles", titles);
		List<PageData> varOList = purchaseService.listAll(pd);
		List<PageData> varList = new ArrayList<PageData>();
		for(int i=0;i<varOList.size();i++){
			PageData vpd = new PageData();
			vpd.put("var1", varOList.get(i).get("ID").toString());	//1
			vpd.put("var2", varOList.get(i).get("MERCHANT_ID").toString());	//2
			vpd.put("var3", varOList.get(i).get("PUBLISHER_ID").toString());	//3
			vpd.put("var4", varOList.get(i).get("QUANTITY").toString());	//4
			vpd.put("var5", varOList.get(i).get("STATUS").toString());	//5
			vpd.put("var6", varOList.get(i).get("OIL_LEVEL_ID").toString());	//6
			vpd.put("var7", varOList.get(i).get("OIL_CATEGORY_ID").toString());	//7
			vpd.put("var8", varOList.get(i).get("OIL_FLAG_ID").toString());	//8
			vpd.put("var9", varOList.get(i).get("OIL_AREA_ID").toString());	//9
			vpd.put("var10", varOList.get(i).getString("CREATE_TIME"));	    //10
			vpd.put("var11", varOList.get(i).getString("REMARK"));	    //11
			vpd.put("var12", varOList.get(i).getString("DESCRIPTION"));	    //12
			vpd.put("var13", varOList.get(i).getString("PRICE"));	    //13
			vpd.put("var14", varOList.get(i).getString("PURCHASE_NO"));	    //14
			vpd.put("var15", varOList.get(i).getString("FETCH_TIME"));	    //15
			vpd.put("var16", varOList.get(i).getString("LAST_UPDATE_TIME"));	    //16
			varList.add(vpd);
		}
		dataMap.put("varList", varList);
		ObjectExcelView erv = new ObjectExcelView();
		mv = new ModelAndView(erv,dataMap);
		return mv;
	}
	
	@InitBinder
	public void initBinder(WebDataBinder binder){
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		binder.registerCustomEditor(Date.class, new CustomDateEditor(format,true));
	}
}
