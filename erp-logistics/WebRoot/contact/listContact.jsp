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
					<s:iterator value="contactList" var="p">
					{
						"contact.id":"<s:property value='#p.id' escape='false'/>",
						"contact.record.id":"<s:property value='#p.record.id' escape='false'/>",
						"contact.record.name":"<s:property value='#p.record.name' escape='false'/>",
						"contact.record.contactor":"<s:property value='#p.record.contactor' escape='false'/>",
						"contact.record.tel":"<s:property value='#p.record.tel' escape='false'/>",
						"contact.reason":"<s:property value='#p.reason' escape='false'/>",
						"contact.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"contact.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"contact.show":"<a href='contact/listContactDetail?contact.id=<s:property value="#p.id"/>'>查看联络登记单</a>",
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
			联络登记列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="contact.record.name" width="50">物流单位名称</th>
						<th field="contact.record.contactor" width="50">被联络人</th>
						<th field="contact.reason" width="50">联络理由</th>
						<th field="contact.record.tel" width="50">电话</th> 
						<th field="contact.user.name" width="50">联络人</th> 
						<th field="contact.date" width="50">联络时间</th>
						<th field="contact.show" width="50">查看联络登记单</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建联络登记单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改联络登记单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('contact/destoryContact','contact.id')">删除联络登记单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">联络登记单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="contact.id" />
					<div class="fitem">
						<label>物流单位名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="contact.record.id" style="width:160px;" id="book" required="true">
							<s:iterator value="recordList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>联络理由:</label>
						<input name="contact.reason"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('contact/saveContact',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
