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
					<s:iterator value="adList" var="p">
					{
						"ad.id":"<s:property value='#p.id' escape='false'/>",
						"ad.organ":"<s:property value='#p.organ' escape='false'/>",
						"ad.type":"<s:property value='#p.type' escape='false'/>",
						"ad.title":"<s:property value='#p.title' escape='false'/>",
						"ad.remark":"<s:property value='#p.remark' escape='false'/>",
						"ad.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"ad.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"ad.show":"<a href='ad/listAdDetail?ad.id=<s:property value="#p.id"/>'>查看详细信息</a>",
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
			宣传信息列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="ad.id" width="50">编号</th>
						<th field="ad.title" width="50">宣传主题</th>
						<th field="ad.type" width="50">宣传类型</th>
						<th field="ad.organ" width="50">机构</th>
						<th field="ad.user.name" width="50">登记人</th> 
						<th field="ad.date" width="50">登记时间</th>
						<th field="ad.show" width="50">查看详细信息</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('ad/destoryAd','ad.id')">删除</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">宣传信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="ad.id" />
					<div class="fitem">
						<label>宣传主题:</label>
						<input name="ad.title"/>
					</div>
					<div class="fitem">
						<label>机构:</label>
						<input name="ad.organ"/>
					</div>
					<div class="fitem">
						<label>宣传类型:</label>
						<select class="easyui-combobox easyui-validatebox" name="ad.type" style="width:160px;" id="book" required="true">
							<option value="报纸">报纸</option>
							<option value="网络">网络</option>
							<option value="广告">广告</option>
						</select>
					</div>
					<div class="fitem">
						<label>备注:</label>
						<input name="ad.remark"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('ad/saveAd',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
