//添加Admin的信息
function addAdmin() {
    console.log("进入添加函数");
    var pwd1 = $("#admin_pwd1").val();
    var pwd2 = $("#admin_pwd2").val();
    if (pwd1 !== pwd2) {
        alert("两次输入的密码不一致");
    } else {
        $.post({
            url: "/Hupu-Admin/user/addAdmin",
            data: {
                "name": $("#admin_name").val(),
                "pwd1": pwd1,
                "pwd2": pwd2
            },
            success: function (msg) {
                console.log(msg);
                if (msg === 1) {
                    // 注册成功
                    alert("注册成功");

                }
            }
        });
    }

}

//获取user信息
function getMyUser() {
    console.log("调用getUser");
    // var entry = $("select[name='datatable_length']").val();
    $.get({
        url: "/Hupu-Admin/user/getLimitUser",
        data: {},
        success: function (data) {
            console.log(data);
            // window.location.reload();
        }
    })
}

//删除user
function delUser(id) {
    $.post({
        url: "/Hupu-Admin/user/delUser",
        data: {"id": id},
        success: function (data) {
            console.log(data);
            window.location.reload();
        }
    });
}

