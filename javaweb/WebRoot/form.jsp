<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'form.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>

</head>
  
<body>

<div style="padding-top: 15px; padding-bottom: 15px">
<span class="layui-breadcrumb">
  <a href="">首页</a>
  <a href="">用户管理</a>
  <a><cite>新增用户</cite></a>
</span>
    <hr class="layui-bg-green">
</div>

<form class="layui-form layui-form-pane" action="AddUser">
    <div class="layui-form-item">
        <label class="layui-form-label">登录名</label>
        <div class="layui-input-block">
            <input type="text" name="username" lay-verify="username" placeholder="请输入登录名" autocomplete="off" class="layui-input">
        </div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">密码</label>
        <div class="layui-input-inline">
            <input type="password" name="password" lay-verify="pass" placeholder="请输入密码" autocomplete="off" class="layui-input">
        </div>
        <div class="layui-form-mid layui-word-aux">辅助文字</div>
    </div>
    <div class="layui-form-item">
        <label class="layui-form-label">权限</label>
        <div class="layui-input-block">
            <select name="power" lay-verify="power">
                <option value=""></option>
                <option value="0">高</option>
                <option value="1">中</option>
                <option value="2">低</option>          
            </select>
        </div>
    </div>
    <div class="layui-form-item" pane>
        <label class="layui-form-label">单选框</label>
        <div class="layui-input-block">
            <input type="radio" name="sex" value="男" title="男">
            <input type="radio" name="sex" value="女" title="女" checked>
        </div>
    </div>
    <div class="layui-form-item layui-form-text">
    	<label class="layui-form-label">文本域</label>
    	<div class="layui-input-block">
      	<textarea name="text" placeholder="请输入内容" class="layui-textarea" ></textarea>
    	</div>
  	</div>
    <div class="layui-form-item">
        <div class="layui-input-block">
            <button class="layui-btn" lay-submit lay-filter="add">立即提交</button>
            <button type="reset" class="layui-btn layui-btn-primary">重置</button>
        </div>
    </div>
</form>

<script>
layui.use(['form', 'layedit', 'laydate'], function(){
  var form = layui.form
  ,layer = layui.layer
  ,layedit = layui.layedit
  ,laydate = layui.laydate;
  
  laydate.render({
    elem: '#date1'
  });
  
  //自定义验证规则
  form.verify({
    username: function(value){
      if(value.length < 5){
        return '标题至少得5个字符啊';
      }
    }
    ,pass: [/(.+){6,12}$/, '密码必须6到12位']
    ,power: function(value){
      if(value==null){
        return '权限不能为空';
      }
    }
  });
  
  //监听提交
  form.on('submit(add)', function(data){
    layer.alert(JSON.stringify(data.field), {
      title: '最终的提交信息'
    })
  });
  
});
</script>
    
</body>
</html>
