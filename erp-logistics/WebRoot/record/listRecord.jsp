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
					<s:iterator value="recordList" var="p">
					{
						"record.id":"<s:property value='#p.id' escape='false'/>",
						"record.name":"<s:property value='#p.name' escape='false'/>",
						"record.level":"<s:property value='#p.level' escape='false'/>",
						"record.id":"<s:property value='#p.id' escape='false'/>",
						"record.category":"<s:property value='#p.category' escape='false'/>",
						"record.area":"<s:property value='#p.area' escape='false'/>",
						"record.liable":"<s:property value='#p.liable' escape='false'/>",
						"record.tel":"<s:property value='#p.tel' escape='false'/>",
						"record.contactor":"<s:property value='#p.contactor' escape='false'/>",
						"record.url":"<s:property value='#p.url' escape='false'/>",
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
			物流单位档案列表
		</div>
		<div style="width: 90%; margin: 0 auto;">
			<table id="dg" style="height: 350px;">
				<thead>
					<tr>
						<th field="record.id" width="50">
							档案编号
						</th>
						<th field="record.name" width="50">
							物流单位名称
						</th>
						<th field="record.level" width="50">
							优质级别
						</th>
						<th field="record.category" width="50">
							产品分类
						</th>
						<th field="record.area" width="50">
							所在区域
						</th>
						<th field="record.liable" width="50">
							责任人
						</th>
						<th field="record.tel" width="50">
							联系电话
						</th>
						<th field="record.contactor" width="50">
							联系人
						</th>
						<th field="record.url" width="50">
							网址
						</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="newData()">新建物流单位档案</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editData()">修改物流单位档案</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true"
					onclick="destroyData('record/destoryRecord','record.id')">删除物流单位档案</a>
			</div>
			<div id="dlg" class="easyui-dialog"
				style="width: 400px; height: 280px; padding: 10px 20px"
				closed="true" buttons="#dlg-buttons">
				<div class="ftitle">
					物流单位档案信息
				</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="record.id" />
					<div class="fitem">
						<label>
							物流单位名称:
						</label>
						<input name="record.name" />
					</div>
					<div class="fitem">
						<label>
							优质级别:
						</label>
						<input name="record.level" />
					</div>
					<div class="fitem">
						<label>
							产品分类:
						</label>
						<input name="record.category" />
					</div>
					<div class="fitem">
						<label>
							所在区域:
						</label>
						<input name="record.area" />
					</div>
					<div class="fitem">
						<label>
							责任人:
						</label>
						<input name="record.liable" />
					</div>
					<div class="fitem">
						<label>
							联系电话:
						</label>
						<input name="record.tel" />
					</div>
					<div class="fitem">
						<label>
							联系人:
						</label>
						<input name="record.contactor" />
					</div>
					<div class="fitem">
						<label>
							网址:
						</label>
						<input name="record.url" />
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok"
					onclick="saveData('record/saveRecord',saveSuccess)">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
