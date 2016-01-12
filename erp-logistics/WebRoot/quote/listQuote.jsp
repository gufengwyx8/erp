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
					<s:iterator value="quoteList" var="p">
					{
						"quote.id":"<s:property value='#p.id' escape='false'/>",
						"quote.record.id":"<s:property value='#p.record.id' escape='false'/>",
						"quote.record.name":"<s:property value='#p.record.name' escape='false'/>",
						"quote.record.area":"<s:property value='#p.record.area' escape='false'/>",
						"quote.record.tel":"<s:property value='#p.record.tel' escape='false'/>",
						"quote.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"quote.remark":"<s:property value='#p.remark' escape='false'/>",
						"quote.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"quote.startDate":"<s:date name='#p.startDate' format='yyyy-MM-dd'/>",
						"quote.show":"<a href='quote/listQuoteDetail?quote.id=<s:property value="#p.id"/>'>查看配送报价单</a>",
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
			配送报价单列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="quote.id" width="50">报价单编号</th>
						<th field="quote.record.name" width="50">物流单位名称</th>
						<th field="quote.record.id" width="50">档案编号</th>
						<th field="quote.record.tel" width="50">联系电话</th>
						<th field="quote.startDate" width="50">拟发货时间</th>
						<th field="quote.record.area" width="50">所在区域</th>
						<th field="quote.user.name" width="50">登记人</th> 
						<th field="quote.date" width="50">登记时间</th>
						<th field="quote.show" width="50">查看配送报价单</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建配送报价单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改配送报价单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('quote/destoryQuote','quote.id')">删除配送报价单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">配送报价单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="quote.id" />
					<div class="fitem">
						<label>物流单位名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="quote.record.id" style="width:160px;" id="book" required="true">
							<s:iterator value="recordList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>拟发货时间:</label>
						<input class="easyui-datebox" name="quote.startDate" data-options="formatter:myformatter,parser:myparser"></input>
					</div>
					<div class="fitem">
						<label>备注:</label>
						<input name="quote.remark"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('quote/saveQuote',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
