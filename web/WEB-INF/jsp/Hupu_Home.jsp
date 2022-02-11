<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/10
  Time: 16:58
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
    <%--<link rel="icon" href="images/favicon.ico" type="image/ico"/>--%>

    <title>NBA GAME INFO CMS</title>
    <link rel="shortcut icon" href="http://114.115.134.119:8080/logo/BOS.png"/>
    <!-- Bootstrap -->
    <link
            href="${pageContext.request.contextPath}/static/vendors/bootstrap/dist/css/bootstrap.min.css"
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

    <!-- bootstrap-progressbar -->
    <link href="${pageContext.request.contextPath}/static/vendors/bootstrap-progressbar/css/bootstrap-progressbar-3.3.4.min.css"
          rel="stylesheet">
    <!-- JQVMap -->
    <link href="${pageContext.request.contextPath}/static/vendors/jqvmap/dist/jqvmap.min.css"
          rel="stylesheet"/>
    <!-- bootstrap-daterangepicker -->
    <link href="${pageContext.request.contextPath}/static/vendors/bootstrap-daterangepicker/daterangepicker.css"
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
            <!-- top tiles -->
            <div class="row" style="display: inline-block;">
                <div class="tile_count">

                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Users</span>
                        <div class="count">${sessionScope.totalUser}</div>
                        <span class="count_bottom"><i class="green">4% </i> From last Week</span>
                    </div>

                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-clock-o"></i>
                            Total Game</span>
                        <div class="count">${sessionScope.totalGame}</div>
                        <span class="count_bottom"><i class="green"><i
                                class="fa fa-sort-asc"></i>3% </i> From last Week</span>
                    </div>

                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i>
                            Total Posts</span>
                        <div class="count green">${sessionScope.totalPost}</div>
                        <span class="count_bottom"><i class="green"><i
                                class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                    </div>

                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i>
                            Total Comment</span>
                        <div class="count">${sessionScope.totalComments}</div>
                        <span class="count_bottom"><i class="red"><i
                                class="fa fa-sort-desc"></i>12% </i> From last Week</span>
                    </div>

                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i> Total Collections</span>
                        <div class="count">${sessionScope.totalCollections}</div>
                        <span class="count_bottom"><i class="green"><i
                                class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                    </div>

                    <div class="col-md-2 col-sm-4  tile_stats_count">
                        <span class="count_top"><i class="fa fa-user"></i>
                            Total Teams</span>
                        <div class="count">30</div>
                        <span class="count_bottom"><i class="green"><i
                                class="fa fa-sort-asc"></i>34% </i> From last Week</span>
                    </div>

                </div>
            </div>
            <!-- /jump/top tiles -->

            <br/>

            <div class="row">
                <div class="col-md-4 col-sm-4 ">
                    <div class="x_panel">
                        <div class="x_title">
                            <h2>Recent Activities
                                <small>Sessions</small>
                            </h2>
                            <ul class="nav navbar-right panel_toolbox">
                                <li><a class="collapse-link"><i
                                        class="fa fa-chevron-up"></i></a>
                                </li>
                                <li class="dropdown">
                                    <a href="#" class="dropdown-toggle"
                                       data-toggle="dropdown" role="button"
                                       aria-expanded="false"><i
                                            class="fa fa-wrench"></i></a>
                                    <div class="dropdown-menu"
                                         aria-labelledby="dropdownMenuButton">
                                        <a class="dropdown-item" href="#">Settings
                                            1</a>
                                        <a class="dropdown-item" href="#">Settings
                                            2</a>
                                    </div>
                                </li>
                                <li><a class="close-link"><i
                                        class="fa fa-close"></i></a>
                                </li>
                            </ul>
                            <div class="clearfix"></div>
                        </div>
                        <div class="x_content">
                            <div class="dashboard-widget-content">
                                <ul class="list-unstyled timeline widget">
                                    <c:forEach var="post"
                                               items="${sessionScope.postList}">
                                        <li>
                                            <div class="block">
                                                <div class="block_content">
                                                    <h2 class="title">
                                                        <a>${post.title}</a>
                                                    </h2>
                                                    <div class="byline">
                                                        <span>${post.time}</span>
                                                        by
                                                        <span>${post.admin}</span>
                                                    </div>
                                                    <p
                                                            class="excerpt">${post.content}
                                                    </p>
                                                </div>
                                            </div>
                                        </li>
                                    </c:forEach>
                                </ul>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="col-md-8 col-sm-8 ">
                    <div class="row">
                        <div class="col-md-12 col-sm-12 ">
                            <div class="dashboard_graph">

                                <div class="row x_title">
                                    <div class="col-md-6">
                                        <h3>Sportide
                                            <small>用户活跃情况</small>
                                        </h3>
                                    </div>
                                    <div class="col-md-6">
                                        <div id="reportrange" class="pull-right"
                                             style="background: #fff; cursor: pointer; padding: 5px 10px; border: 1px solid #ccc">
                                            <i class="glyphicon glyphicon-calendar fa fa-calendar"></i>
                                            <span>December 30, 2014 - January 28, 2015</span>
                                            <b class="caret"></b>
                                        </div>
                                    </div>
                                </div>

                                <div class="col-md-9 col-sm-9 ">
                                    <div id="chart_plot_01"
                                         class="demo-placeholder"></div>
                                </div>

                                <div class="col-md-3 col-sm-3  bg-white">
                                    <div class="x_title">
                                        <h2>热门活动</h2>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="col-md-12 col-sm-12 ">
                                        <div>
                                            <p>比赛浏览</p>
                                            <div class="">
                                                <div class="progress progress_sm"
                                                     style="width: 76%;">
                                                    <div class="progress-bar bg-green"
                                                         role="progressbar"
                                                         data-transitiongoal="80"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <p>新闻浏览</p>
                                            <div class="">
                                                <div class="progress progress_sm"
                                                     style="width: 76%;">
                                                    <div class="progress-bar bg-green"
                                                         role="progressbar"
                                                         data-transitiongoal="30"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="col-md-12 col-sm-12 ">
                                        <div>
                                            <p>评论热度</p>
                                            <div class="">
                                                <div class="progress progress_sm"
                                                     style="width: 76%;">
                                                    <div class="progress-bar bg-green"
                                                         role="progressbar"
                                                         data-transitiongoal="40"></div>
                                                </div>
                                            </div>
                                        </div>
                                        <div>
                                            <p>比赛收藏</p>
                                            <div class="">
                                                <div class="progress progress_sm"
                                                     style="width: 76%;">
                                                    <div class="progress-bar bg-green"
                                                         role="progressbar"
                                                         data-transitiongoal="50"></div>
                                                </div>
                                            </div>
                                        </div>
                                    </div>

                                </div>

                                <div class="clearfix"></div>
                            </div>
                        </div>

                    </div>


                    <div class="row">


                        <div class="col-md-6 col-sm-6 ">
                            <div class="x_panel tile fixed_height_320">
                                <div class="x_title">
                                    <h2>App Versions</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i
                                                class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle"
                                               data-toggle="dropdown"
                                               role="button"
                                               aria-expanded="false"><i
                                                    class="fa fa-wrench"></i></a>
                                            <div class="dropdown-menu"
                                                 aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item"
                                                   href="#">Settings 1</a>
                                                <a class="dropdown-item"
                                                   href="#">Settings 2</a>
                                            </div>
                                        </li>
                                        <li><a class="close-link"><i
                                                class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <h4>Sportide 版本使用统计</h4>
                                    <div class="widget_summary">
                                        <div class="w_left w_25">
                                            <span>release-1.0.2</span>
                                        </div>
                                        <div class="w_center w_55">
                                            <div class="progress">
                                                <div class="progress-bar bg-green"
                                                     role="progressbar"
                                                     aria-valuenow="60"
                                                     aria-valuemin="0"
                                                     aria-valuemax="100"
                                                     style="width: 20%;">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="w_right w_20">
                                            <span>12</span>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>

                                    <div class="widget_summary">
                                        <div class="w_left w_25">
                                            <span>release-1.0.3</span>
                                        </div>
                                        <div class="w_center w_55">
                                            <div class="progress">
                                                <div class="progress-bar bg-green"
                                                     role="progressbar"
                                                     aria-valuenow="60"
                                                     aria-valuemin="0"
                                                     aria-valuemax="100"
                                                     style="width: 12%;">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="w_right w_20">
                                            <span>8</span>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="widget_summary">
                                        <div class="w_left w_25">
                                            <span>release-1.1.0</span>
                                        </div>
                                        <div class="w_center w_55">
                                            <div class="progress">
                                                <div class="progress-bar bg-green"
                                                     role="progressbar"
                                                     aria-valuenow="60"
                                                     aria-valuemin="0"
                                                     aria-valuemax="100"
                                                     style="width: 25%;">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="w_right w_20">
                                            <span>12</span>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                    <div class="widget_summary">
                                        <div class="w_left w_25">
                                            <span>release-1.1.1</span>
                                        </div>
                                        <div class="w_center w_55">
                                            <div class="progress">
                                                <div class="progress-bar bg-green"
                                                     role="progressbar"
                                                     aria-valuenow="60"
                                                     aria-valuemin="0"
                                                     aria-valuemax="100"
                                                     style="width: 50%;">
                                                    <span class="sr-only">60% Complete</span>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="w_right w_20">
                                            <span>${sessionScope.totalUser}</span>
                                        </div>
                                        <div class="clearfix"></div>
                                    </div>
                                </div>
                            </div>
                        </div>

                        <div class="col-md-6 col-sm-6 ">
                            <div class="x_panel tile fixed_height_320">
                                <div class="x_title">
                                    <h2>待施工的设置</h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i
                                                class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle"
                                               data-toggle="dropdown"
                                               role="button"
                                               aria-expanded="false"><i
                                                    class="fa fa-wrench"></i></a>
                                            <div class="dropdown-menu"
                                                 aria-labelledby="dropdownMenuButton">
                                                <a class="dropdown-item"
                                                   href="#">Settings 1</a>
                                                <a class="dropdown-item"
                                                   href="#">Settings 2</a>
                                            </div>
                                        </li>
                                        <li><a class="close-link"><i
                                                class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <div class="dashboard-widget-content">
                                        <ul class="quick-list">
                                            <li><i class="fa fa-calendar-o"></i><a
                                                    href="#">Settings</a>
                                            </li>
                                            <li><i class="fa fa-bars"></i><a
                                                    href="#">Subscription</a>
                                            </li>
                                            <li>
                                                <i class="fa fa-bar-chart"></i><a
                                                    href="#">Auto Renewal</a>
                                            </li>
                                            <li><i class="fa fa-line-chart"></i><a
                                                    href="#">Achievements</a>
                                            </li>
                                            <li>
                                                <i class="fa fa-bar-chart"></i><a
                                                    href="#">Auto Renewal</a>
                                            </li>
                                            <li><i class="fa fa-line-chart"></i><a
                                                    href="#">Achievements</a>
                                            </li>
                                            <li><i class="fa fa-area-chart"></i><a
                                                    href="#">Logout</a>
                                            </li>
                                        </ul>

                                        <div class="sidebar-widget">
                                            <h4>首页总体进度</h4>
                                            <canvas width="150" height="80"
                                                    id="chart_gauge_01" class=""
                                                    style="width: 160px; height: 100px;"></canvas>
                                            <div class="goal-wrapper">
                                                <span id="gauge-text"
                                                      class="gauge-value pull-left">0</span>
                                                <span class="gauge-value pull-left">%</span>
                                                <span id="goal-text"
                                                      class="goal-value pull-right">100%</span>
                                            </div>
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
<!-- Chart.js -->
<script src="${pageContext.request.contextPath}/static/vendors/Chart.js/dist/Chart.min.js"></script>
<!-- gauge.js -->
<script src="${pageContext.request.contextPath}/static/vendors/gauge.js/dist/gauge.min.js"></script>
<!-- bootstrap-progressbar -->
<script src="${pageContext.request.contextPath}/static/vendors/bootstrap-progressbar/bootstrap-progressbar.min.js"></script>
<!-- iCheck -->
<script src="${pageContext.request.contextPath}/static/vendors/iCheck/icheck.min.js"></script>
<!-- Skycons -->
<script src="${pageContext.request.contextPath}/static/vendors/skycons/skycons.js"></script>
<!-- Flot -->
<script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.pie.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.time.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.stack.js"></script>
<%--<script src="${pageContext.request.contextPath}/static/vendors/Flot/jquery.flot.resize.js"></script>--%>
<!-- Flot plugins -->
<script src="${pageContext.request.contextPath}/static/vendors/flot.orderbars/js/jquery.flot.orderBars.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/flot-spline/js/jquery.flot.spline.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/flot.curvedlines/curvedLines.js"></script>
<!-- DateJS -->
<script src="${pageContext.request.contextPath}/static/vendors/DateJS/build/date.js"></script>
<!-- JQVMap -->
<script src="${pageContext.request.contextPath}/static/vendors/jqvmap/dist/jquery.vmap.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/jqvmap/dist/maps/jquery.vmap.world.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/jqvmap/examples/js/jquery.vmap.sampledata.js"></script>
<!-- bootstrap-daterangepicker -->
<script src="${pageContext.request.contextPath}/static/vendors/moment/min/moment.min.js"></script>
<script src="${pageContext.request.contextPath}/static/vendors/bootstrap-daterangepicker/daterangepicker.js"></script>

<!-- Custom Theme Scripts -->
<script src="${pageContext.request.contextPath}/static/build/js/custom.min.js"></script>

</body>
</html>