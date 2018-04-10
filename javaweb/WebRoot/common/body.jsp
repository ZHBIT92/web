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
    <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/echarts.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-gl/echarts-gl.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts-stat/ecStat.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/dataTool.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/china.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/map/js/world.js"></script>
       <script type="text/javascript" src="http://api.map.baidu.com/api?v=2.0&ak=ZUONbpqGBsYGXNIYHicvbAbM"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/echarts/extension/bmap.min.js"></script>
       <script type="text/javascript" src="http://echarts.baidu.com/gallery/vendors/simplex.js"></script>
		
</head>
<body>	
<div class="layui-body" style="bottom: 0px;">
<div style="padding-left: 15px">
<!-- 内容主体区域 -->
    <div class="layui-tab" lay-allowClose="true" lay-filter="tab-switch">
    	<ul class="layui-tab-title">
           <li class="layui-this" >首页</li>
        </ul>
        <div class="layui-tab-content">
        <div class="layui-tab-item layui-show">
        	<div class="layui-row layui-col-space10">
  				<div class="layui-col-md4">
     				<div id="sex" style="height:300px;width:100%"></div>
  				</div>
  				<div class="layui-col-md4">
    				1/3
  				</div>
  				<div class="layui-col-md4">
    				1/3
  				</div>
			</div>
			<div class="layui-row layui-col-space10">
  				<div class="layui-col-md4">
     				<div id="map" style="height:300px;width:100%"></div>
  				</div>
  				<div class="layui-col-md4">
    				1/3
  				</div>
  				<div class="layui-col-md4">
    				日记
    				<p>2018.4.10 利用百度的echarts工具画图，layui实现响应式布局</p>
  				</div>
			</div>
		</div>
        </div>
    </div>
</div>    
</div>	
<script src="./js/map.js"></script>
<script src="./js/sex.js"></script>
</body>
</html>
