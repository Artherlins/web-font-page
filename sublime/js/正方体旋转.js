function rotate(){
            var x = document.getElementById("x2").value;
            var y = document.getElementById("y2").value;
            var z = document.getElementById("z2").value;
            document.getElementById('main').style.webkitTransform = "rotateX("+x+"deg) rotateY("+y+"deg) rotateZ("+z+"deg)";

            document.getElementById('x1').innerText = x;
            document.getElementById('y1').innerText = y;
            document.getElementById('z1').innerText = z;
        }
