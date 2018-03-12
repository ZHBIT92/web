<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>XX综合管理系统</title>

	<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
    <script src="layui/js/index.js"></script>
</head>
  
<body>
    <div class="layui-layout layui-layout-admin">
    <div class="layui-header ">
        <div class="layui-logo">
            <i class="layui-icon" style="font-size: 26px; color: #1E9FFF;">&#xe857;</i>
            XX综合管理系统
        </div>
        <!-- 头部区域（可配合layui已有的水平导航） -->
        <ul class="layui-nav layui-layout-left" lay-filter="left-head-left">
            <li class="layui-nav-item">
                <a href="">控制台</a>
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
                    束洋洋
                </a>
                <dl class="layui-nav-child">
                    <dd id="ui001" name="userinfo.html"><a href="javascript:;" >基本资料</a></dd>
                    <dd><a href="">安全设置</a></dd>
                    <dd><a href="">退出</a></dd>
                </dl>
            </li>
        </ul>
    </div>

    <div class="layui-side layui-bg-black">
        <div class="layui-side-scroll">
            <!-- 左侧导航区域（可配合layui已有的垂直导航） -->
            <ul class="layui-nav layui-nav-tree"  lay-filter="left-menu">
                <li class="layui-nav-item layui-nav-itemed">
                    <a class="" href="javascript:;"><i class="layui-icon" style="margin-right: 5px">&#xe620;</i>系统管理</a>
                    <dl class="layui-nav-child">
                        <dd id="S001" name="form.html"><a href="javascript:;">用户管理</a></dd>
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
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>
