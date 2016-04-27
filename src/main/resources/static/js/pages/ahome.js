/**
 * Created by lei.yu on 2016/4/25.
 */

$(function () {
    //var attachmentId = "";
    var tm=Random(16);
    $('#file').fileinput({
        uploadUrl: '../../attachment/uploadAttachment', //上传的地址
        allowedFileExtensions: ['jpg', 'gif', 'png','doc','docx','pdf','xls','xlsx'],//接收的文件后缀
        showUpload: true, //是否显示上传按钮
        showCaption: false,//是否显示标题
        browseClass: "btn btn-primary", //按钮样式
        uploadExtraData:{"shortId": tm},//额外数据
        //dropZoneEnabled: true,//是否显示拖拽区域
        //minImageWidth: 50, //图片的最小宽度
        //minImageHeight: 50,//图片的最小高度
        //maxImageWidth: 1000,//图片的最大宽度
        //maxImageHeight: 1000,//图片的最大高度
        //maxFileSize: 0,//单位为kb，如果为0表示不限制文件大小
        //minFileCount: 0,
        //uploadAsync: false,//ajax同步设置为false，异步设置为true
        maxFileCount: 8, //表示允许同时上传的最大文件个数
        enctype: 'multipart/form-data',
        validateInitialCount:true
        //previewFileIcon: "<i class='glyphicon glyphicon-king'></i>",
        //msgFilesTooMany: "选择上传的文件数量({n}) 超过允许的最大数值{m}！",
    });
    //导入文件上传完成之后的事件
    $("#file").on("fileuploaded", function (event, data, previewId, index) {
        var result = data.response;
        console.log(result.object);
        if (result.status == 1) {
            $("#shortId").val(tm);
        }
    });
    $("#addNewsBtn").click(function(){
        addNews();
    });
    // $("#newsType").click(function(){
    //     var nowBtn = $(this).
    // });
})

function addNews() {
    var label = $("#newsType").find(".active");
    var type= label.find("input").attr("id")
    var entype="" ;
    var enDaType = "";
    if(type=="important"){
        entype = "important";
        enDaType = "Important"
    }else if(type=="activity"){
        entype = "activity";
        enDaType = "Activity"
    }else if(type=="notice"){
        entype = "notice";
        enDaType = "Notice"
    }else{
        console.log("show");
        $("#notTypeWarning").show();
        //document.getElementById("#newsType").scrollIntoView();
        document.getElementById("aWarning").click();
        //$("#aWarning").click();//这个只能出发点击，不能跳转
        setInterval(function(){
            $("notTypeWarning").css("display","none");
        },3000);

        return;
    }

    var url = "../../"+entype+"/add"+enDaType;
    var content = window.editor.html();//$("#contentEditor")
    var title = $("#title").val();
    var shortId = $("#shortId").val();
    if(shortId){
        url = "../../"+entype+"/add"+enDaType+"WithAttachment/"+shortId;
    }
    var contentType = $("#contentType").val();
    var notice =JSON.stringify({
        "title":title,
       // "shortId":shortId,
        "contentType":contentType,
        "content":content
    });//JSON.stringify(notice)
    $.ajax({
        type: "POST",
        url: url,
        contentType:"application/json",
        data:notice ,
        dataType: "json",
        success: function (result) {
            if (result.status == 1) {
                console.log("1");
                //location.reload();
            }else{
                alert("添加失败");
            }
        }
    });
}
function Random(n){
    var rnd="";
    for(var i=0;i<n;i++)
        rnd+=Math.floor(Math.random()*10);
    return rnd;
}