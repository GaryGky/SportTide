//获取比赛信息
function getTeamInfo() {
    var entry = $("select[name='datatable_length']").val();
    console.log('ready to get team info')
    // alert(entry);
    $.get({
        url: "/Hupu-Admin/team/getTeamByLimit",
        data: {
            //"entries": entry, // 每页展示的数据量，相当于数据库索引时的limit
        },
        success: function (data) {
            console.log(data);
            // window.location.reload();
        }
    });
}
