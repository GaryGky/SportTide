//添加赛事
function addGame() {
    $.post({
        url: "", //添加比赛的url
        data: {
            //一些数据，待确定。
        },
        success: function (flag) {
            console.log("添加成功");
            if (flag) {
                //添加成功的提示。
            }
        }
    });
}

//删除比赛
function delGame() {
    $.post({
        url: "", //删除比赛
        data: {
            //game id? 还是 game name
        },
        success: function (flag) {
            console.log('比赛删除成功');
            if (flag) {
                //删除成功提示
            }
        }
    });
}

//获取比赛信息
function getGameInfo() {
    var entry = $("select[name='datatable_length']").val();
    // alert(entry);
    $.get({
        url: "/Hupu-Admin/game/getGameByLimit",
        data: {
            "entries": entry, // 每页展示的数据量，相当于数据库索引时的limit
        },
        success: function (data) {
            console.log(data);
            // window.location.reload();
        }
    });
}

