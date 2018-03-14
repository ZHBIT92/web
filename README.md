# web
## 纯html版本
## 基于layui前端框架的jsp后台管理系统

### 浏览器后退时自动刷新页面
jsp中
<%   
   response.setHeader("Pragma","no-cache");   
   response.setHeader("Cache-Control","no-cache");   
   response.setDateHeader("Expires", 0);   
   response.setHeader("Cache-Control", "no-store");   
%>

js中设置刷新页面
/*浏览器后退时自动刷新页面*/
	window.onload(){
	if(window.name!="hasLoad"){  
    	location.reload();  
    	window.name = "hasLoad";  
	}else{  
    	window.name="";  
	}  