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
					<s:iterator value="recommendDetailList" var="p" status="i">
					{
						"recommendDetail.id":"<s:property value='#p.id' escape='false'/>",
						"recommendDetail.record.id":"<s:property value='#p.record.id' escape='false'/>",
						"recommendDetail.record.name":"<s:property value='#p.record.name' escape='false'/>",
						"recommendDetail.record.area":"<s:property value='#p.record.area' escape='false'/>",
						"recommendDetail.record.level":"<s:property value='#p.record.level' escape='false'/>",
						"recommendDetail.record.tel":"<s:property value='#p.record.tel' escape='false'/>",
						"recommendDetail.record.contactor":"<s:property value='#p.record.contactor' escape='false'/>",
						"recommendDetail.record.url":"<s:property value='#p.record.url' escape='false'/>",
						"recommendDetail.index":"<s:property value='#i.index+1' escape='false'/>",
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
			配送单位推荐单
		</div>
		<div style="width:90%;margin:0 auto;">
			<div>
				产品名称：<s:property value="recommend.product.name"/>
			</div>
			<div>
				产品编号：<s:property value="recommend.product.id"/>
			</div>
			<div>
				推荐人：<s:property value="recommend.designer"/>
			</div>
			<table id="dg" style="height:350px;"  >
				<thead>
					<tr>
						<th field="recommendDetail.index" width="50">序号</th>
						<th field="recommendDetail.record.id" width="50">档案编号</th>
						<th field="recommendDetail.record.name" width="50">物流单位名称</th>
						<th field="recommendDetail.record.area" width="50">所在区域</th>
						<th field="recommendDetail.record.level" width="50">优质级别</th>
						<th field="recommendDetail.record.tel" width="50">电话</th>
						<th field="recommendDetail.record.contactor" width="50">联系人</th>
						<th field="recommendDetail.record.url" width="50">网址</th>
					</tr>
				</thead>
			</table>
			<div>
				登记人：<s:property value="recommend.user.name"/>
			</div>
			<div>
				登记时间：<s:date name="recommend.date" format="yyyy-MM-dd HH:mm:ss"/>
			</div>
			<div>
				推荐要求：<s:property value="recommend.remark"/>
			</div>
			<div id="toolbar">
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-add" plain="true" onclick="newData()">新建配送单位推荐单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-edit" plain="true" onclick="editData()">修改配送单位推荐单</a>
				<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-remove" plain="true" onclick="destroyData('recommend/destoryRecommendDetail','recommendDetail.id')">删除配送单位推荐单</a>
			</div>
			<div id="dlg" class="easyui-dialog" style="width:400px;height:280px;padding:10px 20px" closed="true" buttons="#dlg-buttons">
				<div class="ftitle">配送单位推荐单信息</div>
				<form id="fm" method="post" novalidate>
					<input type="hidden" name="recommendDetail.id" />
					<div class="fitem">
						<label>物流单位名称:</label>
						<select class="easyui-combobox easyui-validatebox" name="recommendDetail.record.id" style="width:160px;" id="book" required="true">
							<s:iterator value="recordList" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.name"/></option>
							</s:iterator>
						</select>
					</div>
				</form>
			</div>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="saveData('recommend/saveRecommendDetail?recommendDetail.recommend.id=<s:property value="recommend.id"/>',saveSuccess)">保存</a>
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-cancel" onclick="javascript:$('#dlg').dialog('close')">取消</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
