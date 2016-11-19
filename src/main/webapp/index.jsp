<!doctype html>
<html lang="en" ng-app="RDash">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">

    <title>RDash AngularJS</title>
    <!-- STYLES -->
    <link rel="stylesheet" href="lib/css/main.min.css"/>
    <link rel="stylesheet" href="css/style.min.css"/>
    <!-- SCRIPTS -->
    <script src="lib/js/main.min.js"></script>
    <!-- Custom Scripts -->
    <script type="text/javascript" src="js/dashboard.min.js"></script>

    <%--<link rel="stylesheet" href="WEB-INF/main.min.css"/>--%>
    <style>
        body {
            font-family: Calibri;
        }
    </style>
</head>
<body ng-app="RDash" ng-controller="MasterCtrl as masterctrl">
<div id="page-wrapper" ng-class="{'open': toggle}" ng-cloak>

    <!-- Sidebar -->
    <div id="sidebar-wrapper">
        <ul class="sidebar">
            <li class="sidebar-main">
                <a ng-click="toggleSidebar()">
                    Dashboard
                    <span class="menu-icon glyphicon glyphicon-transfer"></span>
                </a>
            </li>
            <li class="sidebar-title"><span>NAVIGATION</span></li>
            <%--<li class="sidebar-list">--%>
                <%--<a href="#">Dashboard <span class="menu-icon fa fa-tachometer"></span></a>--%>
            <%--</li>--%>
            <%--<li class="sidebar-list">--%>
                <%--<a href="#/tables">Tables <span class="menu-icon fa fa-table"></span></a>--%>
            <%--</li>--%>
            <li class="sidebar-list">
                <a href="#/item-tank">Add Item To Tank <span class="menu-icon fa fa-table"></span></a>
            </li>
            <li class="sidebar-list">
                <a href="#/tank">Tank <span class="menu-icon fa fa-table"></span></a>
            </li>
            <li class="sidebar-list">
                <a href="#/item">Items <span class="menu-icon fa fa-table"></span></a>
            </li>
            <li class="sidebar-list">
                <a href="#/brand">Brand <span class="menu-icon fa fa-table"></span></a>
            </li>
            <li class="sidebar-list">
                <a href="#/model">Model <span class="menu-icon fa fa-table"></span></a>
            </li>
        </ul>
        <%--<div class="sidebar-footer">--%>
        <%--<div class="col-xs-4">--%>
        <%--<a href="https://github.com/rdash/rdash-angular" target="_blank">--%>
        <%--Github--%>
        <%--</a>--%>
        <%--</div>--%>
        <%--<div class="col-xs-4">--%>
        <%--<a href="https://github.com/rdash/rdash-angular/blob/master/README.md" target="_blank">--%>
        <%--About--%>
        <%--</a>--%>
        <%--</div>--%>
        <%--<div class="col-xs-4">--%>
        <%--<a href="#">--%>
        <%--Support--%>
        <%--</a>--%>
        <%--</div>--%>
        <%--</div>--%>
    </div>
    <!-- End Sidebar -->

    <div id="content-wrapper">
        <div class="page-content">

            <!-- Header Bar -->
            <div class="row header">
                <div class="col-xs-12">
                    <div class="user pull-right">
                        <div class="item dropdown" uib-dropdown>
                            <a href="#" class="dropdown-toggle" uib-dropdown-toggle>
                                <img src="img/avatar.jpg">
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li class="dropdown-header">
                                    Joe Bloggs
                                </li>
                                <li class="divider"></li>
                                <li class="link">
                                    <a href="#">
                                        Profile
                                    </a>
                                </li>
                                <li class="link">
                                    <a href="#">
                                        Menu Item
                                    </a>
                                </li>
                                <li class="link">
                                    <a href="#">
                                        Menu Item
                                    </a>
                                </li>
                                <li class="divider"></li>
                                <li class="link">
                                    <a href="#">
                                        Logout
                                    </a>
                                </li>
                            </ul>
                        </div>
                        <div class="item dropdown" uib-dropdown>
                            <a href="#" class="dropdown-toggle" uib-dropdown-toggle>
                                <i class="fa fa-bell-o"></i>
                            </a>
                            <ul class="dropdown-menu dropdown-menu-right">
                                <li class="dropdown-header">
                                    Notifications
                                </li>
                                <li class="divider"></li>
                                <li>
                                    <a href="#">Server Down!</a>
                                </li>
                            </ul>
                        </div>
                    </div>
                    <div class="meta">
                        <div class="page">
                            Dashboard
                        </div>
                        <div class="breadcrumb-links">
                            Home / Dashboard
                        </div>
                    </div>
                </div>
            </div>
            <!-- End Header Bar -->

            <!-- Main Content -->
            <div ui-view></div>

        </div><!-- End Page Content -->
    </div><!-- End Content Wrapper -->
</div><!-- End Page Wrapper -->
</body>
</html>
