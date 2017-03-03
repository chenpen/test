<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<!DOCTYPE html>
<html lang="en">
	<head>
	<base href="<%=basePath%>">
	<!-- 下拉框 -->
	<link rel="stylesheet" href="static/ace/css/chosen.css" />
	<!-- jsp文件头和头部 -->
	<%@ include file="../../system/index/top.jsp"%>
	<!-- 日期框 -->
	<link rel="stylesheet" href="static/ace/css/datepicker.css" />
</head>
<body class="no-skin">
<!-- /section:basics/navbar.layout -->
<div class="main-container" id="main-container">
	<!-- /section:basics/sidebar -->
	<div class="main-content">
		<div class="main-content-inner">
			<div class="page-content">
				<div class="row">
					<div class="col-xs-15">
					
					
						<div id="zhongxin" style="padding-top: 13px;">
						<form action="purchase/${msg }.do" name="Form" id="Form" method="post">
						<input type="hidden" name="ID" id="ID" value="${pd.purchase.ID}"/>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							<c:if test="${pd.platViolateHandler.status != 5 }">
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">商品是否违规:</td>
								<td><p class="form-control-static">否</p></td>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="weigui(${pd.purchase.ID});">标记为违规</a>
								</td>
							</tr>
							</c:if>
							<c:if test="${pd.platViolateHandler.status == 5 }">
							<tr>
								<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">商品是否违规:</td>
								<td><p class="form-control-static">${pd.platViolateHandler.status}</p></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">处理原因:</td>
								<td><p class="form-control-static">${pd.platViolateHandler.deal_reason}</p></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">违规说明:</td>
								<td><p class="form-control-static">${pd.platViolateHandler.deal_explanation}</p></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">处理备注:</td>
								<td><p class="form-control-static">这里是纯文字信息</p></td>
							</tr>
							</tr>
							</c:if>
							
							<!-- 
							<tr>
								<td style="text-align: center;" colspan="10">
									<a class="btn btn-mini btn-primary" onclick="save();">保存</a>
									<a class="btn btn-mini btn-danger" onclick="top.Dialog.close();">取消</a>
								</td>
							</tr>
							 -->
							
						</table>
						</form>
						<p class="form-control-static">基本信息</p>
						<table id="table_report" class="table table-striped table-bordered table-hover">
							
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">品类:</td>
								<td><p class="form-control-static">${pd.purchase.category_name}</p></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">标准:</td>
								<td><p class="form-control-static">${pd.purchase.level_name}</p></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">型号:</td>
								<td><p class="form-control-static">${pd.purchase.flag_name}</p></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">需求数量:</td>
								<td><p class="form-control-static">${pd.purchase.QUANTITY}</p></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">价格:</td>
								<td><p class="form-control-static">${pd.purchase.PRICE}</p></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">交货地点:</td>
								<td><p class="form-control-static">${pd.purchase.areaname}</p></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">交货日期:</td>
								<td><p class="form-control-static">${pd.purchase.fetch_time}</p></td>
								<td style="width:75px;text-align: right;padding-top: 13px;">更新时间:</td>
								<td><p class="form-control-static">${pd.purchase.LAST_UPDATE_TIME}</p></td>
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">采购商:</td>
								<td><p class="form-control-static">${pd.purchase.mer_name}</p></td>
								
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">采购商备注:</td>
								<td><p class="form-control-static">${pd.purchase.REMARK}</p></td>
								
							</tr>
							<tr>
								<td style="width:75px;text-align: right;padding-top: 13px;">求购说明:</td>
								<td><p class="form-control-static">${pd.purchase.DESCRIPTION}</p></td>
								
							</tr>
						</table>
						</div>
						<div id="zhongxin2" class="center" style="display:none"><br/><br/><br/><br/><br/><img src="static/images/jiazai.gif" /><br/><h4 class="lighter block green">提交中...</h4></div>
					
					
					</div>
					<!-- /.col -->
				</div>
				<!-- /.row -->
			</div>
			<!-- /.page-content -->
		</div>
	</div>
	<!-- /.main-content -->
</div>
<!-- /.main-container -->


	<!-- 页面底部js¨ -->
	<%@ include file="../../system/index/foot.jsp"%>
	<!-- 下拉框 -->
	<script src="static/ace/js/chosen.jquery.js"></script>
	<!-- 日期框 -->
	<script src="static/ace/js/date-time/bootstrap-datepicker.js"></script>
	<!--提示框-->
	<script type="text/javascript" src="static/js/jquery.tips.js"></script>
		<script type="text/javascript">
		$(top.hangge());
		function weigui(id){
			top.jzts();
			 var diag = new top.Dialog();
			 diag.Drag=true;
			 diag.Title ="编辑";
			 diag.URL = '<%=basePath%>purchase/goUpdateViolationStatus.do?id='+id;
			 diag.Width = 450;
			 diag.Height = 355;
			 diag.Modal = true;				//有无遮罩窗口
			 diag. ShowMaxButton = true;	//最大化按钮
		     diag.ShowMinButton = true;		//最小化按钮 
			 diag.CancelEvent = function(){ //关闭事件
				 if(diag.innerFrame.contentWindow.document.getElementById('zhongxin').style.display == 'none'){
					 nextPage(${page.currentPage});
				}
				diag.close();
			 };
			 diag.show();
		}
		
		
		$(function() {
			//日期框
			$('.date-picker').datepicker({autoclose: true,todayHighlight: true});
		});
		</script>
</body>
</html>