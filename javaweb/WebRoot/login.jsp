<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username="";
String password="";
String username1=(String)session.getAttribute("username");
    if (username1!=null){
          response.sendRedirect("main.jsp");
      }
%>
<%   
   response.setHeader("Pragma","no-cache");   
   response.setHeader("Cache-Control","no-cache");   
   response.setDateHeader("Expires", 0);   
   response.setHeader("Cache-Control", "no-store");   
%>  
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    <title>登录</title>
	<link type="text/css" href="Css/index.css" rel="stylesheet"  />
    <script src='Js/login.js' type="text/javascript"></script>
    <script src='Js/jquery.min.js' type="text/javascript"></script>
    <script src='Js/jquery-validate.js' type="text/javascript"></script>
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
	 function reloadCode(){
	document.getElementById("imagecode").src="<%=path%>/Image?"+Math.random();
   }
</script> 

</head>
  
<body>
<div id="login1">
<div class="login" id="login"> 
<form action="<%=path%>/Login" method="post"  name="login"  >
  <span style="font-size:26px;">XX综合管理系统</span>
            <dd>
                 <dl>用户名: 
                 <input type="text" name="username" id="username" />                
                 </dl>
                 <dl>密 &nbsp 码: 
                &nbsp<input type="password" name="password" id="pwd" />
                 </dl>     
                <dl>验证码 : 
                <input type="text" name="imageValue"/><br><br>
                <img alt="验证码" id="imagecode" src="<%=path%>/Image"/>
                <a href="javascript:reloadCode()">看不清楚</a>              
                </dl>                        
            </dd>
            <input type="submit" value="登录" > 
            <input type="button" value="重置" onclick="reset()">
			<input type="hidden" id="refreshed" value="no"> 
</form></div>
</div>
</body>
</html>
