<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2020/4/16
  Time: 19:32
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

    <title>版本添加</title>
    <link rel="shortcut icon" href="http://114.115.134.119:8080/logo/LAL.png"/>
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
                <div class="page-title">
                    <div class="title_left">
                        <h3>Administrator Info</h3>
                    </div>

                    <div class="title_right">
                        <div class="col-md-5 col-sm-5 form-group pull-right top_search">
                            <div class="input-group">
                                <input type="text" class="form-control"
                                       placeholder="Search for...">
                                <span class="input-group-btn">
                    <button class="btn btn-default" type="button">Go!</button>
                  </span>
                            </div>
                        </div>
                    </div>
                </div>
                <div class="clearfix"></div>
                <div class="row">


                    <div class="col-md-12 ">
                        <div class="x_panel">
                            <div class="x_title">
                                <h2>Form Basic Elements
                                    <small>different form elements</small>
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
                                <br>
                                <div class="form-horizontal form-label-left">


                                    <div class="form-group row ">
                                        <label
                                                class="control-label col-md-3 col-sm-3 ">Version
                                            code</label>
                                        <div class="col-md-9 col-sm-9 ">
                                            <input type="number"
                                                   class="form-control"
                                                   id="code"
                                                   placeholder="Version Code">
                                        </div>
                                    </div>


                                    <div class="form-group row">
                                        <label
                                                class="control-label col-md-3 col-sm-3 ">version
                                            name</label>
                                        <div class="col-md-9 col-sm-9 ">
                                            <input type="text"
                                                   class="form-control"
                                                   id="name"
                                                   placeholder="version name">
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label class="control-label col-md-3 col-sm-3 ">
                                            Version Info
                                            <span
                                                    class="required">*</span>
                                        </label>
                                        <div class="col-md-9 col-sm-9 ">
                                            <textarea class="form-control"
                                                      rows="3"
                                                      id="info"
                                                      placeholder="Version Info"></textarea>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label
                                                class="control-label col-md-3 col-sm-3 ">version
                                            URL</label>
                                        <div class="col-md-9 col-sm-9 ">
                                            <input type="text" name="country"
                                                   id="url"
                                                   class="form-control col-md-10"
                                                   placeholder="url"/>
                                        </div>
                                    </div>
                                    <div class="form-group row">
                                        <label
                                                class="control-label col-md-3 col-sm-3 ">is
                                            force</label>
                                        <div class="col-md-9 col-sm-9 ">
                                            <label for="isForce"></label>
                                            <select id="isForce"
                                                    class="form-control">
                                                <option>0</option>
                                                <option>1</option>
                                            </select>
                                        </div>

                                    </div>

                                    <div class="form-group">
                                        <div class="col-md-9 col-sm-9  offset-md-3">
                                            <button type="button"
                                                    class="btn btn-primary">
                                                Cancel
                                            </button>
                                            <button type="reset"
                                                    class="btn btn-primary">
                                                Reset
                                            </button>
                                            <button onclick="mysubmit()"
                                                    class="btn btn-dark">
                                                Submit
                                            </button>
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

<script src="${pageContext.request.contextPath}/static/JS/user.js"></script>
<script type="text/javascript">
    function mysubmit() {

        var versionInfo = {
            "versionCode": parseInt($("#code").val()),
            "versionName": $("#name").val(),
            "updateUrl": $("#url").val(),
            "updateInfo": $("#info").val(),
            "forceUpdate": parseInt($("#isForce option:selected").val())
        };
        console.log(versionInfo);
        $.post({
            url: "/Hupu-Admin/version/addVersion",
            data: versionInfo,
            dataType: 'json',
            success: function (data) {
                alert("添加成功");
            }
        });
    }
</script>
</body>
</html>
