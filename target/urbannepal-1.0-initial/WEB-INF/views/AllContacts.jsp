<%-- 
    Document   : AllContacts
    Created on : Jan 2, 2017, 1:01:03 PM
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

        <title>All Contacts </title>

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
                                <div class="col-md-12">
                                    <div class="x_panel">
                                        <div class="x_content">

                                            <div class="row">

                                                <div class="col-md-12 col-sm-12 col-xs-12" style="text-align:center;">
                                                    <ul class="pagination pagination-split">
                                                        <li><a href="displaycontact?src=A">A</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=B">B</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=C">C</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=D">D</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=E">E</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=F">F</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=G">G</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=H">H</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=I">I</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=J">J</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=K">K</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=L">L</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=M">M</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=N">N</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=O">O</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=P">P</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=Q">Q</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=R">R</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=S">S</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=T">T</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=U">U</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=V">V</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=W">W</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=X">X</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=Y">Y</a>
                                                        </li>
                                                        <li><a href="displaycontact?src=Z">Z</a>
                                                        </li>
                                                    </ul>
                                                </div>
                                                <div class="clearfix"></div>

                                            <c:forEach items="${contactdetails}" var="cd">
                                                <div class="col-md-4 col-sm-4 col-xs-12 animated fadeInDown" style="float: left;">
                                                    <div class="well profile_view" style="z-index: 10; right: 0; top: auto;">
                                                        <div class="col-sm-12">
                                                            <h4 class="brief"><i>${cd.profession}</i></h4>
                                                            <div class="left col-xs-7">
                                                                <h2>${cd.firstname} &nbsp; ${cd.lastnanme}</h2>
                                                                <p><strong>Profession ID: </strong> ${cd.contactId} </p>
                                                                <ul class="list-unstyled">
                                                                    <li><i class="fa fa-phone"></i> Mob Num: ${cd.primaryno}</li>
                                                                    <li><i class="fa fa-phone"></i> Alt Num: ${cd.secondaryno}</li>
                                                                    <li><i class="fa fa-phone"></i> Address: ${cd.primaryaddress}</li>
                                                                    <li><i class="fa fa-phone"></i> Alt Address: ${cd.secondaryaddress}</li>
                                                                    <li><i class="fa fa-phone"></i> Email: ${cd.email}</li>
                                                                    <li><i class="fa fa-phone"></i> Gender: ${cd.gender}</li>
                                                                </ul>
                                                            </div>
                                                            <div class="clearfix"></div>
                                                            <div class="right col-xs-5 text-center">
                                                                <img src="${cd.profilepicture}" alt="Profile Picture" class="img-circle img-responsive">
                                                            </div>
                                                        </div>

                                                        <div class="col-xs-12 bottom text-center">

                                                            <div class="col-xs-12 col-sm-6 emphasis">
                                                                <p class="ratings">
                                                                    <a>4.0</a>
                                                                    <span class="fa fa-star"></span>
                                                                </p>
                                                            </div>
                                                            <div class="col-xs-12 col-sm-6 emphasis">
                                                                <button type="button" class="btn btn-success btn-xs"> <i class="fa fa-user">
                                                                    </i> <i class="fa fa-comments-o"></i> </button>
                                                                <button type="button" class="btn btn-primary btn-xs"> <i class="fa fa-user">
                                                                    </i> View Profile </button>
                                                            </div>
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

    </body>

</html>
