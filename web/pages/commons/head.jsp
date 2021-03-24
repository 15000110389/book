<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2021/1/22
  Time: 9:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--
    base标签一定写在title的正面，并且写到工程路径
-->
<%
    String path = request.getScheme()
            + "://"
            + request.getServerName()
            + ":"
            + request.getServerPort()
            + request.getContextPath()
            + "/";
    pageContext.setAttribute("basePath",path);
%>
<base href="${basePath}">
<script src="static/script/jquery-1.7.2.js" type="text/javascript"></script>
<link type="text/css" rel="stylesheet" href="static/css/style.css" >
