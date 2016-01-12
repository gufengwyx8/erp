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
		<s:set var="totalPrice" value="0" />
		<s:set var="totalCount" value="0" />
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="outInternalDetailList" var="p" status="i">
					{
						"outInternalDetail.id":"<s:property value='#p.id' escape='false'/>",
						"outInternalDetail.index":"<s:property value='#i.index+1' escape='false'/>",
						"outInternalDetail.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"outInternalDetail.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"outInternalDetail.unit":"<s:property value='#p.unit' escape='false'/>",
						"outInternalDetail.count":"<s:property value='#p.count' escape='false'/>",
						"outInternalDetail.price":"<s:property value='#p.price' escape='false'/>",
						"outInternalDetail.totalPrice":"<s:property value='#p.count*#p.price' escape='false'/>",
						"outInternalDetail.index":"<s:property value='#i.index+1' escape='false'/>",
						<s:set var="totalPrice" value="#totalPrice+#p.count*#p.price"/>
						<s:set var="totalCount" value="#totalCount+#p.count"/>
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
			内部调出申请单
		</div>
		<div style="width: 90%; margin: 0 auto;">
			<div>
				调出库：
				<s:property value="outInternal.name" />
			</div>
			<table id="dg" style="height: 350px;">
				<thead>
					<tr>
						<th field="outInternalDetail.index" width="50">
							序号
						</th>
						<th field="outInternalDetail.product.name" width="50">
							产品名称
						</th>
						<th field="outInternalDetail.product.id" width="50">
							产品编号
						</th>
						<th field="outInternalDetail.unit" width="50">
							单位
						</th>
						<th field="outInternalDetail.count" width="50">
							申请调出数量
						</th>
						<th field="outInternalDetail.price" width="50">
							成本单价（元）
						</th>
						<th field="outInternalDetail.totalPrice" width="50">
							小计（元）
						</th>
					</tr>
				</thead>
			</table>
			<div>
				总件数：
				<s:property value="#totalCount" />
			</div>
			<div>
				总金额：
				<s:property value="#totalPrice" />
			</div>
			<div>
				登记人：
				<s:property value="outInternal.user.name" />
			</div>
			<div>
				登记时间：
				<s:date name="outInternal.date" format="yyyy-MM-dd HH:mm:ss" />
			</div>
			<div>
				备注：
				<s:property value="outInternal.remark" />
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="newData()">新建内部调出申请单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editData()">修改内部调出申请单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true"
					onclick="destroyData('outInternal/destoryOutInternalDetail','outInternalDetail.id')">删除内部调出申请单</a>
			</div>
			<div id="dlg" class="easyui-dialog"
				style="width: 400px; height: 280px; padding: 10px 20px"
				closed="true" buttons="#dlg-buttons">
				<div class="ftitle">
					内部调出申请单信息
				</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="outInternalDetail.id" />
					<div class="fitem">
						<label>
							产品名称:
						</label>
						<select class="easyui-combobox easyui-validatebox"
							name="outInternalDetail.product.id" style="width: 160px;"
							id="book" required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name" escape="false" /></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>
							单位
						</label>
						<input name="outInternalDetail.unit">
					</div>
					<div class="fitem">
						<label>
							申请调出数量
						</label>
						<input name="outInternalDetail.count">
					</div>
					<div class="fitem">
						<label>
							成本单价
						</label>
						<input name="outInternalDetail.price">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok"
					onclick="saveData('outInternal/saveOutInternalDetail?outInternalDetail.outInternal.id=<s:property value="outInternal.id"/>',saveSuccess)">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
