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
					<s:iterator value="processDetailList" var="p" status="i">
					{
						"processDetail.id":"<s:property value='#p.id' escape='false'/>",
						"processDetail.name":"<s:property value='#p.name' escape='false'/>",
						"processDetail.index":"<s:property value='#i.index+1' escape='false'/>",
						"processDetail.description":"<s:property value='#p.description' escape='false'/>",
						"processDetail.workTime":"<s:property value='#p.workTime' escape='false'/>",
						"processDetail.unit":"<s:property value='#p.unit' escape='false'/>",
						"processDetail.timeCost":"<s:property value='#p.timeCost' escape='false'/>",
						"processDetail.total":"<s:property value='#p.workTime*#p.timeCost' escape='false'/>",
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
				产品名称：<s:property value="process.product.name"/>
			</div>
			<div>
				产品编号：<s:property value="process.product.id"/>
			</div>
			<div>
				设计人：<s:property value="process.designer"/>
			</div>
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="processDetail.name" width="50">工序名称</th>
						<th field="processDetail.index" width="50">工序编号</th>
						<th field="processDetail.description" width="50">描述</th>
						<th field="processDetail.workTime" width="50">工时数</th>
						<th field="processDetail.unit" width="50">工时单位</th>
						<th field="processDetail.timeCost" width="50">单位工时成本</th>
						<th field="processDetail.total" width="50">工时成本小计（元）</th>
					</tr>
				</thead>
			</table>
			<div>
				登记人：<s:property value="process.user.name"/>
			</div>
			<div>
				登记时间：<s:date name="process.date" format="yyyy-MM-dd HH:mm:ss"/>
			</div>
			<div>
				设计要求：<s:property value="process.description"/>
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建工序单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改工序单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('process/destoryProcessDetail','processDetail.id')">删除工序单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">工序单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="processDetail.id" />
					<div class="fitem">
						<label>工序名称:</label>
						<input name="processDetail.name">
					</div>
					<div class="fitem">
						<label>描述:</label>
						<input name="processDetail.description">
					</div>
					<div class="fitem">
						<label>工时数:</label>
						<input name="processDetail.workTime">
					</div>
					<div class="fitem">
						<label>工时单位:</label>
						<input name="processDetail.unit">
					</div>
					<div class="fitem">
						<label>单位工时成本:</label>
						<input name="processDetail.timeCost">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('process/saveProcessDetail?processDetail.process.id=<s:property value="process.id"/>',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
