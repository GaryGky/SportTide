<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>管理员登录</title>

    <!-- Bootstrap -->
    <link href="${pageContext.request.contextPath}/static/vendors/bootstrap/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/static/vendors/font-awesome/css/font-awesome.min.css"
          rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/static/vendors/nprogress/nprogress.css"
          rel="stylesheet">
    <!-- Animate.css -->
    <link href="${pageContext.request.contextPath}/static/vendors/animate.css/animate.min.css"
          rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/static/build/css/custom.min.css"
          rel="stylesheet">

    <script
            src="${pageContext.request.contextPath}/static/JS/login.js"></script>
</head>

<body class="login">
<div>
    <a class="hiddenanchor" id="signup"></a>
    <a class="hiddenanchor" id="signin"></a>

    <div class="login_wrapper">
        <div class="animate form login_form">
            <section class="login_content">
                <div>
                    <h1>Login Form</h1>
                    <div>
                        <input type="text" id="username" class="form-control"
                               placeholder="Username" required=""/>
                    </div>
                    <div>
                        <input type="password" id="userpassword"
                               class="form-control" placeholder="Password"
                               required=""/>
                    </div>
                    <br>
                    <div>
                        <a class="btn btn-default submit"
                           onclick="login()" href="#">Log in</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">New to site?
                            <%--<a href="#">Please contact customer service--%>
                            <%--</a>--%>
                            <a href="#signup" class="to_register"> Create
                                Account </a>
                        </p>

                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1><i class="fa"></i> NBA GAME INFORMATION</h1>
                            <p>©2020 All Rights Reserved. NBA GAME INFORMATION!
                                is a
                                background management system.</p>
                        </div>
                    </div>
                    <!-- 暂时不考虑自助注册-->
                </div>
            </section>
        </div>

        <div id="register" class="animate form registration_form">
            <section class="login_content">
                <form action="##" method="post" id="form">
                    <h1>Create Account</h1>
                    <div>
                        <input type="text" class="form-control"
                               id="user_name" name="user_name"
                               placeholder="Username" required="required"/>
                    </div>
                    <div>
                        <input type="email" class="form-control" id="email"
                               name="email"
                               placeholder="Email" required="required"/>
                    </div>
                    <div>
                        <input type="text" class="form-control" id="nikeName"
                               name="nikeName"
                               placeholder="NikeName" required="required"/>
                    </div>
                    <div>
                        <input type="password" class="form-control" id="pwd1"
                               name="pwd1"
                               placeholder="Password" required="required"/>
                    </div>

                    <div>
                        <input type="password" class="form-control" id="pwd2"
                               placeholder="Confirm Password" name="pwd2"
                               required="required"/>
                    </div>
                    <div>
                        <a class="btn btn-default submit" href="#"
                           onclick="register()">
                            Submit</a>
                    </div>

                    <div class="clearfix"></div>

                    <div class="separator">
                        <p class="change_link">Already a member ?
                            <a href="#signin" class="to_register"> Log in </a>
                        </p>

                        <div class="clearfix"></div>
                        <br/>

                        <div>
                            <h1><i class="fa fa-paw"></i> Gentelella Alela!</h1>
                            <p>Â©2016 All Rights Reserved. Gentelella Alela! is
                                a Bootstrap 3 template. Privacy and Terms</p>
                        </div>
                    </div>
                </form>
            </section>
        </div>
    </div>


</div>
<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/vendors/jquery/dist/jquery.min.js"></script>
<script src="${pageContext.request.contextPath}/static/JS/login.js"></script>
<script type="text/javascript">
    //还是用一个注册吧，感觉login页面有点空。。
    console.log("准备注册新用户 --- js");

    function register() {
        var user_name = $("#user_name").val();
        var email = $("#email").val();
        var nikeName = $("#nikeName").val();
        var pwd1 = $("#pwd1").val();
        var pwd2 = $("#pwd2").val();
        if (pwd1 !== pwd2) {
            alert("两次输入的密码不一致");
            return;
        }

        $.post({
                url: "/Hupu-Admin/login/register-web",
                data: {
                    "name": user_name,
                    "email": email,
                    "password": pwd1,
                    "nikeName": nikeName
                },
                success: function fun(data) {
                    if (data === 2) {
                        alert("用户名重复，请重新输入");
                    } else {
                        alert("注册成功");
                    }
                }
            }
        )
    }
</script>
</body>
</html>
