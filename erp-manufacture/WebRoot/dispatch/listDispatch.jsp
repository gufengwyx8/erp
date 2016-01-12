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
					<s:iterator value="dispatchList" var="p">
					{
						"dispatch.id":"<s:property value='#p.id' escape='false'/>",
						"dispatch.designer":"<s:property value='#p.designer' escape='false'/>",
						"dispatch.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"dispatch.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"dispatch.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"dispatch.description":"<s:property value='#p.description' escape='false'/>",
						"dispatch.count":"<s:property value='#p.count' escape='false'/>",
						"dispatch.remark":"<s:property value='#p.remark' escape='false'/>",
						"dispatch.materiel.id":"<s:property value='#p.materiel.id' escape='false'/>",
						"dispatch.date":"<s:date name='#p.date' format='yyyy-MM-dd'/>",
						"dispatch.startDate":"<s:date name='#p.startDate' format='yyyy-MM-dd'/>",
						"dispatch.endDate":"<s:date name='#p.endDate' format='yyyy-MM-dd'/>",
						"dispatch.show":"<a href='dispatch/showDispatch?dispatch.id=<s:property value="#p.id"/>'>查看生产调度</a>",
						"dispatch.realCost":"<a href='realCost/listRealCost?dispatch.id=<s:property value="#p.id"/>'>登记实际成本</a>",
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
			生产调度列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="dispatch.designer" width="50">工单指定人</th>
						<th field="dispatch.user.name" width="50">登记人</th>
						<th field="dispatch.date" width="50">登记时间</th>
						<th field="dispatch.startDate" width="50">开工时间</th>
						<th field="dispatch.endDate" width="50">完工时间</th>
						<th field="dispatch.product.id" width="50">产品编号</th>
						<th field="dispatch.product.name" width="50">产品名称</th>
						<th field="dispatch.description" width="50">描述</th>
						<th field="dispatch.count" width="50">数量</th>
						<th field="dispatch.show" width="50">查看生产调度</th>
						<th field="dispatch.realCost" width="50">登记实际成本</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建生产调度单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改生产调度单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('dispatch/destoryDispatch','dispatch.id')">删除生产调度单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">生产调度单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="dispatch.id" />
					<input type="hidden" name="dispatch.materiel.id" />
					<div class="fitem">
						<label>工单指定人:</label>
						<input name="dispatch.designer">
					</div>
					<div class="fitem">
						<label>开工时间:</label>
						<input class="easyui-datebox" name="dispatch.startDate" data-options="formatter:myformatter,parser:myparser"></input>
					</div>
					<div class="fitem">
						<label>完工时间:</label>
						<input class="easyui-datebox" name="dispatch.endDate" data-options="formatter:myformatter,parser:myparser"></input>
					</div>
					<div class="fitem">
						<label>产品名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="dispatch.product.id" style="width:160px;" id="book" required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>描述:</label>
						<input name="dispatch.description">
					</div>
					<div class="fitem">
						<label>数量:</label>
						<input name="dispatch.count">
					</div>
					<div class="fitem">
						<label>备注:</label>
						<input name="dispatch.remark">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('dispatch/saveDispatch',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
