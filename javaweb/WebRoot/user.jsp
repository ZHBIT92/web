<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
    <base href="<%=basePath%>">
    
    <title>My JSP 'user.jsp' starting page</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="layui/css/layui.css">
    <script src="layui/layui.js"></script>
<script type="text/html" id="barDemo">
  	<a class="layui-btn layui-btn-xs" lay-event="detail">查看</a>
  	<a class="layui-btn layui-btn-xs" lay-event="edit">编辑</a>
  	<a class="layui-btn layui-btn-danger layui-btn-xs" lay-event="del">删除</a>
</script>
</head>
  
<body>
  
<table class="layui-hide" id="test" lay-filter="demo"></table>

<script>
layui.use(['table', 'layer'], function(){
  var table = layui.table;
  var layer = layui.layer;
  
  table.render({
    elem: '#test'
    ,id:'test'
    ,url:'<%=basePath%>UserServlet'
    ,page: true
    ,cols: [[
      {type:'checkbox'}
      ,{field:'userid', width:80, title: 'ID', sort: true}
      ,{field:'username', title: '用户名', sort: true}
      ,{field:'password', title: '密码', sort: true}
      ,{field:'power', width:60, title: '权限'}
      ,{field:'sex', width:80, title: '性别', sort: true}
      ,{field:'text', title: '个性签名', sort: true}
      ,{fixed: 'right', width:150, align:'center', toolbar: '#barDemo'} //这里的toolbar值是模板元素的选择器
    ]]
  });
  
  //监听表格复选框选择
  table.on('checkbox(demo)', function(obj){
    console.log(obj)
  });
  //监听工具条
  table.on('tool(demo)', function(obj){
    var data = obj.data;
    if(obj.event === 'detail'){
      layer.msg('ID：'+ data.userid + ' 的查看操作');
    } 
    if(obj.event === 'del'){
      layer.confirm('<%=basePath%>DelUser?userid='+data.userid, function(index){
        obj.del();
        layer.close(index);
        table.reload('test',{
        	url:'<%=basePath%>DelUser?userid='+data.userid
        })
      });
    } 
    if(obj.event === 'edit'){
      layer.alert('编辑行：<br>'+ JSON.stringify(data))
    }
  });
  
});
</script>

</body>
</html>
