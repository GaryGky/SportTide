//登录验证
function login() {
    console.log("into login");
    $.post({
        url: "/Hupu-Admin/login/adminLogin", //登录验证url
        data: {
            "name": $("#username").val(),
            "password": $("#userpassword").val()
        },
        success: function (flag, status, xhr) {
            if (flag === 1) {
                alert("登录成功");
                window.location.href = "/Hupu-Admin/jump/toHome"; // 跳到首页
            } else if (flag === 0) {
                alert("请输入正确的用户名和密码");
            } else if (flag === -1) {
                alert("用户名密码不能为空");
            }
        }
    });
}

//登出 登出的话需要传送什么参数, user_id?
function logout() {
    $.post({
        url: "/Hupu-Admin/login/logout",
        data: {},
        success: function (response) {
            console.log('response');
            window.location.href = "index.jsp";
        }
    });
}
