<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
    
    <div class="layui-body" style="bottom: 0px;">
        <div style="padding-left: 15px">
            <!-- 内容主体区域 -->
            <div class="layui-tab" lay-allowClose="true" lay-filter="tab-switch">
                <ul class="layui-tab-title">
                    <li class="layui-this" >首页</li>
                </ul>
                <div class="layui-tab-content">
                    <div class="layui-tab-item layui-show">
                        	内容1
<h1>分IP统计</h1>

  <table border="1" width="60%">
    <c:forEach items="${applicationScope.map }" var="entry">
        <tr>
            <th>ip</th>
            <th>数量</th>
        </tr>
        <tr>
            <td>${entry.key }</td>
            <td>${entry.value }</td>
            
        </tr>
    </c:forEach>
    </table>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</div>

</body>
</html>
