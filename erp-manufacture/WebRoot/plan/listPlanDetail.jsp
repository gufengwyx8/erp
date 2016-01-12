<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme() + "://"
            + request.getServerName() + ":" + request.getServerPort()
            + path + "/";
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html>
	<head>
		<base href="<%=basePath%>" />

		<title>Index</title>
		<meta http-equiv="pragma" content="no-cache" />
		<meta http-equiv="cache-control" content="no-cache" />
		<meta http-equiv="expires" content="0" />
		<meta http-equiv="keywords" content="keyword1,keyword2,keyword3" />
		<meta http-equiv="description" content="This is my page" />
		<link rel="stylesheet" type="text/css" href="css/style.css" />
		<link rel="stylesheet" type="text/css"
			href="plugin/easyui/themes/default/easyui.css" />
		<link rel="stylesheet" type="text/css"
			href="plugin/easyui/themes/icon.css" />
		<script type="text/javascript" src="plugin/easyui/jquery.min.js"></script>
		<script type="text/javascript"
			src="plugin/easyui/jquery.easyui.min.js"></script>
		<script type="text/javascript" src="js/datagrid.js"></script>
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="planDetailList" var="p" status="i">
					{
						"planDetail.id":"<s:property value='#p.id' escape='false'/>",
						"planDetail.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"planDetail.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"planDetail.description":"<s:property value='#p.description' escape='false'/>",
						"planDetail.count":"<s:property value='#p.count' escape='false'/>",
						"planDetail.unit":"<s:property value='#p.unit' escape='false'/>",
						"planDetail.startDate":"<s:date name='#p.startDate' format='yyyy-MM-dd'/>",
						"planDetail.endDate":"<s:date name='#p.endDate' format='yyyy-MM-dd'/>",
						"planDetail.index":"<s:property value='#i.index+1' escape='false'/>",
					},
					</s:iterator>
				];
				return rows;
			}
			$(function(){
				initDataGrid($("#dg"),$("#dlg"),$("#fm"),getData());
			});
			function saveSuccess(e){
				if(e=="error"){
					$.messager.alert('提示','信息重复');
				}else if(e=="success"){
					$.messager.alert('提示','保存成功');
					location.href=location.href;
				}
			}
		</script>
	</head>
	<body>
		<jsp:include page="../top.jsp"></jsp:include>
		<div class="mainTitle">
			生产计划单
		</div>
		<div style="width:90%;margin:0 auto;">
			<div>
				计划设计人：<s:property value="plan.designer"/>
			</div>
			<div>
				登记人：<s:property value="plan.user.name"/>
			</div>
			<div>
				登记时间：<s:date name="plan.date" format="yyyy-MM-dd HH:mm:ss"/>
			</div>
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="planDetail.index" width="50">序号</th>
						<th field="planDetail.product.id" width="50">产品编号</th>
						<th field="planDetail.product.name" width="50">产品名称</th>
						<th field="planDetail.description" width="50">描述</th>
						<th field="planDetail.count" width="50">生产计划数量</th>
						<th field="planDetail.unit" width="50">单位</th>
						<th field="planDetail.startDate" width="50">计划生产日期</th>
						<th field="planDetail.endDate" width="50">计划完工日期</th>
					</tr>
				</thead>
			</table>
			<div>
				设计要求：<s:property value="plan.description"/>
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建生产计划单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改生产计划单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('plan/destoryPlanDetail','planDetail.id')">删除生产计划单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">生产计划单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="planDetail.id" />
					<div class="fitem">
						<label>产品名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="planDetail.product.id" style="width:160px;" id="book" required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>描述:</label>
						<input name="planDetail.description">
					</div>
					<div class="fitem">
						<label>生产计划数量:</label>
						<input name="planDetail.count">
					</div>
					<div class="fitem">
						<label>单位:</label>
						<input name="planDetail.unit">
					</div>
					<div class="fitem">
						<label>计划生产日期:</label>
						<input class="easyui-datebox" name="planDetail.startDate" data-options="formatter:myformatter,parser:myparser"></input>
					</div>
					<div class="fitem">
						<label>计划完工日期:</label>
						<input class="easyui-datebox" name="planDetail.endDate" data-options="formatter:myformatter,parser:myparser"></input>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('plan/savePlanDetail?planDetail.plan.id=<s:property value="plan.id"/>',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
