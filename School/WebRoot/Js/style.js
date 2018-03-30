// JavaScript Document

window.onload = function(){

    function box(){

    //获取DIV为‘login’的盒子

    var oBox = document.getElementById('login');

    //获取元素自身的宽度

    var L1 = oBox.offsetWidth;

    //获取元素自身的高度

    var H1 = oBox.offsetHeight;

    //获取实际页面的left值。（页面宽度减去元素自身宽度/2）

    var Left = (document.documentElement.clientWidth-L1)/2;

    //获取实际页面的top值。（页面宽度减去元素自身高度/2）

    var top = (document.documentElement.clientHeight-H1)/2;

    oBox.style.left = Left+'px';

    oBox.style.top = top+'px';

    }

    box();

    //当浏览器页面发生改变时，DIV随着页面的改变居中。

    window.onresize = function(){

        box();

    } 

}