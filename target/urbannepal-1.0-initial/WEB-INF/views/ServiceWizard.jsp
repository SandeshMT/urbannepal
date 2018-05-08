<%-- 
    Document   : ServiceWizard
    Created on : Mar 14, 2017, 7:59:56 PM
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

    <title>Service </title>

    <!-- Bootstrap core CSS -->

    <link href="assets/css/bootstrap.min.css" rel="stylesheet">

    <link href="assets/fonts/css/font-awesome.min.css" rel="stylesheet">
    <link href="assets/css/animate.min.css" rel="stylesheet">

    <!-- Custom styling plus plugins -->
    <link href="assets/css/custom.css" rel="stylesheet">
    <link href="assets/css/icheck/flat/green.css" rel="stylesheet">
    <script src="assets/js/jquery.min.js"></script>
</head>


<body class="nav-md">

    <div class="container body">


        <div class="main_container">
            <!-- top navigation -->
            <!-- /top navigation -->

            <!-- page content -->
            <div class="right_col" role="main">

                <div class="">
                    <div class="clearfix"></div>

                    <div class="row">

                        <div class="col-md-12 col-sm-12 col-xs-12">
                            <div class="x_panel">
                                <div class="x_content">

                                    <form action="submitServiceOrder" method="POST" class="form-horizontal form-label-left">
                                    <!-- Smart Wizard -->
                                    <div id="wizard" class="form_wizard wizard_horizontal">
                                        <ul class="wizard_steps">
                                            <li>
                                                <a href="#step-1">
                                                    <span class="step_no">1</span>
                                                    <span class="step_descr">
                                            Step 1<br />
                                            <small>Step 1 description</small>
                                        </span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-2">
                                                    <span class="step_no">2</span>
                                                    <span class="step_descr">
                                            Step 2<br />
                                            <small>Step 2 description</small>
                                        </span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-3">
                                                    <span class="step_no">3</span>
                                                    <span class="step_descr">
                                            Step 3<br />
                                            <small>Step 3 description</small>
                                        </span>
                                                </a>
                                            </li>
                                            <li>
                                                <a href="#step-4">
                                                    <span class="step_no">4</span>
                                                    <span class="step_descr">
                                            Step 4<br />
                                            <small>Step 4 description</small>
                                        </span>
                                                </a>
                                            </li>
                                        </ul>
                                        
                                        <div id="step-1">
                                            

                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12" for="first-name">Full Name <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                        <input type="text" id="fullName" required="required" class="form-control col-md-7 col-xs-12">
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Locality<span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-6 col-sm-6 col-xs-12">
                                                    <input name="locality" class="form-control col-md-7 col-xs-12" required="required" type="text">
                                                    </div>
                                                </div>
                                                <h3>Your correct locality helps us connect you with the best suited pros</h3> 

                                            

                                        </div>
                                        <div id="step-2">
                                           <h3>Select Preferred Date</h3>
                                           <h4>Note: &nbsp;</h4><h5>Make precise date selection. It will be used to order priorities of the services....</h5>
                                          
                                           <p>From:</p><input class="datepicker" type="text" name="startDate" />
                                           
                                           <p>To:</p><input class="datepicker" type="text" name="endDate" />
                                           
                                          
                                        </div>
                                        <div id="step-3">
                                            <h2 class="StepTitle">Payment</h2>
                                            <p>Make advance Payment:</p>
                                        </div>
                                        <div id="step-4">
                                            <h2 class="StepTitle">Confirmation Details</h2>
                                            <p>Mobile Number</p><input type="text" name="mobileNumber" />
                                            <button type="button" class="btn btn-round btn-primary">Login / SignUp</button>
                                            <h2>OR</h2>
                                            <button type="button" class="btn btn-round btn-success">Continue with Google+</button>
                                            <button type="button" class="btn btn-round btn-info">Continue with Facebook</button>
                                        </div>

                                    </div>
                                    <!-- End SmartWizard Content -->
                                    </form>
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
    <!-- form wizard -->
    <script type="text/javascript" src="assets/js/wizard/jquery.smartWizard.js"></script>
    <script type="text/javascript">
        $(document).ready(function () {
            // Smart Wizard 	
            $('#wizard').smartWizard();

            function onFinishCallback() {
                $('#wizard').smartWizard('showMessage', 'Finish Clicked');
                //alert('Finish Clicked');
            }
        });

        $(document).ready(function () {
            // Smart Wizard	
            $('#wizard_verticle').smartWizard({
                transitionEffect: 'slide'
            });

        });
    </script>

</body>

</html>
