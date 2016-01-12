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
	</head>
	<body>
		<jsp:include page="../top.jsp"></jsp:include>
		<div class="mainTitle">
			宣传详细信息
		</div>
		<div style="width:90%;margin:0 auto;">
			<form id="f" action="ad/submitContent" method="post" enctype="multipart/form-data">
				<s:hidden name="ad.id"/>
				<div>
					宣传主题：<s:property value="ad.title"/>
				</div>
				<br/>
				<div>
					宣传类型：<s:property value="ad.type"/>
				</div>
				<br/>
				<div>
					机构：<s:property value="ad.organ"/>
				</div>
				<br/>
				<div>
					<textarea id="txt1" name="content" ><s:property value="ad.content" escape="false"/></textarea>
					<script type="text/javascript">
						CKEDITOR.replace('txt1');
					</script>
				</div>
				<br/>
				<div>
					<s:if test="ad.fileName == null">
						<input type="file" name="file"/>
					</s:if>
					<s:else>
						<s:property value="ad.fileName"/>
						<br/>
						<a href="ad/download?ad.id=<s:property value='ad.id'/>" class="easyui-linkbutton" iconCls="icon-ok" >下载</a>
					</s:else>
				</div>
				<br/>
				<div>
					备注：<s:property value="ad.remark"/>
				</div>
				<br/>
				<div>
					登记人：<s:property value="ad.user.name"/>
				</div>
				<br/>
				<div>
					登记时间：<s:date name="ad.date" format="yyyy-MM-dd HH:mm:ss"/>
				</div>
				<br/>
				<div>
					<a href="javascript:void(0)" class="easyui-linkbutton" iconCls="icon-ok" onclick="$('#f').submit();">修改</a>
				</div>
			</form>
		</div>
		<jsp:include page="../footer.jsp"></jsp:include>
	</body>
</html>
