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
<%
	int n=0;
	String counter =(String)application.getAttribute("counter");
	if(counter!=null)
	n = Integer.parseInt(counter);
	n = n+1;
	out.print("你是第"+n+"位访问者");
	counter = String.valueOf(n);
	application.setAttribute("counter",counter);
 %>
                    </div>
                </div>
            </div>
        </div>
    </div>
    
</div>

</body>
</html>
