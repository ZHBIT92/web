<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
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
		
	<div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="left-menu">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;"><i class="layui-icon" style="margin-right: 5px">&#xe620;</i>系统管理</a>
                    <dl class="layui-nav-child">
                        <dd id="S001" name="form.jsp"><a href="javascript:;">添加用户</a></dd>
                        <dd id="S002" name="user.jsp"><a href="javascript:;">角色管理</a></dd>
                        <dd id="S003" name="page.html"><a href="javascript:;">公告管理</a></dd>
                        <dd id="S004" name="http://www.shuyangyang.com.cn"><a href="javascript:;">作者网站</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item">
                    <a href="javascript:;">资源</a>
                    <dl class="layui-nav-child">
                        <dd id="C001" name="http://www.ttpaihang.com/vote/rank.php?voteid=1089&"><a href="javascript:;">女优排行榜</a></dd>
                        <dd><a href="javascript:;">列表二</a></dd>
                        <dd><a href="">超链接</a></dd>
                    </dl>
                </li>
                <li class="layui-nav-item"><a href="javascript:;">图片管理</a></li>
                <li class="layui-nav-item"><a href="">发布商品</a></li>
            </ul>
        </div>
    </div>
		
</body>
</html>
