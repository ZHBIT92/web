<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	String username=(String)session.getAttribute("username");
%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>学生信息管理系统主界面</title>
		
	<link rel="stylesheet" type="text/css" href="./layui/css/layui.css">
    <script src="./layui/layui.js"></script>
    <script src="./layui/js/index.js"></script>
    
	</head>
<body>
		
	<div class="layui-header ">
        <div class="layui-logo">
            <i class="layui-icon" style="font-size: 26px; color: #1E9FFF;">&#xe857;</i>
            XX综合管理系统
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left" lay-filter="left-head-left">
            <li class="layui-nav-item">
                <a href="main.jsp">控制台</a>
            </li>
            <li class="layui-nav-item"><a href="">商品管理</a></li>
            <li class="layui-nav-item"><a href="">用户</a></li>
            <li class="layui-nav-item">
                <a href="javascript:;">其它系统</a>
                <dl class="layui-nav-child">
                    <dd><a href="">邮件管理</a></dd>
                    <dd><a href="">消息管理</a></dd>
                    <dd><a href="">授权管理</a></dd>
                </dl>
            </li>
        </ul>
        <ul class="layui-nav layui-layout-right" lay-filter="left-head-right">
            <li class="layui-nav-item">
                <a href="">控制台<span class="layui-badge">9</span></a>
            </li>
            <li class="layui-nav-item">
                <a href="">个人中心<span class="layui-badge-dot"></span></a>
            </li>
            <li class="layui-nav-item">
                <a href="http://www.shuyangyang.com.cn">关于系统</a>
            </li>
            <li class="layui-nav-item">
                <a href="javascript:;">
                    <img src="http://t.cn/RCzsdCq" class="layui-nav-img">
                  	<%=username %>
                </a>
                <dl class="layui-nav-child">
                    <dd id="ui001" name="userinfo.html"><a href="javascript:;" >基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                    <dd><a href="<%=path%>/LoginOut">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>
		
</body>
</html>
