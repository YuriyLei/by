/**
 * Created by lei.yu on 2016/4/25.
 */
// $(document).ready(function(){
//     $("a[data-id]").click(function(){
//         windows.location.href="/notice/readOne/"+$(this).attr("data-id");
//     })
// })

    window.onload=function(){
        var odiv = document.getElementById('gundong');
        var oul = odiv.getElementsByTagName('ul')[0];
        var ali = oul.getElementsByTagName('li');
        var spa = -2;
        oul.innerHTML=oul.innerHTML+oul.innerHTML;
        oul.style.width=ali[0].offsetWidth*ali.length+'px';
        function move(){
            if(oul.offsetLeft<-oul.offsetWidth/2){
                oul.style.left='0';
            }
            if(oul.offsetLeft>0){
                oul.style.left=-oul.offsetWidth/2+'px'
            }
            oul.style.left=oul.offsetLeft+spa+'px';
        }
        var timer = setInterval(move,50)

        ali.onmousemove=function(){
            clearInterval(timer);
        }
        ali.onmouseout=function() {
            timer = setInterval(move, 50);
        }
            //设置移动方向
            // document.getElementsByTagName('a')[0].onclick = function(){
            //     spa=-2;
            // }
            // document.getElementsByTagName('a')[1].onclick = function(){
            //     spa=2;
            // }
    }
