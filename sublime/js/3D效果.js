var index=1;
function next(){
	if (index>=6) {
		alert("到底啦！");
		return;
	}
	var currentPage=document.getElementById('page'+index);
	currentPage.style.webkitTransform='rotateX(-90deg)';
	index++;
	var nextPage=document.getElementById('page'+index);
    nextPage.style.webkitTransform='rotateX(0deg)';
    
}
function pre(){
	if (index<=1) {
		alert("到头呐！");
		return;
		}
	var currentPage=document.getElementById('page'+index);
	currentPage.style.webkitTransform='rotateX(90deg)';
	index--;
	var nextPage=document.getElementById('page'+index);
    nextPage.style.webkitTransform='rotateX(0deg)';
    
}