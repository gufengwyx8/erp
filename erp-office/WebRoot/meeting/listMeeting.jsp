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
					<s:iterator value="meetingList" var="p">
					{
						"meeting.id":"<s:property value='#p.id' escape='false'/>",
						"meeting.title":"<s:property value='#p.title' escape='false'/>",
						"meeting.startDate":"<s:date name='#p.startDate' format='yyyy-MM-dd'/>",
						"meeting.endDate":"<s:date name='#p.endDate' format='yyyy-MM-dd'/>",
						"meeting.address":"<s:property value='#p.address' escape='false'/>",
						"meeting.remark":"<s:property value='#p.remark' escape='false'/>",
						"meeting.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"meeting.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"meeting.show":"<a href='meeting/listMeetingDetail?meeting.id=<s:property value="#p.id"/>'>查看详细信息</a>",
						"meeting.plan":"<a href='plan/listPlan?meeting.id=<s:property value="#p.id"/>'>查看计划信息</a>",
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
			会议信息列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="meeting.id" width="50">编号</th>
						<th field="meeting.title" width="50">主题</th>
						<th field="meeting.startDate" width="50">开始时间</th>
						<th field="meeting.endDate" width="50">结束时间</th>
						<th field="meeting.address" width="50">会议地点</th>
						<th field="meeting.user.name" width="50">登记人</th> 
						<th field="meeting.date" width="50">登记时间</th>
						<th field="meeting.show" width="50">查看详细信息</th>
						<th field="meeting.plan" width="50">查看计划信息</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('meeting/destoryMeeting','meeting.id')">删除</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">会议信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="meeting.id" />
					<div class="fitem">
						<label>会议主题:</label>
						<input name="meeting.title"/>
					</div>
					<div class="fitem">
						<label>开始时间:</label>
						<input class="easyui-datebox" name="meeting.startDate" data-options="formatter:myformatter,parser:myparser"></input>
					</div>
					<div class="fitem">
						<label>结束时间:</label>
						<input class="easyui-datebox" name="meeting.endDate" data-options="formatter:myformatter,parser:myparser"></input>
					</div>
					<div class="fitem">
						<label>会议地点:</label>
						<input name="meeting.address"/>
					</div>
					<div class="fitem">
						<label>备注:</label>
						<input name="meeting.remark"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('meeting/saveMeeting',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
