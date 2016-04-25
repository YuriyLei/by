/**
 * Created by lei.yu on 2016/4/25.
 */
$(document).ready(function () {
    $("#addNewsBtn").click(function(){
        addNews();
    })
})

function addNews() {
    var content = window.editor.html();//$("#contentEditor")
    console.log(content);
    var title = $("#title").val();
    var attachmentId = $("#attachmentId").val();
    var contentType = $("#contentType").val();
    console.log(title+attachmentId+contentType);
    var notice =JSON.stringify({
        "title":title,
        "attachmentId":attachmentId,
        "contentType":contentType,
        "content":content
    });//JSON.stringify(notice)
    $.ajax({
        type: "POST",
        url: "../../notice/addNotice",
        contentType:"application/json",
        data:notice ,
        dataType: "json",
        success: function (result) {
            if (result.status == 1) {
                alert(1);
            }else{
                console.log("shibai");
                alert(0);
            }
        }
    })
}