/**
 * Created by lei.yu on 2016/5/10.
 */
$(document).ready(function(){
    $("#grid-data").bootgrid({
        ajax: true,
        post: function ()
        {
            /* To accumulate custom parameter with the request object */
            return {
                current: 1,
                rowCount:10
            };
        },
        url: "../user/userList",
        selection: true,
        multiSelect: true,
        rowSelect: true,
        keepSelection: true,
        formatters: {
            "link": function(column, row)
            {
                return '<a href="#">' + column.id + ": " + row.id + "</a>";
            }
        }
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
