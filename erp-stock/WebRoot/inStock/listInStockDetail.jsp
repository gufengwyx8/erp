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
		<s:set var="totalCount" value="0"/>
		<s:set var="totalAlreadyCount" value="0"/>
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="inStockDetailList" var="p" status="i">
					{
						"inStockDetail.id":"<s:property value='#p.id' escape='false'/>",
						"inStockDetail.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"inStockDetail.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"inStockDetail.name":"<s:property value='#p.name' escape='false'/>",
						"inStockDetail.curCount":"<s:property value='#p.curCount' escape='false'/>",
						"inStockDetail.count":"<s:property value='#p.count' escape='false'/>",
						"inStockDetail.qualified":"<s:property value='#p.qualified' escape='false'/>",
						"inStockDetail.alreadyCount":"<s:property value='#p.alreadyCount' escape='false'/>",
						"inStockDetail.index":"<s:property value='#i.index+1' escape='false'/>",
						<s:set var="totalCount" value="#totalCount+#p.count"/>
						<s:set var="totalAlreadyCount" value="#totalAlreadyCount+#p.alreadyCount"/>
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
			生产工序设计单
		</div>
		<div style="width: 90%; margin: 0 auto;">
			<div>
				入库单编号 ：
				<s:property value="inStock.id" />
			</div>
			<div>
				入库理由 ：
				<s:property value="inStock.reason" />
			</div>
			<table id="dg" style="height: 350px;">
				<thead>
					<tr>
						<th field="inStockDetail.index" width="50">
							序号
						</th>
						<th field="inStockDetail.product.id" width="50">
							产品编号
						</th>
						<th field="inStockDetail.product.name" width="50">
							产品名称
						</th>
						<th field="inStockDetail.name" width="50">
							库房名称
						</th>
						<th field="inStockDetail.curCount" width="50">
							当前库存数量
						</th>
						<th field="inStockDetail.qualified" width="50">
							质检合格数量
						</th>
						<th field="inStockDetail.count" width="50">
							应入库件数
						</th>
						<th field="inStockDetail.alreadyCount" width="50">
							已入库件数
						</th>
					</tr>
				</thead>
			</table>
			<div>
				应入库总件数：
				<s:property value="#totalCount" />
			</div>
			<div>
				已入库总件数：
				<s:property value="#totalAlreadyCount" />
			</div>
			<div>
				登记人：
				<s:property value="inStock.user.name" />
			</div>
			<div>
				登记时间：
				<s:date name="inStock.date" format="yyyy-MM-dd HH:mm:ss" />
			</div>

			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-add" plain="true" onclick="newData()">新建安全配置单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-edit" plain="true" onclick="editData()">修改安全配置单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-remove" plain="true"
					onclick="destroyData('inStock/destoryInStockDetail','inStockDetail.id')">删除安全配置单</a>
			</div>
			<div id="dlg" class="easyui-dialog"
				style="width: 400px; height: 280px; padding: 10px 20px"
				closed="true" buttons="#dlg-buttons">
				<div class="ftitle">
					工序单信息
				</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="inStockDetail.id" />
					<div class="fitem">
						<label>
							产品名称:
						</label>
						<select class="easyui-combobox easyui-validatebox"
							name="inStockDetail.product.id" style="width: 160px;" id="book"
							required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name" /></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>
							库房名称:
						</label>
						<input name="inStockDetail.name"/>
					</div>
					<div class="fitem">
						<label>
							当前库存数量:
						</label>
						<input name="inStockDetail.curCount"/>
					</div>
					<div class="fitem">
						<label>
							质检合格数量:
						</label>
						<input name="inStockDetail.qualified"/>
					</div>
					<div class="fitem">
						<label>
							应入库件数:
						</label>
						<input name="inStockDetail.count"/>
					</div>
					<div class="fitem">
						<label>
							已入库件数:
						</label>
						<input name="inStockDetail.alreadyCount"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-ok"
					onclick="saveData('inStock/saveInStockDetail?inStockDetail.inStock.id=<s:property value="inStock.id"/>',saveSuccess)">保存</a>
				<a href="javascript:void(0)" class="easyui-linkbutton"
					iconCls="icon-cancel"
					onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
