<%-- 
    Document   : EditServiceInfo
    Created on : Jan 8, 2017, 10:57:09 AM
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

    <title>Register New Service</title>

    <!-- Bootstrap core CSS -->

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <link href="assets/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="assets/css/custom.css" rel="stylesheet">
    <link href="assets/css/icheck/flat/green.css" rel="stylesheet">
    <!-- editor -->
    <link href="http://netdna.bootstrapcdn.com/font-awesome/3.0.2/css/font-awesome.css" rel="stylesheet">
    <link href="assets/css/editor/external/google-code-prettify/prettify.css" rel="stylesheet">
    <link href="assets/css/editor/index.css" rel="stylesheet">
    <!-- select2 -->
    <link href="assets/css/select/select2.min.css" rel="stylesheet">
    <!-- switchery -->
    <link rel="stylesheet" href="assets/css/switchery/switchery.min.css" />

    <script src="assets/js/jquery.min.js"></script>
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
                                    <h2>Form Design <small>different form elements</small></h2>
                                    <ul class="nav navbar-right panel_toolbox">
                                        <li><a class="collapse-link"><i class="fa fa-chevron-up"></i></a>
                                        </li>
                                        <li class="dropdown">
                                            <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-expanded="false"><i class="fa fa-wrench"></i></a>
                                            <ul class="dropdown-menu" role="menu">
                                                <li><a href="#">Settings 1</a>
                                                </li>
                                                <li><a href="#">Settings 2</a>
                                                </li>
                                            </ul>
                                        </li>
                                        <li><a class="close-link"><i class="fa fa-close"></i></a>
                                        </li>
                                    </ul>
                                    <div class="clearfix"></div>
                                </div>
                                <div class="x_content">
                                    <br />
                                    <form action="updateService" method="POST" class="form-horizontal form-label-left" >
                                    <c:forEach items="${serviceDetail}" var="sd">
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="service-name">Service Name</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="hidden" name="serviceId" value="${sd.slId}" readonly />
                                                <input type="text" name="serviceName" value="${sd.serviceName}" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        <div class="form-group">
                                            <label class="control-label col-md-3 col-sm-3 col-xs-12" for="price">Price</label>
                                            <div class="col-md-6 col-sm-6 col-xs-12">
                                                <input type="text" name="price" value="${sd.price}" class="form-control col-md-7 col-xs-12">
                                            </div>
                                        </div>
                                        </c:forEach>
                                        <div class="clearfix"></div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Service Provider<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <select name="serviceProvider">
                                                        <c:forEach items="${userList}" var="ul">
                                                            <option value="${ul.userId}"  >${ul.username}</option>
                                                        </c:forEach>
                                                        </select>
                                                    </div>
                                                </div>
                                        
                                        <div class="ln_solid"></div>
                                        <div class="form-group">
                                            <div class="col-md-6 col-sm-6 col-xs-12 col-md-offset-3">
                                                <button type="submit" class="btn btn-primary">Cancel</button>
                                                <button type="submit" class="btn btn-success">Submit</button>
                                            </div>
                                        </div>

                                    </form>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
                <!-- /page content -->

                <!-- footer content -->
                <jsp:include page="Footer.jsp"></jsp:include>
                <!-- /footer content -->

            </div>

        </div>
    </div>

        <div id="custom_notifications" class="custom-notifications dsp_none">
            <ul class="list-unstyled notifications clearfix" data-tabbed_notifications="notif-group">
            </ul>
            <div class="clearfix"></div>
            <div id="notif-group" class="tabbed_notifications"></div>
        </div>

        <script src="assets/js/bootstrap.min.js"></script>
</body>

</html>
