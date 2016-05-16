/**
 * Created by lei.yu on 2016/5/10.
 */
$(document).ready(function(){
    var grid = $("#grid-data").bootgrid({
        ajax: true,
        post: function ()
        {
        },
        url: "../role/roleList",
        selection: true,
        multiSelect: true,
        rowSelect: true,
        keepSelection: true,
        formatters: {
            "link": function(column, row)
            {
                return '<a href="#">' + column.id + ": " + row.id + "</a>";
            },
            "commands": function(column, row)
            {
                return "<button type=\"button\" class=\"btn btn-xs btn-default command-edit\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-pencil\"></span></button> " +
                    "<button type=\"button\" class=\"btn btn-xs btn-default command-delete\" data-row-id=\"" + row.id + "\"><span class=\"fa fa-trash-o\"></span></button>";
            }
        }
    }).on("loaded.rs.jquery.bootgrid", function()
    {
        /* Executes after data is loaded and rendered */
        grid.find(".command-edit").on("click", function(e)
        {
            var id = $(this).data("row-id");
            window.location.href = "/user/editRoleHtml/"+id;
        }).end().find(".command-delete").on("click", function(e)
        {
            var id = $(this).data("row-id");
            $.ajax({
                url:"/role/deleteRole/"+id,
                method:"post",
                dataType:"json",
                success:function(result){
                    if(result.status==1){
                        grid.bootgrid("reload");
                    }else{
                        alert("删除失败");
                    }
                },
                error:function(){
                    alert("系统错误");
                }
            })
        });
    }).on("selected.rs.jquery.bootgrid", function(e, rows)
    {
        var rowIds = [];
        for(var i = 0;i<rows.length;i++)
        {
            rowIds.push(rows[i].id);
        }
        alert("Select: " + rowIds.join(","));
    }).on("deselected.rs.jquery.bootgrid", function(e, rows)
    {
        var rowIds = [];
        for (var i = 0; i < rows.length; i++)
        {
            rowIds.push(rows[i].id);
        }
        alert("Deselect: " + rowIds.join(","));
    });
});
