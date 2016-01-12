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
					<s:iterator value="safeStockList" var="p">
					{
						"safeStock.id":"<s:property value='#p.id' escape='false'/>",
						"safeStock.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"safeStock.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"safeStock.designer":"<s:property value='#p.designer' escape='false'/>",
						"safeStock.description":"<s:property value='#p.description' escape='false'/>",
						"safeStock.alertButtom":"<s:property value='#p.alertButtom' escape='false'/>",
						"safeStock.alertTop":"<s:property value='#p.alertTop' escape='false'/>",
						"safeStock.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"safeStock.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"safeStock.show":"<a href='safeStock/listSafeStockDetail?safeStock.id=<s:property value="#p.id"/>'>查看安全库存配置单</a>",
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
			安全库存配置列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="safeStock.id" width="50">工序单编号</th>
						<th field="safeStock.product.name" width="50">产品名称</th>
						<th field="safeStock.product.id" width="50">产品编号</th>
						<th field="safeStock.designer" width="50">设计人</th>
						<th field="safeStock.alertButtom" width="50">库存预警下限</th>
						<th field="safeStock.alertTop" width="50">库存预警上限</th>
						<th field="safeStock.user.name" width="50">登记人</th> 
						<th field="safeStock.date" width="50">登记时间</th>
						<th field="safeStock.show" width="50">查看安全库存配置单</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建安全库存配置单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改安全库存配置单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('safeStock/destorySafeStock','safeStock.id')">删除安全库存配置单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">工序单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="safeStock.id" />
					<div class="fitem">
						<label>产品名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="safeStock.product.id" style="width:160px;" id="book" required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>库存预警下限:</label>
						<input name="safeStock.alertButtom">
					</div>
					<div class="fitem">
						<label>库存预警上限:</label>
						<input name="safeStock.alertTop">
					</div>
					<div class="fitem">
						<label>设计人:</label>
						<input name="safeStock.designer">
					</div>
					<div class="fitem">
						<label>配置要求:</label>
						<input name="safeStock.description">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('safeStock/saveSafeStock',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
