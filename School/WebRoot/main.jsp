<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<% 
    String username=(String)session.getAttribute("username");
    if (username==null){
          response.sendRedirect("login.jsp");
      }
	String mainPage=(String)request.getAttribute("mainPage");
	if(mainPage==null || mainPage.equals("")){
		mainPage="common/default.jsp";
	}
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>学生信息管理系统</title>
    <link type="text/css" href="Css/bootstrap.min.css" rel="stylesheet"  />
    <link type="text/css" href="Css/public.css" rel="stylesheet"  />
	<link type="text/css" href="Css/picshow.css" rel="stylesheet"  />
    <script src='Js/jquery.min.js' type="text/javascript"></script>
    <script src='Js/bootstrap.min.js' type="text/javascript"></script>
    <script src='Js/picshow.js' type="text/javascript"></script>
  </head>

<body>

<div id="bg"></div>
<div class="container">
    <jsp:include page="common/head.jsp"></jsp:include>
    <jsp:include page="<%=mainPage %>"></jsp:include>
</div>
</body>
</html>
