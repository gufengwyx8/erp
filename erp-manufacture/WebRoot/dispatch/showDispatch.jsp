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
		</script>
	</head>
	<body>
		<jsp:include page="../top.jsp"></jsp:include>
		<div class="mainTitle">
			生产调度信息
		</div>
		<div style="width:90%;margin:0 auto;">
				<s:form id="fm" method="post" action="updateDispatch" namespace="/dispatch" theme="simple" cssStyle="width:500px;">
					<s:hidden name="dispatch.id" />
					<s:hidden name="dispatch.product.id" />
					<div class="fitem">
						<label style="width:140px;">工单指定人:</label>
						<input name="dispatch.designer" value="<s:property value='dispatch.designer'/>" />
					</div>
					<div class="fitem">
						<label style="width:140px;">开工时间:</label>
						<input class="easyui-datebox" name="dispatch.startDate" data-options="formatter:myformatter,parser:myparser"  value="<s:date name='dispatch.startDate' format='yyyy-MM-dd'/>"></input>
					</div>
					<div class="fitem">
						<label style="width:140px;">完工时间:</label>
						<input class="easyui-datebox" name="dispatch.endDate" data-options="formatter:myformatter,parser:myparser"  value="<s:date name='dispatch.endDate' format='yyyy-MM-dd'/>"></input>
					</div>
					<div class="fitem">
						<label style="width:140px;">产品名称:</label>
						<label><s:property value="dispatch.product.name"/></label>
					</div>
					<div class="fitem">
						<label style="width:140px;">产品编号:</label>
						<label><s:property value="dispatch.product.id"/></label>
					</div>
					<div class="fitem">
						<label style="width:140px;">物料组成设计单:</label>
						<select class="easyui-combobox easyui-validatebox" name="dispatch.materiel.id" style="width:160px;" id="book" required="true"  value="<s:property value='dispatch.materiel.id'/>">
							<s:iterator value="materielLsit" var="pl">
								<option value="<s:property value='#pl.id'/>"><s:property value="#pl.id"/></option>
							</s:iterator>
						</select>
					</div>
					<div class="fitem" >
						<label style="width:140px;">描述:</label>
						<input name="dispatch.description"  value="<s:property value='dispatch.description'/>">
					</div>
					<div class="fitem">
						<label style="width:140px;">数量:</label>
						<input name="dispatch.count"  value="<s:property value='dispatch.count'/>">
					</div>
					<div class="fitem">
						<label style="width:140px;">备注:</label>
						<input name="dispatch.remark"  value="<s:property value='dispatch.remark'/>">
					</div>
				</s:form>
			<div id="dlg-buttons">
			<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="$('#fm').submit();" >保存</a>
			</div>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
