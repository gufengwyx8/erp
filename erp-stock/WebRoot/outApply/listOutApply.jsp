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
					<s:iterator value="outApplyList" var="p">
					{
						"outApply.id":"<s:property value='#p.id' escape='false'/>",
						"outApply.designer":"<s:property value='#p.designer' escape='false'/>",
						"outApply.description":"<s:property value='#p.description' escape='false'/>",
						"outApply.back":"<s:property value='#p.back' escape='false'/>",
						"outApply.remark":"<s:property value='#p.remark' escape='false'/>",
						"outApply.reason":"<s:property value='#p.reason' escape='false'/>",
						"outApply.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"outApply.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"outApply.backDate":"<s:date name='#p.backDate' format='yyyy-MM-dd HH:mm:ss'/>",
						"outApply.show":"<a href='outApply/listOutApplyDetail?outApply.id=<s:property value="#p.id"/>'>查看出库申请单</a>",
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
			出库申请单列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="outApply.id" width="50">申请单编号</th>
						<th field="outApply.designer" width="50">出库人</th>
						<th field="outApply.reason" width="50">出库理由</th>
						<th field="outApply.back" width="50">是否归还</th>
						<th field="outApply.backDate" width="50">归还时间</th>
						<th field="outApply.user.name" width="50">登记人</th> 
						<th field="outApply.date" width="50">登记时间</th>
						<th field="outApply.show" width="50">查看出库申请单</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建出库申请单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改出库申请单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('outApply/destoryOutApply','outApply.id')">删除出库申请单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">出库申请单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="outApply.id" />
					<div class="fitem">
						<label>出库人:</label>
						<input name="outApply.designer">
					</div>
					<div class="fitem">
						<label>出库理由:</label>
						<input name="outApply.reason">
					</div>
					<div class="fitem">
						<label>是否归还:</label>
						<select name="outApply.back">
							<option value="true">是</option>
							<option value="false">否</option>
						</select>
					</div>
					<div class="fitem">
						<label>归还时间:</label>
						<input class="easyui-datebox" name="outApply.backDate" data-options="formatter:myformatter,parser:myparser"></input>
					</div>
					<div class="fitem">
						<label>备注:</label>
						<input name="outApply.remark">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('outApply/saveOutApply',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
