<%--
  Created by IntelliJ IDEA.
  User: yx0119
  Date: 2020/4/26
  Time: 18:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="col-md-3 left_col">
    <div class="left_col scroll-view">
        <div class="navbar nav_title" style="border: 0;">
            <a href="#"
               class="site_title"><i
                    class="fa fa-trophy"></i>
                <span>NBA INFO CMS</span></a>
        </div>

        <div class="clearfix"></div>

        <!-- menu profile quick info -->
        <div class="profile clearfix">
            <%--<div class="profile_pic">--%>
            <%--<!--管理员头像-->--%>
            <%--<img src="images/img.jpg" alt="..."--%>
            <%--class="img-circle profile_img">--%>
            <%--</div>--%>
            <div class="profile_info">
                <span>Welcome, </span>
                <!--管理员<span>Welcome,</span>名字-->
                <h2>${sessionScope.admin}</h2>
            </div>
        </div>
        <!-- /menu profile quick info -->

        <br/>

        <!-- sidebar menu -->
        <div id="sidebar-menu"
             class="main_menu_side hidden-print main_menu">
            <div class="menu_section">
                <h3>General</h3>
                <ul class="nav side-menu">
                    <!-- yx add -->
                    <li>
                        <a href="${pageContext.request.contextPath}/jump/toHome"><i
                                class="fa fa-home"></i> 首页</a>
                    </li>
                    <li><a><i class="fa fa-flag-checkered"></i> 赛事管理
                        <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toGameTable">赛事信息</a>
                            </li>

                            <li><a
                                    href="${pageContext.request.contextPath}/jump/toGameFuture">
                                未来赛事AI预测</a>
                            </li>

                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toTeamTable">球队信息</a>
                            </li>

                            <li>
                                <a
                                        href="${pageContext.request.contextPath}/jump/toPyGame">球队博物馆</a>
                            </li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-users"></i> 用户管理 <span
                            class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toUserTable">用户信息</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toFeedBackTable">用户反馈信息</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toAdminUserTable">管理员信息</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toAdminAdd">添加管理员</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toVersion">版本管理</a>
                            </li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-pencil-square-o"></i> 论坛管理
                        <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu">
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toPostTable">帖子信息</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toComTable">评论信息</a>
                            </li>
                            <li>
                                <a href="${pageContext.request.contextPath}/jump/toGameAdd">添加新闻</a>
                            </li>
                        </ul>
                    </li>
                    <!-- yx add end -->
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->

        <!-- /menu footer buttons -->
    </div>
</div>

<!-- top navigation -->
<div class="top_nav">
    <div class="nav_menu">
        <div class="nav toggle">
            <a id="menu_toggle"><i class="fa fa-bars"></i></a>
        </div>
        <nav class="nav navbar-nav">
            <ul class=" navbar-right">
                <li class="nav-item dropdown open"
                    style="padding-left: 15px;">
                    <a href="javascript:;"
                       class="user-profile dropdown-toggle"
                       aria-haspopup="true" id="navbarDropdown"
                       data-toggle="dropdown" aria-expanded="false">
                        ${sessionScope.admin}
                    </a>
                    <div class="dropdown-menu dropdown-usermenu pull-right"
                         aria-labelledby="navbarDropdown">
                        <a class="dropdown-item" href="javascript:;">
                            Profile</a>
                        <a class="dropdown-item" href="javascript:;">
                            <span class="badge bg-red pull-right">50%</span>
                            <span>Settings</span>
                        </a>
                        <a class="dropdown-item" href="javascript:;">Help</a>
                        <a class="dropdown-item"
                           href="${pageContext.request.contextPath}/index.jsp"><i
                                class="fa fa-sign-out pull-right"></i>
                            Log Out</a>
                    </div>
                </li>

            </ul>
        </nav>
    </div>
</div>
<!-- /jump/top navigation -->