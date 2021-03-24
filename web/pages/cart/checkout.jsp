<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>结算页面</title>

	<%-- 静态包含，base标签，js内容，css内容 --%>
	<%@include file="/pages/commons/head.jsp"%>


	<style type="text/css">
	h1 {
		text-align: center;
		margin-top: 200px;
	}
</style>
</head>
<body>
	
	<div id="header">
			<img class="logo_img" alt="" src="../../static/img/logo.gif" >
			<span class="wel_word">结算</span>

		<%-- 静态包含 登录成功之后的菜单 --%>
		<%@ include file="/pages/commons/login_success_menu.jsp"%>


	</div>
	
	<div id="main">
		
		<h1>你的订单已结算，订单号为:2937474382928484747</h1>
		
	
	</div>


	<%--
		静态包含 footer.jsp
	--%>
	<%@ include file="/pages/commons/footer.jsp"%>

</body>
</html>