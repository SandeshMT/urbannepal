<%-- 
    Document   : AllPages
    Created on : Jan 4, 2017, 5:25:07 PM
    Author     : myhp
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">

    <head>

        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <!-- Meta, title, CSS, favicons, etc. -->
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">

        <title>All Pages</title>

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
                                            <h2>Details <small>of Posts</small></h2>
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
                                                        <th class="column-title">Title </th>
                                                        <th class="column-title">Author</th>
                                                        <th class="column-title">Published Date </th>
                                                        <th class="column-title">SEO </th>
                                                        <th class="column-title">Readibility</th>
                                                        <th class="column-title no-link last"><span class="nobr">Action</span></th>
                                                    </tr>
                                                </thead>

                                                <tbody>
                                                    <tr class="even pointer">
                                                        <td class="a-center "><input type="checkbox" class="flat" name="table_records" ></td>
                                                        <td class=" ">121000040</td>
                                                        <td class=" ">May 23, 2014 11:47:56 PM </td>
                                                        <td class=" ">121000210 <i class="success fa fa-long-arrow-up"></i></td>
                                                        <td class=" ">John Blank L</td>
                                                        <td class=" ">
                                                            <button type="button" class="btn btn-primary">Draft</button>
                                                            <button type="button" class="btn btn-success">Published</button>
                                                        </td>
                                                        <td class=" last">
                                                            <button type="button" class="btn btn-info"><a href="">View</a></button>
                                                            <button type="button" class="btn btn-warning"><a href="">Edit</a></button>
                                                            <button type="button" class="btn btn-danger"><a href="">Delete</a></button>
                                                        </td>
                                                    </tr>
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
