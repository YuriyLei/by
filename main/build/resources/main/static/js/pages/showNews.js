/**
 * Created by lei.yu on 2016/4/25.
 */
function MyAutoRun(){
    console.log("faqiqqiu")
    $.ajax({
        type: "get",
        url: "../../notice/getOne/31",
        dataType: "json",
        success: function (result) {
            if (result.status == 1) {
                $("#news").html(result.object.content);
            }else{
                console.log("shibai");
                alert(0);
            }
        }
    })
};
window.onload=MyAutoRun;
