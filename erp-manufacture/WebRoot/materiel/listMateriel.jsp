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
					<s:iterator value="materielList" var="m">
					{
						"materiel.id":"<s:property value='#m.id' escape='false'/>",
						"materiel.process.id":"<s:property value='#m.process.id' escape='false'/>",
						"materiel.process.product.id":"<s:property value='#m.process.product.id' escape='false'/>",
						"materiel.process.product.name":"<s:property value='#m.process.product.name' escape='false'/>",
						"materiel.process.designer":"<s:property value='#m.process.designer' escape='false'/>",
						"materiel.process.user.name":"<s:property value='#m.process.user.name' escape='false'/>",
						"materiel.process.date":"<s:date name='#m.process.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"materiel.show":"<a href='materiel/showMateriel?materiel.id=<s:property value="#m.id"/>'>查看物料清单</a>",
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
			工序物料设计单列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="materiel.id" width="50">物料设计单编号</th>
						<th field="materiel.process.id" width="50">工序单编号</th>
						<th field="materiel.process.product.name" width="50">产品名称</th>
						<th field="materiel.process.product.id" width="50">产品编号</th>
						<th field="materiel.process.designer" width="50">设计人</th>
						<th field="materiel.process.user.name" width="50">登记人</th>
						<th field="materiel.process.date" width="50">登记时间</th>
						<th field="materiel.show" width="50">查看物料清单</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('materiel/destoryMateriel','materiel.id')">删除物料设计单</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
