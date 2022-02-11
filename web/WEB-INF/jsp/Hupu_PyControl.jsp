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

    <title>球队博物馆</title>

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
    <link rel="shortcut icon" href="http://114.115.134.119:8080/logo/ATL.png"/>
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
                <div class="page-title">
                    <div class="title_left">
                        <h3> 球队博物馆 </h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5   form-group pull-right top_search">
                            <div class="input-group">
                                <input id="crawlGamesDates" type="text"
                                       class="form-control"
                                       placeholder="比赛日期">
                                <span class="input-group-btn">
                        <button class="btn btn-default"
                                type="button"
                                onclick="crawlGames()">爬取比赛信息</button>
                    </span>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="clearfix"></div>

                <div class="row">
                    <div class="col-md-12">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Author-By：球迷部落
                                </h2>
                                <div class="clearfix"></div>
                            </div>
                            <div class="x_content">

                                <div class="row">
                                    <c:forEach var="teams"
                                               items="${sessionScope.teamInfo}">
                                        <div class="col-md-55">
                                            <div class="thumbnail">
                                                <div class="image view view-first">
                                                    <img style="width: 100%; display: block;"
                                                         src="http://114.115.134.119/bg/${teams.id}.jpg"
                                                         alt="image">
                                                    <div class="mask">
                                                        <p>${teams.teamName}</p>
                                                        <div class="tools tools-bottom">

                                                            <a target="_blank"
                                                               href="${teams.website}"><i
                                                                    class="fa fa-link"></i></a>
                                                            <a href="#"><i
                                                                    class="fa fa-pencil"></i></a>
                                                            <a href="#"><i
                                                                    class="fa fa-times"></i></a>

                                                        </div>
                                                    </div>
                                                </div>
                                                <div class="caption">
                                                    <p>建立时间:
                                                        <strong>${teams.buildtime}</strong>
                                                    </p>
                                                    <p>主场：${teams.homecourt}</p>
                                                    <p>战绩：${teams.winGame}/
                                                            ${teams.allGame}</p>
                                                </div>
                                            </div>
                                        </div>
                                    </c:forEach>

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

<script src="${pageContext.request.contextPath}/static/JS/team.js"></script>
<%--<script src="${pageContext.request.contextPath}/static/JS/table_click.js"></script>--%>
<script type="text/javascript">
    window.onload = function () {
        getTeamInfo();
    };

    function crawlGames() {
        input_dates = $("#crawlGamesDates").val();
        $.post({
            url: "/Hupu-Admin/python/crawlGames",
            data: {
                "dates": input_dates
            },
            success: function (data) {
                console.log('crawlGames ', data);
                predictGames();
            }
        });
    }

    function predictGames() {
        $.post({
            url: "/Hupu-Admin/python/predictGames",
            data: {},
            success: function (data) {
                console.log('predict games', data);
            }
        });
    }
</script>
</body>
</html>
