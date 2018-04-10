<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username=(String)session.getAttribute("username");
	if (username==null){
          response.sendRedirect("login.jsp");
      }
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>XX综合管理系统</title>

	<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <script src="layui/js/index.js"></script>
<script type="text/javascript">
   /*浏览器后退时自动刷新页面*/
	window.onload = function(){
	if(window.name!="hasLoad"){  
    	location.reload();  
    	window.name = "hasLoad";  
	}else{  
    	window.name="";  
	}  
	}
</script> 
</head>
  
<body>
<div class="layui-layout layui-layout-admin">

	<jsp:include page="common/head.jsp"></jsp:include>
	<jsp:include page="common/left.jsp"></jsp:include>
    <jsp:include page="common/body.jsp"></jsp:include>
    
    
</div>

</body>
</html>
