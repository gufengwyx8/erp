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
					<s:iterator value="quoteDetailList" var="p" status="i">
					{
						"quoteDetail.id":"<s:property value='#p.id' escape='false'/>",
						"quoteDetail.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"quoteDetail.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"quoteDetail.description":"<s:property value='#p.description' escape='false'/>",
						"quoteDetail.count":"<s:property value='#p.count' escape='false'/>",
						"quoteDetail.unit":"<s:property value='#p.unit' escape='false'/>",
						"quoteDetail.price":"<s:property value='#p.price' escape='false'/>",
						"quoteDetail.totalPrice":"<s:property value='#p.count*#p.price' escape='false'/>",
						"quoteDetail.discount":"<s:property value='#p.discount' escape='false'/>",
						"quoteDetail.index":"<s:property value='#i.index+1' escape='false'/>",
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
			配送报价单
		</div>
		<div style="width:90%;margin:0 auto;">
		<div>
				物流单位名称：<s:property value="quote.record.name"/>
			</div>
			<div>
				档案编号：<s:property value="quote.record.id"/>
			</div>
			<div>
				电话：<s:property value="quote.record.tel"/>
			</div>
			<div>
				拟发货时间：<s:date name="quote.startDate" format="yyyy-MM-dd"/>
			</div>
			<div>
				所在区域：<s:property value="quote.record.area"/>
			</div>
			<div>
				登记人：<s:property value="quote.user.name"/>
			</div>
			<div>
				登记时间：<s:date name="quote.date" format="yyyy-MM-dd HH:mm:ss"/>
			</div>
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="quoteDetail.index" width="50">序号</th>
						<th field="quoteDetail.product.id" width="50">产品编号</th>
						<th field="quoteDetail.product.name" width="50">产品名称</th>
						<th field="quoteDetail.description" width="50">描述</th>
						<th field="quoteDetail.count" width="50">数量</th>
						<th field="quoteDetail.unit" width="50">单位</th>
						<th field="quoteDetail.price" width="50">运费（元）</th>
						<th field="quoteDetail.totalPrice" width="50">小计（元）</th>
						<th field="quoteDetail.discount" width="50">折扣（%）</th>
					</tr>
				</thead>
			</table>
			<div>
				备注：<s:property value="quote.remark"/>
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建配送报价单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改配送报价单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('quote/destoryQuoteDetail','quoteDetail.id')">删除配送报价单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">配送报价单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="quoteDetail.id" />
					<div class="fitem">
						<label>产品名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="quoteDetail.product.id" style="width:160px;" id="book" required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>描述:</label>
						<input name="quoteDetail.description"/>
					</div>
					<div class="fitem">
						<label>数量:</label>
						<input name="quoteDetail.count"/>
					</div>
					<div class="fitem">
						<label>单位:</label>
						<input name="quoteDetail.unit"/>
					</div>
					<div class="fitem">
						<label>运费:</label>
						<input name="quoteDetail.price"/>
					</div>
					<div class="fitem">
						<label>折扣:</label>
						<input name="quoteDetail.discount"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('quote/saveQuoteDetail?quoteDetail.quote.id=<s:property value="quote.id"/>',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
