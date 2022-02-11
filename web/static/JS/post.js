function getLimitPost() {
    var entry = $("select[name='datatable_length']").val();
    $.get({
        url: "/Hupu-Admin/post/getLimitPost",
        data: {
            "entries": entry
        },
        success: function (data) {
            console.log(data);
            // window.location.reload();
        }
    });
}

//删除帖子
function delPost(id) {
    console.log('del post id:', id);
    $.post({
        url: "/Hupu-Admin/post/delPost",
        data: {"id": id},
        success: function (data) {
            if(data){
                getLimitPost();
                window.location.reload();
                alert("删除成功");
            }
            else{
                alert("删除失败");
            }

        }
    });
}