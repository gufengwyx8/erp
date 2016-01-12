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
					<s:iterator value="deliveryList" var="p">
					{
						"delivery.id":"<s:property value='#p.id' escape='false'/>",
						"delivery.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"delivery.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"delivery.consumer":"<s:property value='#p.consumer' escape='false'/>",
						"delivery.count":"<s:property value='#p.count' escape='false'/>",
						"delivery.deliverCount":"<s:property value='#p.deliverCount' escape='false'/>",
						"delivery.price":"<s:property value='#p.price' escape='false'/>",
						"delivery.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"delivery.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
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
			客户收货列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="delivery.id" width="50">订单编号</th>
						<th field="delivery.product.name" width="50">产品名称</th>
						<th field="delivery.product.id" width="50">产品编号</th>
						<th field="delivery.consumer" width="50">客户名称</th>
						<th field="delivery.count" width="50">配送数量</th>
						<th field="delivery.deliverCount" width="50">收货数量</th>
						<th field="delivery.price" width="50">价格</th>
						<th field="delivery.user.name" width="50">登记人</th> 
						<th field="delivery.date" width="50">登记时间</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建客户收货单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改客户收货单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('delivery/destoryDelivery','delivery.id')">删除客户收货单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">客户收货单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="delivery.id" />
					<div class="fitem">
						<label>产品名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="delivery.product.id" style="width:160px;" id="book" required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>客户名称:</label>
						<input name="delivery.consumer"/>
					</div>
					<div class="fitem">
						<label>配送数量:</label>
						<input name="delivery.count"/>
					</div>
					<div class="fitem">
						<label>收货数量:</label>
						<input name="delivery.deliverCount"/>
					</div>
					<div class="fitem">
						<label>价格:</label>
						<input name="delivery.price"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('delivery/saveDelivery',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
