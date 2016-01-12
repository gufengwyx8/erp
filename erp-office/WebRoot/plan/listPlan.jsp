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
					<s:iterator value="planList" var="p">
					{
						"plan.id":"<s:property value='#p.id' escape='false'/>",
						"plan.title":"<s:property value='#p.title' escape='false'/>",
						"plan.meeting.title":"<s:property value='#p.title' escape='false'/>",
						"plan.type":"<s:property value='#p.type' escape='false'/>",
						"plan.meeting.title":"<s:property value='#p.meeting.title' escape='false'/>",
						"plan.organ":"<s:property value='#p.organ' escape='false'/>",
						"plan.name":"<s:property value='#p.name' escape='false'/>",
						"plan.startDate":"<s:date name='#p.startDate' format='yyyy-MM-dd'/>",
						"plan.endDate":"<s:date name='#p.endDate' format='yyyy-MM-dd'/>",
						"plan.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"plan.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"plan.show":"<a href='plan/listPlanDetail?plan.id=<s:property value="#p.id"/>'>查看详细信息</a>",
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
			计划信息列表
		</div>
		<div style="width: 90%; margin: 0 auto;">
			<table id="dg" style="height: 350px;">
				<thead>
					<tr>
						<th field="plan.id" width="50">
							编号
						</th>
						<th field="plan.title" width="50">
							主题
						</th>
						<th field="plan.meeting.title" width="50">
							会议主题
						</th>
						<th field="plan.startDate" width="50">
							开始时间
						</th>
						<th field="plan.endDate" width="50">
							结束时间
						</th>
						<th field="plan.user.name" width="50">
							登记人
						</th>
						<th field="plan.date" width="50">
							登记时间
						</th>
						<th field="plan.show" width="50">
							查看详细信息
						</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="newData()">新建</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editData()">修改</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true"
					onclick="destroyData('plan/destoryPlan','plan.id')">删除</a>
			</div>
			<div id="dlg" class="easyui-dialog"
				style="width: 400px; height: 280px; padding: 10px 20px"
				closed="true" buttons="#dlg-buttons">
				<div class="ftitle">
					计划信息
				</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="plan.id" />
					<div class="fitem">
						<label>
							计划主题:
						</label>
						<input name="plan.title" />
					</div>
					<div class="fitem">
						<label>
							计划类型:
						</label>
						<select class="easyui-combobox easyui-validatebox"
							name="plan.type" style="width: 160px;" required="true">
							<option value="日计划">日计划</option>
							<option value="周计划">周计划</option>
							<option value="月计划">月计划</option>
							<option value="年计划">年计划</option>
						</select>
					</div>
					<div class="fitem">
						<label>
							计划机构:
						</label>
						<input name="plan.organ" />
					</div>
					<div class="fitem">
						<label>
							姓名:
						</label>
						<input name="plan.name" />
					</div>
					<div class="fitem">
						<label>
							开始时间:
						</label>
						<input class="easyui-datebox" name="plan.startDate"
							data-options="formatter:myformatter,parser:myparser"></input>
					</div>
					<div class="fitem">
						<label>
							结束时间:
						</label>
						<input class="easyui-datebox" name="plan.endDate"
							data-options="formatter:myformatter,parser:myparser"></input>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok" onclick="saveData('plan/savePlan?plan.meeting.id=<s:property value="meeting.id"/>',saveSuccess)">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
