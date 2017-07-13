/*
JS:
	JavaScript
	网景(netspace) C-- -->LiveScript  -->ECMAScript --> JavaScript
	脚本语言(无法独立运行，需要嵌入到html中作为脚本运行)  (nodejs可以直接运行js)
	js是一门弱类型语言:任何数据类型在使用的时候无需声明数据类型,还能在运行期间动态改变数据类型，所以
		js是一门动态语言
	
	JS包含三大核心组成部分
		ECMAScript:js基本语法
		BOM:浏览器对象模型
		DOM:文档对象模型
 */
//获取视频播放区域(弹幕出现的区域)
var sc = $('.main');
//获取输入框对象
var txt = $('.txt');
//获取按钮对象
var btn = $('.btn');
var textSize=20;//
//封装函数用于查询指定元素对象
function $(selector)
{
	return document.querySelector(selector);
}
//为按钮设置点击事件
btn.onclick=sendMsg;
//监听按键事件
txt.addEventListener('keydown',function(e){
	//获取按钮的按键码(键盘上的每一个按键，都对应一个独一无二的数字:ascii码)
	var code = e.keyCode;
	//判断是否按下回车(发送)
	if(code == 13){
		sendMsg();
	}
});
//发送弹幕
function sendMsg(){
	//获取输入框中输入的内容
	var content = txt.value;
	//随机获取一个y轴位置
	var height = parseInt(Math.random()*sc.offsetHeight);
	//创建span元素
	var sp = document.createElement('span');
	sp.style.color=randomColor();
	sp.style.position = 'absolute';//设置定位方式为绝对定位
	sp.style.left = sc.offsetWidth+'px';//设置文本初始位置在视频区域的最右边
//	alert(sc.offsetWidth);
	sp.style.top = height -sp.style.height+ 'px';	//设置span在距离父容器的高度
	sp.style.fontSize=textSize+'px';//设置字体大小
	sp.style.width=textSize*content.length+'px';//span区域的宽度
	sp.innerHTML = content;	//设置span中要显示的文本内容(弹幕内容)
	
	sc.appendChild(sp);//将产生的弹幕内容追加到屏幕中
//	alert(randomColor());
	startmove(sp);
}
//随机生成颜色
function randomColor(){
	var r=Math.floor(Math.random()*256);//floor向下取整
	var g=Math.floor(Math.random()*256);
	var b=Math.floor(Math.random()*256);
	
	return 'rgb('+r+','+g+','+b+')';
}
//设置文本开始移动
function startmove(sp){
	//获取文本所在的位置（水平）
	var left=parseInt(sp.style.left);
	left--;
	var w=parseInt(sp.style.width);//获取span区域的宽度
	//优化操作，如果文本移动到屏幕左边则销毁
	if (left<=-w) {
		sc.removeChild(sp);
	}else{
	sp.style.left=left+'px';
	setTimeout(function(){
		startmove(sp)
	},10);
	}
	//修改span元素与屏幕左边的距离
}

//setTimeout(startmove(sp),10);


//alert(sp.style.height);









/*
 1.设置内容显示不同颜色(随机显示颜色:#+6位16进制颜色编码 0123456789abcdef)
 2.内容应该要从屏幕右边滚动到屏幕的左边(动画效果:setInterval/setTimeout)
*/