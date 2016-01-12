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
		<s:set name="costTotal" value="0" />
		<s:set name="materielTotal" value="0" />
		<s:set name="realCostTotal" value="0" />
		<s:set name="realMaterielTotal" value="0" />
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="realCostList" var="m" status="i">
					{
						"realCost.id":"<s:property value='#m.id' escape='false'/>",
						"realCost.materielDetail.id":"<s:property value='#m.materielDetail.id' escape='false'/>",
						"realCost.dispatch.id":"<s:property value='#m.dispatch.id' escape='false'/>",
						"realCost.materielDetail.cost":"<s:property value='#m.materielDetail.cost' escape='false'/>",
						"realCost.processDetail.name":"<s:property value='#m.materielDetail.processDetail.name' escape='false'/>",
						"realCost.processDetail.workTime":"<s:property value='#m.materielDetail.processDetail.workTime' escape='false'/>",
						"realCost.processDetail.timeCost":"<s:property value='#m.materielDetail.processDetail.workTime*#m.materielDetail.processDetail.timeCost' escape='false'/>",
						"realCost.time":"<s:property value='#m.time' escape='false'/>",
						"realCost.timeCost":"<s:property value='#m.timeCost' escape='false'/>",
						"realCost.materielCost":"<s:property value='#m.materielCost' escape='false'/>",
					},
					<s:set name="costTotal" value="#costTotal+#m.materielDetail.processDetail.workTime*#m.materielDetail.processDetail.timeCost"/>
					<s:set name="realCostTotal" value="#realCostTotal+#m.timeCost"/>
					<s:set name="materielTotal" value="#materielTotal+#m.materielDetail.cost"/>
					<s:set name="realMaterielTotal" value="#realMaterielTotal+#m.materielCost"/>
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
		<div style="width: 90%; margin: 0 auto;">
			<div>
				派工单编号：
				<s:property value="dispatch.id" />
			</div>
			<div>
				产品名称：
				<s:property value="dispatch.product.name" />
			</div>
			<div>
				产品编号：
				<s:property value="dispatch.product.id" />
			</div>
			<div>
				数量：
				<s:property value="dispatch.count" />
			</div>
			<table id="dg" style="height: 350px;">
				<thead>
					<tr>
						<th field="realCost.processDetail.name" width="50">
							工序名称
						</th>
						<th field="realCost.processDetail.workTime" width="50">
							设计工时数
						</th>
						<th field="realCost.time" width="50">
							实际工时数
						</th>
						<th field="realCost.processDetail.timeCost" width="50">
							设计工时成本
						</th>
						<th field="realCost.timeCost" width="50">
							实际工时成本
						</th>
						<th field="realCost.materielDetail.cost" width="50">
							设计物料成本
						</th>
						<th field="realCost.materielCost" width="50">
							实际物料成本
						</th>
					</tr>
				</thead>
			</table>
			<div>
				<div style="float:left;width:30%;">
					设计工时总成本：
					<s:property value="#costTotal" />
				</div>
				<div>
					设计物料总成本：
					<s:property value="#materielTotal" />
				</div>
			</div>
			<div>
				<div style="float:left;width:30%;">
					实际工时总成本：
					<s:property value="#realCostTotal" />
				</div>
				<div>
					实际物料总成本：
					<s:property value="#realMaterielTotal" />
				</div>
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editData()">登记</a>
			</div>
			<div id="dlg" class="easyui-dialog"
				style="width: 400px; height: 280px; padding: 10px 20px"
				closed="true" buttons="#dlg-buttons">
				<div class="ftitle">
					物料单信息
				</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="realCost.id" />
					<input type="hidden" name="realCost.dispatch.id" />
					<input type="hidden" name="realCost.materielDetail.id" />
					<div class="fitem">
						<label>
							实际工时数:
						</label>
						<input name="realCost.time">
					</div>
					<div class="fitem">
						<label>
							实际工时成本:
						</label>
						<input name="realCost.timeCost">
					</div>
					<div class="fitem">
						<label>
							实际物料成本:
						</label>
						<input name="realCost.materielCost">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok"
					onclick="saveData('realCost/saveRealCost',saveSuccess)">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
