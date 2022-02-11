<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/16
  Time: 19:45
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

    <title>比赛信息</title>
    <link rel="shortcut icon" href="http://114.115.134.119:8080/logo/DAL.png"/>
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
                                <h2>NBA对赛信息
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
                                                <!-- 用ajax? -->
                                                <tr>
                                                    <th>主场球队</th>
                                                    <th>客场球队</th>
                                                    <th>比分</th>
                                                    <th>比赛日期</th>
                                                    <th>比赛场馆</th>
                                                    <th>上座人数</th>
                                                </tr>
                                                </thead>

                                                <tbody id="game_table_content">
                                                <c:forEach var="games"
                                                           items="${sessionScope.gameInfo}">
                                                    <tr id="${games.gameId}">
                                                        <td>${games.home}</td>
                                                        <td>${games.away}</td>
                                                        <td onclick="tdclick(this)">${games.teamPoints}</td>
                                                        <td>${games.date}</td>
                                                        <td>${games.arena}</td>
                                                        <td> ${games.audNum}</td>
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
            <div class="pull-right">
                Gentelella - Bootstrap Admin Template by <a
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
<script src="${pageContext.request.contextPath}/static/JS/game.js"></script>
<%--<script src="${pageContext.request.contextPath}/static/JS/table_click.js"></script>--%>
<script type="text/javascript">
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
        var text = $(ele).text(); // 旧的得分数据
        console.log(text);
        console.log("要修改的比赛ID:" + tr.attr("id"));
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
                    console.log(inputext);
                    updateGameInfo(tr.attr('id'), inputext);
                }
            }
        });
        td.append(input);
        var inputdom = input.get(0);
        inputdom.select();
        td.unbind("click");
    }

    function updateGameInfo(gameId, newScore) {
        console.log(gameId + " " + newScore);
        $.post({
            url: "/Hupu-Admin/game/updateGameScore",
            data: {
                "gameId": gameId,
                "newScore": newScore
            },
            dataType: 'json',
            success: function (data) {
                console.log(data);
            }
        })
    }

    window.onload = function () {
        getGameInfo();
    };

</script>

</body>
</html>
