function pass() 
{ 
var pass=document.myform.password.value 
var user=document.myform.user.value 
if(user == ""){
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


        