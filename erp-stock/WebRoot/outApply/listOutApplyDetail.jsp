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
		<s:set var="totalPrice" value="0"/>
		<s:set var="totalCount" value="0"/>
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="outApplyDetailList" var="p" status="i">
					{
						"outApplyDetail.id":"<s:property value='#p.id' escape='false'/>",
						"outApplyDetail.index":"<s:property value='#i.index+1' escape='false'/>",
						"outApplyDetail.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"outApplyDetail.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"outApplyDetail.count":"<s:property value='#p.count' escape='false'/>",
						"outApplyDetail.unit":"<s:property value='#p.unit' escape='false'/>",
						"outApplyDetail.price":"<s:property value='#p.price' escape='false'/>",
						"outApplyDetail.totalPrice":"<s:property value='#p.count*#p.price' escape='false'/>",
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
			出库申请单
		</div>
		<div style="width: 90%; margin: 0 auto;">
			<div>
				出库人：
				<s:property value="outApply.designer" />
			</div>
			<div>
				出库理由：
				<s:property value="outApply.reason" />
			</div>
			<div>
				是否归还：
				<s:if test="outApply.back">
					是
				</s:if>
				<s:else>
					否
				</s:else>
			</div>
			<div>
				归还时间：
				<s:date name="outApply.backDate" format="yyyy-MM-dd" />
			</div>
			<table id="dg" style="height: 350px;">
				<thead>
					<tr>
						<th field="outApplyDetail.index" width="50">
							序号
						</th>
						<th field="outApplyDetail.product.name" width="50">
							产品名称
						</th>
						<th field="outApplyDetail.product.id" width="50">
							产品编号
						</th>
						<th field="outApplyDetail.count" width="50">
							数量
						</th>
						<th field="outApplyDetail.unit" width="50">
							单位
						</th>
						<th field="outApplyDetail.price" width="50">
							成本单价（元）
						</th>
						<th field="outApplyDetail.totalPrice" width="50">
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
				<s:property value="outApply.user.name" />
			</div>
			<div>
				登记时间：
				<s:date name="outApply.date" format="yyyy-MM-dd HH:mm:ss" />
			</div>
			<div>
				备注：
				<s:property value="outApply.remark" />
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="newData()">新建出库申请单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editData()">修改出库申请单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true"
					onclick="destroyData('outApply/destoryOutApplyDetail','outApplyDetail.id')">删除出库申请单</a>
			</div>
			<div id="dlg" class="easyui-dialog"
				style="width: 400px; height: 280px; padding: 10px 20px"
				closed="true" buttons="#dlg-buttons">
				<div class="ftitle">
					出库申请单信息
				</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="outApplyDetail.id" />
					<div class="fitem">
						<label>产品名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="outApplyDetail.product.id" style="width:160px;" id="book" required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>数量</label>
						<input name="outApplyDetail.count">
					</div>
					<div class="fitem">
						<label>单位</label>
						<input name="outApplyDetail.unit">
					</div>
					<div class="fitem">
						<label>成本单价</label>
						<input name="outApplyDetail.price">
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok"
					onclick="saveData('outApply/saveOutApplyDetail?outApplyDetail.outApply.id=<s:property value="outApply.id"/>',saveSuccess)">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
