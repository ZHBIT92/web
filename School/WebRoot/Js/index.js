// JavaScript Document

function pass() 
{ 
var user1="test"//鐢ㄦ埛鍚嶏紝鍙互鏇存敼鎺�
var pass1="test"//瀵嗙爜锛屾敼鎺�
var pass=document.myform.password.value 
var user=document.myform.user.value 
if (user == user1&&pass==pass1) 
  {alert("鎴愬姛鐧诲綍...娆㈣繋浣�") 
   document.write("<HTML>") 
   document.write("<body bgcolor='#fef4d9'>") 
   document.write("<center><p><font size='6'color='darkblue'>娆㈣繋杩涘叆!!</p>") 
   document.write("<p><a href='http://www.sina.com.cn'>鏂版氮缃�/a><br>") 
   document.write("</html>")} 
else if(user == ""){
  alert("鐢ㄦ埛鍚嶄负绌�");
}
else if(user != user1)
{ 
alert("鐢ㄦ埛鍚嶉敊璇紝璇烽噸鏂拌緭鍏�");
} 
else if(user == user1&&pass!=pass1)
{ 
alert("瀵嗙爜閿欒锛岃閲嶆柊杈撳叆");
} 

}

function reset(){
  var pass=document.myform.password.value 
    var user=document.myform.user.value 
  pass="";
  user="";
}
