<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/16
  Time: 19:49
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <!-- Meta, title, CSS, favicons, etc. -->
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>查看帖子信息</title>
    <link rel="shortcut icon" href="http://114.115.134.119:8080/logo/CLE.png"/>
    <!-- Bootstrap -->
    <link href="cdn.datatables.net/1.10.20/css/jquery.dataTables.min.css">
    <link href="${pageContext.request.contextPath}/static/vendors/bootstrap/dist/css/bootstrap.min.css"
          rel="stylesheet">
    <!-- Font Awesome -->
    <link href="${pageContext.request.contextPath}/static/vendors/font-awesome/css/font-awesome.min.css"
          rel="stylesheet">
    <!-- NProgress -->
    <link href="${pageContext.request.contextPath}/static/vendors/nprogress/nprogress.css"
          rel="stylesheet">
    <!-- iCheck -->
    <link href="${pageContext.request.contextPath}/static/vendors/iCheck/skins/flat/green.css"
          rel="stylesheet">
    <!-- Datatables -->

    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-bs/css/dataTables.bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons-bs/css/buttons.bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-fixedheader-bs/css/fixedHeader.bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-responsive-bs/css/responsive.bootstrap.min.css"
          rel="stylesheet">
    <link href="${pageContext.request.contextPath}/static/vendors/datatables.net-scroller-bs/css/scroller.bootstrap.min.css"
          rel="stylesheet">

    <!-- Custom Theme Style -->
    <link href="${pageContext.request.contextPath}/static/build/css/custom.min.css"
          rel="stylesheet">
    <style type="text/css">
        table {
            table-layout: fixed;
        }

        td {
            white-space: nowrap;
            overflow: hidden;
            text-overflow: ellipsis;
        }
    </style>
</head>

<body class="nav-md">
<div class="container body">
    <div class="main_container">

        <jsp:include page="Hupu_top_nav.jsp" flush="true"/>


        <!-- page content -->
        <div class="right_col" role="main">
            <div class="">


                <div class="row">
                    <div class="col-md-12 col-sm-12 ">
                        <div class="">
                            <div class="x_title">
                                <h2>所有新闻信息
                                </h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">
                                <div class="row">
                                    <div class="col-sm-12">
                                        <div class="card-box table-responsive">
                                            <p class="text-muted font-13 m-b-30">
                                            </p>
                                            <table id="datatable"
                                                   class="table table-striped table-bordered"
                                                   style="width:100%">
                                                <thead>
                                                <tr>
                                                    <th>Id</th>
                                                    <th>标题</th>
                                                    <th>管理员Id</th>
                                                    <th>发表时间</th>
                                                    <th>评论量</th>
                                                    <th>内容</th>
                                                    <th>图片路径</th>
                                                    <th>删除</th>
                                                </tr>
                                                </thead>

                                                <tbody id="post-info-table">
                                                <c:forEach var="post"
                                                           items="${sessionScope.postInfo}">
                                                    <tr id="${post.post_id}">
                                                        <td>${post.post_id}</td>
                                                        <td id="post_title"
                                                            onclick="tdclick(this)">${post.post_title}</td>
                                                        <td>${post.admin_id}</td>
                                                        <td>${post.post_time}</td>
                                                        <td>${post.post_commentnum}</td>
                                                        <td id="post_content"
                                                            onclick="tdclick(this)">${post.post_content}</td>\
                                                        <td id="img_url"
                                                            onclick="tdclick(this)">${post.img_url}</td>
                                                        <td>
                                                            <button
                                                                    onclick="delPost(${post.post_id})"
                                                                    class="btn btn-primary"
                                                                    style="display: block;width: 60px;height: 30px;background: #0b2e13">
                                                                删除
                                                            </button>
                                                        </td>
                                                    </tr>
                                                </c:forEach>
                                                </tbody>
                                            </table>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!-- /page content -->

        <!-- footer content -->
        <footer>
            <div class="pull-right"> <a
                    href="https://colorlib.com">Colorlib</a>
            </div>
            <div class="clearfix"></div>
        </footer>
        <!-- /footer content -->
    </div>
</div>

<!-- jQuery -->
<script src="${pageContext.request.contextPath}/static/vendors/jquery/dist/jquery.min.js"></script>
<!-- Bootstrap -->
<script src="${pageContext.request.contextPath}/static/vendors/bootstrap/dist/js/bootstrap.bundle.min.js"></script>
<!-- FastClick -->
<script src="${pageContext.request.contextPath}/static/vendors/fastclick/lib/fastclick.js"></script>
<!-- NProgress -->
<script src="${pageContext.request.contextPath}/static/vendors/nprogress/nprogress.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/static/vendors/iCheck/icheck.min.js"></script>
<!-- Datatables -->
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net/js/jquery.dataTables.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-bs/js/dataTables.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons/js/dataTables.buttons.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons-bs/js/buttons.bootstrap.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons/js/buttons.flash.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons/js/buttons.html5.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-buttons/js/buttons.print.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-fixedheader/js/dataTables.fixedHeader.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-keytable/js/dataTables.keyTable.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-responsive/js/dataTables.responsive.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-responsive-bs/js/responsive.bootstrap.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/datatables.net-scroller/js/dataTables.scroller.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/jszip/dist/jszip.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/pdfmake/build/pdfmake.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/pdfmake/build/vfs_fonts.js"></script>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/static/build/js/custom.min.js"></script>
<script src="${pageContext.request.contextPath}/static/JS/post.js"></script>
<script type="text/javascript">
    window.onload = function () {
        getLimitPost();
    }

    var flag = false

    function tdclick(ele) {
        console.log(flag)
        if (flag) {
            return
        }
        flag = true
        console.log('point1')
        var td = $(ele);
        var tr = td.parent();

        var sampleId = $(ele).val();
        var text = $(ele).text();
        console.log(text)
        td.html("");
        var input = $("<input>");
        input.attr("value", text);
        input.keyup(function (event) {
            console.log('point2')
            var myEvent = event || window.event;
            var kcode = myEvent.keyCode;
            if (kcode === 13) {
                var inputnode = input;
                var inputext = inputnode.val();
                var tdNode = inputnode.parent();
                tdNode.html(inputext);
                tdNode.onclick = tdclick;
                flag = false
                if (inputext !== text) {                    //只有当内容不一样时才进行保存
                    //后台交互的地方
                    sampleNameUpdate($(tr).attr('id'), td.attr('id'), inputext);
                }
            }
        });
        td.append(input);
        var inputdom = input.get(0);
        inputdom.select();
        td.unbind("click");
    }

    function sampleNameUpdate(id, field, content) {
        console.log(id + " " + field + " " + content);
        $.post({
            url: "/Hupu-Admin/post/updatePostInfo",
            data: {
                teamId: id,
                field: field,
                new_value: content
            },
            dataType: 'json',
            success: function (data) {
                alert("修改成功");
            }
        });
    }

    function delPost(id) {
        console.log('del post id:', id);
        $.post({
            url: "/Hupu-Admin/post/delPost",
            data: {"id": id},
            success: function (data) {
                if(data){
                    window.location.reload();
                    alert("删除成功");
                }
                else{
                    alert("删除失败");
                }

            }
        });
    }
</script>

</body>
</html>
