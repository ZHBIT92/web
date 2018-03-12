<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>

  </head>
  
  <body>
  
<table class="layui-table" lay-data="{height: 'full-200', cellMinWidth: 80, page: true, limit:30, url:'demo/table/user/'}">
  <thead>
    <tr>
      <th lay-data="{type:'checkbox'}">ID</th>
      <th lay-data="{field:'id', width:100, sort: true}">ID</th>
      <th lay-data="{field:'username', width:100}">用户名</th>
      <th lay-data="{field:'sex', width:100, sort: true}">性别</th>
      <th lay-data="{field:'sign', minWidth: 150}">签名</th>
      <th lay-data="{field:'experience', sort: true, align: 'right'}">积分</th>
      <th lay-data="{field:'score', sort: true, minWidth: 100, align: 'right'}">评分</th>
    </tr>
  </thead>
</table> 

<script>
layui.use('table', function(){
  var table = layui.table;
});
</script>
  </body>
</html>
