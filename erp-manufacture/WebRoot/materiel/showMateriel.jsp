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
		<s:set name="timeTotal" value="0"/>
		<s:set name="costTotal" value="0"/>
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="materiel.materielDetailList" var="m" status="i">
					{
						"materielDetail.id":"<s:property value='#m.id' escape='false'/>",
						"materielDetail.cost":"<s:property value='#m.cost' escape='false'/>",
						"materielDetail.processDetail.id":"<s:property value='#m.processDetail.id' escape='false'/>",
						"materielDetail.materiel.id":"<s:property value='#m.materiel.id' escape='false'/>",
						"processDetail.name":"<s:property value='#m.processDetail.name' escape='false'/>",
						"materielDetail.index":"<s:property value='#i.index+1' escape='false'/>",
						"processDetail.description":"<s:property value='#m.processDetail.description' escape='false'/>",
						"processDetail.workTime":"<s:property value='#m.processDetail.workTime' escape='false'/>",
						"processDetail.unit":"<s:property value='#m.processDetail.unit' escape='false'/>",
						"processDetail.timeCost":"<s:property value='#m.processDetail.timeCost' escape='false'/>",
						"processDetail.total":"<s:property value='#m.processDetail.workTime*#m.processDetail.timeCost' escape='false'/>",
					},
					<s:set name="timeTotal" value="#timeTotal+#m.processDetail.workTime*#m.processDetail.timeCost"/>
					<s:set name="costTotal" value="#costTotal+#m.cost"/>
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
			工序物料设计单
		</div>
		<div style="width:90%;margin:0 auto;">
			<div>
				工序单编号：<s:property value="materiel.process.id"/>
			</div>
			<div>
				产品名称：<s:property value="materiel.process.product.name"/>
			</div>
			<div>
				产品编号：<s:property value="materiel.process.product.id"/>
			</div>
			<div>
				设计人：<s:property value="materiel.process.designer"/>
			</div>
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="materielDetail.index" width="50">编号</th>
						<th field="processDetail.name" width="50">工序名称</th>
						<th field="processDetail.description" width="50">描述</th>
						<th field="processDetail.workTime" width="50">工时数</th>
						<th field="processDetail.timeCost" width="50">单位工时成本</th>
						<th field="processDetail.total" width="50">工时成本小计（元）</th>
						<th field="materielDetail.cost" width="50">物料成本小计（元）</th>
					</tr>
				</thead>
			</table>
			<div>
				工时总成本：<s:property value="#timeTotal"/>
			</div>
			<div>
				物料总成本：<s:property value="#costTotal"/>
			</div>
			<div>
				登记人：<s:property value="materiel.process.user.name"/>
			</div>
			<div>
				登记时间：<s:date name="materiel.process.date" format="yyyy-MM-dd HH:mm:ss"/>
			</div>
			<div>
				设计要求：<s:property value="materiel.process.description"/>
			</div>
			<div>
				<a href="materiel/listMateriel" class="easyui-linkbutton" >返回</a>
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改物料单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">物料单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="materielDetail.id" />
					<input type="hidden" name="materielDetail.processDetail.id" />
					<input type="hidden" name="materielDetail.materiel.id" />
					<div class="fitem">
						<label>物料成本小计:</label>
						<input name="materielDetail.cost">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('materiel/saveMaterielDetail',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
