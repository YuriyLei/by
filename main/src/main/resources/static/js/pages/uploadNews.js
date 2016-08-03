/**
 * Created by 余磊 on 2016/6/2.
 */
$(function () {
    $("#firstType").change(function(){
        var parentId = $("#firstType").val();
        $("#secondType option:gt(0)").remove();
        $.ajax({
            url:"/view/getViewByParentId",
            type:"post",
            data:{
                parentId:parentId
            },
            dataType:"json",
            success:function(result) {
                console.log(result);
                $.each(result, function (i, item) {
                    $("#secondType").append('<option value= "' + item.id + '">' + item.viewName + "</option>");
                })
            }
        })
    });
    $("#secondType").change(function(){
       var type = $("#secondType").val();
        // $("#newsType").val(type);
        $(".fileinput-upload-button").attr("href","/news/uploadNews/"+type);
        $('#file').fileinput('refresh', {uploadUrl: '/news/uploadNews/'+type});
    })
})
