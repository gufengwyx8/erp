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
					<s:iterator value="safeStockDetailList" var="p" status="i">
					{
						"safeStockDetail.id":"<s:property value='#p.id' escape='false'/>",
						"safeStockDetail.name":"<s:property value='#p.name' escape='false'/>",
						"safeStockDetail.index":"<s:property value='#i.index+1' escape='false'/>",
						"safeStockDetail.address":"<s:property value='#p.address' escape='false'/>",
						"safeStockDetail.maxCount":"<s:property value='#p.maxCount' escape='false'/>",
						"safeStockDetail.unit":"<s:property value='#p.unit' escape='false'/>",
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
			生产工序设计单
		</div>
		<div style="width:90%;margin:0 auto;">
			<div>
				产品名称：<s:property value="safeStock.product.name"/>
			</div>
			<div>
				产品编号：<s:property value="safeStock.product.id"/>
			</div>
			<div>
				库存预警下限：<s:property value="safeStock.alertButtom"/>
			</div>
			<div>
				库存预警上限：<s:property value="safeStock.alertTop"/>
			</div>
			<div>
				设计人：<s:property value="safeStock.designer"/>
			</div>
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="safeStockDetail.index" width="50">序号</th>
						<th field="safeStockDetail.name" width="50">库房名称</th>
						<th field="safeStockDetail.address" width="50">存储地址</th>
						<th field="safeStockDetail.maxCount" width="50">最大存储量</th>
						<th field="safeStockDetail.unit" width="50">存储单位</th>
					</tr>
				</thead>
			</table>
			<div>
				登记人：<s:property value="safeStock.user.name"/>
			</div>
			<div>
				登记时间：<s:date name="safeStock.date" format="yyyy-MM-dd HH:mm:ss"/>
			</div>
			<div>
				设计要求：<s:property value="safeStock.description"/>
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建安全配置单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改安全配置单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('safeStock/destorySafeStockDetail','safeStockDetail.id')">删除安全配置单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">工序单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="safeStockDetail.id" />
					<div class="fitem">
						<label>库房名称:</label>
						<input name="safeStockDetail.name">
					</div>
					<div class="fitem">
						<label>存储地址:</label>
						<input name="safeStockDetail.address">
					</div>
					<div class="fitem">
						<label>最大存储量:</label>
						<input name="safeStockDetail.maxCount">
					</div>
					<div class="fitem">
						<label>存储单位:</label>
						<input name="safeStockDetail.unit">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('safeStock/saveSafeStockDetail?safeStockDetail.safeStock.id=<s:property value="safeStock.id"/>',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
