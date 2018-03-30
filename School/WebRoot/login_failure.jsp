<%@ page language="java" import="java.util.*" contentType="text/html; charset=utf-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";

%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>学生信息管理系统</title>
	<link type="text/css" href="Css/index.css" rel="stylesheet"  />
    <script src='Js/login.js' type="text/javascript"></script>
    <script src='Js/jquery-1.7.2.min.js' type="text/javascript"></script>
    <script src='Js/jquery-validate.js' type="text/javascript"></script>
  </head>
  
  <body>

  <p>登录失败</p>
  </body>
</html>
