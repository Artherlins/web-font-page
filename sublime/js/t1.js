// window.onload=function(){
// 	var ul1=document.getElementByName("ul1");
// 	var lis=ul1.getElementsByTagName("li");
// 	var div=document.getElementByName("container");
// 	var divs=div.getElementsByTagName("div");
// for (var i = 0; i < lis.length; i++) {
// 	lis[i].onmouseover=function(){
// 		lis[i].className="now";
// 		//divs[i].className="first";
// 		divs[i].style.display=block;
// 	}
	

// }
// }
window.onload = function() {
        var oUl1 = document.getElementById("ul1");
        var aLi = oUl1.getElementsByTagName("li");
        var oDiv = document.getElementById("container");
        var aDiv = oDiv.getElementsByTagName("div");
        alert("sdf");
        for(var i = 0; i < aLi.length; i++) {
            aLi[i].index = i;
            aLi[i].onmouseover = function() {
                for(var i = 0; i < aLi.length; i++) {
                    aLi[i].className = "";
                }
                aLi[this.index].className = "now";
                // aLi[this.index].className = "now";
                for(var j = 0; j < aDiv.length; j++) {
                    aDiv[j].className = "hide";
                }
                aDiv[this.index].className = "show";
                 // this.className = "show";
            }        
        }
    }
 