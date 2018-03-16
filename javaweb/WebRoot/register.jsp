<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username="";
String password="";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>注册</title>
<script type="text/javascript">
    function reloadCode(){
	document.getElementById("imagecode").src="<%=path%>/servlet/ImageServlet?"+Math.random();
   }
</script>

</head>
  
<body>



<div id="all">
<div id="head">
<jsp:include page="common/head.jsp"></jsp:include>
</div>
<div id="login1">
<div class="login" id="login"> 
<form action="<%=path%>/servlet/RegServlet" method="post"  name="login"  >
  <span style="font-size:26px;">高校信息管理系统</span>
            <dd>
                 <dl>用户名: 
                 <input type="text" name="username" id="username" />                
                 </dl>
                 <dl>密 &nbsp 码: 
                &nbsp<input type="password" name="password" id="pwd" />
                 </dl>    
                 <dl>密 &nbsp 码1: 
                &nbsp<input type="password" name="password1" id="pwd1" />
                 </dl> 
                <dl>验证码 : 
                <input type="text" name="imageValue"/><br><br>
                <img alt="验证码" id="imagecode" src="<%=path%>/servlet/ImageServlet"/>
                <a href="javascript:reloadCode()">看不清楚</a>              
                </dl>  
                
                 <!--            
                <dl><input type="checkbox" name="isUseCookie"
                     checked="checked" />10天内自动登录
                </dl>
                 -->
            </dd>
            <input type="submit" value="注册" > 
            <input type="button" value="重置" onclick="reset()">
</form></div>
</div>

</div>
  </body>
</html>
