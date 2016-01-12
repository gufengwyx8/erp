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
		<script type="text/javascript" src="plugin/ckeditor/ckeditor.js"></script>
		<script type="text/javascript">
			function getData(){
				var rows=[
					<s:iterator value="contactDetailList" var="p" status="i">
					{
						"contactDetail.id":"<s:property value='#p.id' escape='false'/>",
						"contactDetail.index":"<s:property value='#i.index+1' escape='false'/>",
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
			联络登记单
		</div>
		<div style="width: 90%; margin: 0 auto;">
			<div>
				物流单位名称：
				<s:property value="contact.record.name" />
			</div>
			<div>
				被联络人：
				<s:property value="contact.record.contactor" />
			</div>
			<div>
				联络理由：
				<s:property value="contact.reason" />
			</div>
			<div>
				电话：
				<s:property value="contact.record.tel" />
			</div>
			<div>
				<form id="content" action="contact/updateContactContent" method="post">
					<s:hidden name="contact.id" />
					<textarea id="txt1" name="contact.content">
						<s:property value="contact.content" escape="false" />
					</textarea>
				</form>
			</div>
			<script type="text/javascript">
					CKEDITOR.replace('txt1');
				</script>
			<div>
				联络人：
				<s:property value="contact.user.name" />
			</div>
			<div>
				联络时间：
				<s:date name="contact.date" format="yyyy-MM-dd HH:mm:ss" />
			</div>
			<a href="javascript:void(0)" class="easyui-linkbutton"
				iconCls="icon-ok" onclick="$('#content').submit();">保存</a>
		</div>
		</div>

		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
