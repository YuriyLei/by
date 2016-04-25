/**
 * Created by lei.yu on 2016/4/25.
 */
$(document).ready(function(){
    $("a[data-id]").click(function(){
        windows.location.href="/notice/readOne/"+$(this).attr("data-id");
    })
})
