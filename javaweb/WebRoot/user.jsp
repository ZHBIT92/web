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
  
<table class="layui-hide" id="test"></table>

<script>
layui.use('table', function(){
  var table = layui.table;
  
  table.render({
    elem: '#test'
    ,url:'http://localhost:8080/web/UserServlet'
    ,page: true
    ,cellMinWidth: 80 //全局定义常规单元格的最小宽度，layui 2.2.1 新增
    ,cols: [[
      {field:'userid', width:80, title: 'ID', sort: true}
      ,{field:'username', width:80, title: '用户名', sort: true}
      ,{field:'password', width:137, title: '密码'}
      ,{field:'power', width:80, title: '权限'}
      ,{field:'sex', width:137, title: '性别', sort: true}
      ,{field:'text', title: '个性签名', sort: true}
    ]]
  });
  
});
</script>
  </body>
</html>
