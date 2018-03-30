<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
String username="";
String password="";
  /*Cookie[] cookies = request.getCookies();
  if(cookies!=null&&cookies.length>0)
  {
     for(Cookie c:cookies)
     {
        if(c.getName().equals("username"))
        {
          username = c.getValue();
        }
        if(c.getName().equals("password"))
        {
          password = c.getValue();
        }
      }
  }*/
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
    function reloadCode(){
	document.getElementById("imagecode").src="<%=path%>/servlet/ImageServlet?"+Math.random();
   }
</script>

</head>
  
<body>
<div id="header">
<div id="gif1"><img src="Images/1.gif" ></div>
</div>

<div id="all">
<div id="jpg">
    <img src="Images/2.jpg" width="588" height="299">
</div>

<div id="login1">
<div class="login" id="login"> 
<form action="<%=path%>/servlet/LoginServlet" method="post"  name="login"  >
  <span style="font-size:26px;">高校信息管理系统</span>
            <dd>
                 <dl>用户名: 
                 <input type="text" name="username" id="username" />                
                 </dl>
                 <dl>密 &nbsp 码: 
                &nbsp<input type="password" name="password" id="pwd" />
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
            <input type="submit" value="登录" > 
            <input type="button" value="重置" onclick="reset()">
</form></div>
</div>

</div>
  </body>
</html>
