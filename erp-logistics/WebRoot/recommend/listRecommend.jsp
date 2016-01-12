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
					<s:iterator value="recommendList" var="p">
					{
						"recommend.id":"<s:property value='#p.id' escape='false'/>",
						"recommend.product.id":"<s:property value='#p.product.id' escape='false'/>",
						"recommend.product.name":"<s:property value='#p.product.name' escape='false'/>",
						"recommend.designer":"<s:property value='#p.designer' escape='false'/>",
						"recommend.remark":"<s:property value='#p.remark' escape='false'/>",
						"recommend.user.name":"<s:property value='#p.user.name' escape='false'/>",
						"recommend.date":"<s:date name='#p.date' format='yyyy-MM-dd HH:mm:ss'/>",
						"recommend.show":"<a href='recommend/listRecommendDetail?recommend.id=<s:property value="#p.id"/>'>查看库存单位推荐单</a>",
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
			库存单位推荐列表
		</div>
		<div style="width:90%;margin:0 auto;">
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="recommend.id" width="50">配送单位推荐单编号</th>
						<th field="recommend.product.name" width="50">产品名称</th>
						<th field="recommend.product.id" width="50">产品编号</th>
						<th field="recommend.designer" width="50">推荐人</th>
						<th field="recommend.user.name" width="50">登记人</th> 
						<th field="recommend.date" width="50">登记时间</th>
						<th field="recommend.show" width="50">查看库存单位推荐单</th>
					</tr>
				</thead>
			</table>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建库存单位推荐单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改库存单位推荐单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('recommend/destoryRecommend','recommend.id')">删除库存单位推荐单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">库存单位推荐单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="recommend.id" />
					<div class="fitem">
						<label>产品名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="recommend.product.id" style="width:160px;" id="book" required="true">
							<s:iterator value="productList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem">
						<label>推荐人:</label>
						<input name="recommend.designer"/>
					</div>
					<div class="fitem">
						<label>推荐要求:</label>
						<input name="recommend.remark"/>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('recommend/saveRecommend',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
