<%-- 
    Document   : AllServices
    Created on : Jan 4, 2017, 7:45:23 PM
    Author     : myhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>All Services</title>

        <!-- Bootstrap core CSS -->

        <link href="assets/css/bootstrap.min.css" rel="stylesheet">

        <link href="assets/fonts/css/font-awesome.min.css" rel="stylesheet">
        <link href="assets/css/animate.min.css" rel="stylesheet">

        <!-- Custom styling plus plugins -->
        <link href="assets/css/custom.css" rel="stylesheet">
        <link href="assets/css/icheck/flat/green.css" rel="stylesheet">


        <script src="assets/js/jquery.min.js"></script>

        <!--[if lt IE 9]>
            <script src="../assets/js/ie8-responsive-file-warning.js"></script>
            <![endif]-->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->

        <script src="https://code.jquery.com/jquery-1.12.4.min.js"></script>
        <link rel="stylesheet" href="https://cdn.datatables.net/1.10.12/css/jquery.dataTables.min.css"/>
        <script src="https://cdn.datatables.net/1.10.12/js/jquery.dataTables.min.js"></script>
    </head>


    <body class="nav-md">

        <div class="container body">


            <div class="main_container">

                <jsp:include page="LeftSideMenusBar.jsp"></jsp:include>

                    <!-- top navigation -->
                <jsp:include page="TopNavBar.jsp"></jsp:include>
                    <!-- /top navigation -->

                    <!-- page content -->
                    <div class="right_col" role="main">
                        <div class=""> 
                            <div class="clearfix"></div>
                            <div class="row">
                                <div class="col-md-12 col-sm-12 col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2>Details <small>of Services</small></h2>
                                            <ul class="nav navbar-right panel_toolbox">
                                                <li><a class="collapse-link"><i class="fa fa-chevron-up" ></i></a>
                                                </li>
                                                <li class="dropdown">
                                                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                                    <ul class="dropdown-menu" role="menu">
                                                        <li><a href="#">Delete</a>
                                                        </li>
                                                        <li><a href="#">Edit</a>
                                                        </li>
                                                    </ul>
                                                </li>
                                            </ul>
                                            <div class="clearfix"></div>
                                        </div>
                                        <div class="x_content">
                                            <div class="x_title">
                                                <ul class="nav navbar-right panel_toolbox">
                                                    <li class="dropdown">
                                                        <button data-toggle="dropdown" class="btn btn-default dropdown-toggle" type="button" aria-expanded="false">Bulk Action <span class="caret"></span>
                                                        </button>
                                                        <ul class="dropdown-menu" role="menu">
                                                            <li><a href="#">Delete</a>
                                                            </li>
                                                            <li><a href="#">Edit</a>
                                                            </li>
                                                        </ul>
                                                    </li>
                                                </ul>
                                                <div class="clearfix"></div>
                                            </div>


                                            <table id="mytable" class="table table-striped responsive-utilities jambo_table bulk_action">
                                                <thead>
                                                    <tr class="headings">
                                                        <th>
                                                            <input type="checkbox" id="check-all" class="flat">
                                                        </th>
                                                        <th class="column-title">Service Name</th>
                                                        <th class="column-title">Price</th>
                                                        <th class="column-title">Service Provider</th>
                                                        <th class="column-title">Contact ID</th>
                                                        <th class="column-title no-link last"><span class="nobr">Action</span></th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                <c:forEach items="${serviceDetails}" var="sd">
                                                    <tr class="even pointer">
                                                        <td class="a-center "><input type="checkbox" class="flat" name="table_records" ></td>
                                                        <td class=" ">${sd.serviceName}</td>
                                                        <td class=" ">${sd.price} </td>
                                                        <td class=" ">${sd.serviceProvider} </td>
                                                        <td class=" ">${sd.contactId} </td>
                                                        <td class=" last">
                                                            <a href="viewprofile?uid=${sd.serviceProvider}&&cid=${sd.contactId} "><button type="button" class="btn btn-primary">SP Profile</button></a>
                                                            <a href="editService?esid=${sd.slId}"><button type="button" class="btn btn-warning">Edit</button></a>
                                                            <a href="deleteService?dsid=${sd.slId}"><button type="button" class="btn btn-danger">Delete</button></a>
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

                        <!-- footer content -->
                    <jsp:include page="Footer.jsp"></jsp:include>
                    <!-- /footer content -->

                </div>
                <!-- /page content -->
            </div>

        </div>

        <div id="custom_notifications" class="custom-notifications dsp_none">
            <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
            </ul>
            <div class="clearfix"></div>
            <div id="notif-group" class="tabbed_notifications"></div>
        </div>

        <script src="assets/js/bootstrap.min.js"></script>

        <!-- chart js -->
        <script src="assets/js/chartjs/chart.min.js"></script>
        <!-- bootstrap progress js -->
        <script src="assets/js/progressbar/bootstrap-progressbar.min.js"></script>
        <script src="assets/js/nicescroll/jquery.nicescroll.min.js"></script>
        <!-- icheck -->
        <script src="assets/js/icheck/icheck.min.js"></script>

        <script src="assets/js/custom.js"></script>
        <script>
            $(document).ready(function () {
                $("#mytable").DataTable();
            });

        </script>

    </body>

</html>
