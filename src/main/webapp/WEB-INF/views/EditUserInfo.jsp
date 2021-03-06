<%-- 
    Document   : EditUserInfo
    Created on : Jan 6, 2017, 1:27:30 PM
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

        <title>Edit User Info</title>

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

        <!--[if lt IE 9]>
            <script src="../assets/js/ie8-responsive-file-warning.js"></script>
            <![endif]-->

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!--[if lt IE 9]>
              <script src="https://oss.maxcdn.com/html5shiv/3.7.2/html5shiv.min.js"></script>
              <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
            <![endif]-->
        <script>
            function hideDivs(){
                $("#fileinputareaforfeaturedimage").hide();
            };
        </script>

    </head>


    <body class="nav-md" onload="hideDivs();">

        <div class="container body">


            <div class="main_container">

                <jsp:include page="LeftSideMenusBar.jsp"></jsp:include>

                    <!-- top navigation -->
                <jsp:include page="TopNavBar.jsp"></jsp:include>
                    <!-- /top navigation -->

                    <!-- page content -->
                    <div class="right_col" role="main">
                        <div class="">
                            <div class="row">
                                <div class="col-md-6 col-xs-12">
                                    <div class="x_panel">
                                        <div class="x_title">
                                            <h2>Urban Nepal <small>add professionals</small></h2>
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
                                            <form class="form-horizontal form-label-left input_mask" method="POST" action="updateUserInfo">
                                            <c:forEach items="${userdetails}" var="usr">
                                                <div class="control-group" form-group style="float: left">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Profile Picture</label>
                                                    <div class="clearfix"></div>
                                                    <div id="image-holder">
                                                    <img src="${usr.profilepicture}" style="height: 70px; width: 70px;" />
                                                    </div>
                                                    <div class="clearfix"></div>
                                                    <div class="clearfix"></div>
                                                    <button type="button" id="cfibtn" class="btn btn-primary">Change Profile Picture</button>
                                                    <div class="clearfix"></div>
                                                    <div id="fileinputareaforfeaturedimage" class="col-md-9 col-sm-9 col-xs-12" >
                                                        <input id="imgChange" class="file" type='file' />
                                                    </div>
                                                </div>
                                                <div class="clearfix"></div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Username<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12 form-group has-feedback">
                                                        <input type="hidden" name="userId" id="usrId" value="${usr.userId}">
                                                        <input type="text" class="form-control" name="username" value="${usr.username}">
                                                        <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">First Name<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12 form-group has-feedback">
                                                        <input type="text" class="form-control" name="firstname" value="${usr.firstname}">
                                                        <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Last Name<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="lastname" value="${usr.lastname}">
                                                        <span class="fa fa-user form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Email<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="email" value="${usr.email}">
                                                        <span class="fa fa-envelope form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Role<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <select name="role">
                                                            <option value="1" <c:if test="${usr.role}==1">selected="selected"</c:if> >Admin</option>
                                                            <option value="2" <c:if test="${usr.role}==2">selected="selected"</c:if> >Professional</option>
                                                            <option value="3" <c:if test="${usr.role}==3">selected="selected"</c:if> >Editor</option>
                                                            <option value="4" <c:if test="${usr.role}==4">selected="selected"</c:if> >Service Users</option>
                                                        </select>
                                                    </div>
                                                </div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Biographical Information<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <div class="col-md-9 col-sm-9 col-xs-12">
                                                            <textarea class="resizable_textarea form-control" style="width: 100%; overflow: hidden; word-wrap: break-word; resize: horizontal; height: 87px;" name="biographicalInformation">
                                                            ${usr.biographicalInformation}</textarea>
                                                        </div>
                                                        <span class="fa fa-child form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                </c:forEach>
                                            <c:forEach items="${contactdetails}" var="cdtls">
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Profession <span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="hidden" name="contId" id="contactId" value="${cdtls.contactId}">
                                                        <input type="text" name="profession" class="form-control" value="${cdtls.profession}">
                                                        <span class="fa fa-graduation-cap form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Primary Number<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="primaryNum" value="${cdtls.primaryno}">
                                                        <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Secondary Number</label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="secondaryNum" value="${cdtls.secondaryno}">
                                                        <span class="fa fa-phone form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Primary Address<span class="required">*</span></label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="paddress" value="${cdtls.primaryaddress}">
                                                        <span class="fa fa-home form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group form-group has-feedback">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Secondary Address</label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <input type="text" class="form-control" name="saddress" value="${cdtls.secondaryaddress}">
                                                        <span class="fa fa-home form-control-feedback right" aria-hidden="true"></span>
                                                    </div>
                                                </div>
                                                <div class="form-group">
                                                    <label class="control-label col-md-3 col-sm-3 col-xs-12">Gender <span class="required">*</span>
                                                    </label>
                                                    <div class="col-md-9 col-sm-9 col-xs-12">
                                                        <p>
                                                            Male:
                                                            <input type="radio" class="flat" name="gender" id="genderM" value="Male" <c:if test="${cdtls.gender.equals('Male')}">checked="checked"</c:if> /> Female:
                                                            <input type="radio" class="flat" name="gender" id="genderF" value="Female" <c:if test="${cdtls.gender.equals('Male')}">checked="checked"</c:if> />
                                                        </p>
                                                    </div>
                                                </div>
                                                </c:forEach>
                                                <div class="ln_solid"></div>
                                                <div class="form-group">
                                                    <div class="col-md-9 col-sm-9 col-xs-12 col-md-offset-3">
                                                        <button type="reset" class="btn btn-primary">Reset</button>
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
        <script>
            $("#cfibtn").click(function(){
                $("#fileinputareaforfeaturedimage").show();
                $("#cfibtn").hide();
            });
        </script>
        
        <script>
            $("#imgChange").on('change',function(){
                $("#imgChange").toggle('hide');
                var formData=new FormData();
                formData.append('userId',$("#usrId").val());
                formData.append('contactId',$("#contactId").val());
                formData.append('file',$("#imgChange")[0].files[0]);
                console.log(formData);
                $.ajax({
                    url:"updatesrandcontimage",
                    data: formData,
                    type: "POST",
                    processData: false,
                    contentType: false,
                    success: function(response){
                        alert("Image updated successfully");
                    },
                    error: function(response){
                        alert("Failed to update image");
                    }
                    
                });
                if (typeof (FileReader) != "undefined") {

                        var image_holder = $("#image-holder");
                        image_holder.empty();

                        var reader = new FileReader();
                        reader.onload = function(e) {
                            $("<img />", {
                                "src": e.target.result,
                                "class": "thumb-image"
                            }).appendTo(image_holder);

                        }
                        image_holder.show();
                        reader.readAsDataURL($(this)[0].files[0]);
                    } else {
                        alert("This browser does not support FileReader.");
                    }
                    $("#cfibtn").show();
            });
        </script>

        <script src="assets/js/bootstrap.min.js"></script>

        <!-- chart js -->
        <script src="assets/js/chartjs/chart.min.js"></script>
        <!-- bootstrap progress js -->
        <script src="assets/js/progressbar/bootstrap-progressbar.min.js"></script>
        <script src="assets/js/nicescroll/jquery.nicescroll.min.js"></script>
        <!-- icheck -->
        <script src="assets/js/icheck/icheck.min.js"></script>
        <!-- tags -->
        <script src="assets/js/tags/jquery.tagsinput.min.js"></script>
        <!-- switchery -->
        <script src="assets/js/switchery/switchery.min.js"></script>
        <!-- daterangepicker -->
        <script type="text/javascript" src="assets/js/moment.min2.js"></script>
        <script type="text/javascript" src="assets/js/datepicker/daterangepicker.js"></script>
        <!-- richtext editor -->
        <script src="assets/js/editor/bootstrap-wysiwyg.js"></script>
        <script src="assets/js/editor/external/jquery.hotkeys.js"></script>
        <script src="assets/js/editor/external/google-code-prettify/prettify.js"></script>
        <!-- select2 -->
        <script src="assets/js/select/select2.full.js"></script>
        <!-- form validation -->
        <script type="text/javascript" src="assets/js/parsley/parsley.min.js"></script>
        <!-- textarea resize -->
        <script src="assets/js/textarea/autosize.min.js"></script>
        <script>
            autosize($('.resizable_textarea'));
        </script>
        <!-- Autocomplete -->
        <script type="text/javascript" src="assets/js/autocomplete/countries.js"></script>
        <script src="assets/js/autocomplete/jquery.autocomplete.js"></script>
        <script type="text/javascript">
            $(function () {
                'use strict';
                var countriesArray = $.map(countries, function (value, key) {
                    return {
                        value: value,
                        data: key
                    };
                });
                // Initialize autocomplete with custom appendTo:
                $('#autocomplete-custom-append').autocomplete({
                    lookup: countriesArray,
                    appendTo: '#autocomplete-container'
                });
            });
        </script>
        <script src="assets/js/custom.js"></script>


        <!-- select2 -->
        <script>
            $(document).ready(function () {
                $(".select2_single").select2({
                    placeholder: "Select a state",
                    allowClear: true
                });
                $(".select2_group").select2({});
                $(".select2_multiple").select2({
                    maximumSelectionLength: 4,
                    placeholder: "With Max Selection limit 4",
                    allowClear: true
                });
            });
        </script>
        <!-- /select2 -->
        <!-- input tags -->
        <script>
            function onAddTag(tag) {
                alert("Added a tag: " + tag);
            }

            function onRemoveTag(tag) {
                alert("Removed a tag: " + tag);
            }

            function onChangeTag(input, tag) {
                alert("Changed a tag: " + tag);
            }

            $(function () {
                $('#tags_1').tagsInput({
                    width: 'auto'
                });
            });
        </script>
        <!-- /input tags -->
        <!-- form validation -->
        <script type="text/javascript">
            $(document).ready(function () {
                $.listen('parsley:field:validate', function () {
                    validateFront();
                });
                $('#demo-form .btn').on('click', function () {
                    $('#demo-form').parsley().validate();
                    validateFront();
                });
                var validateFront = function () {
                    if (true === $('#demo-form').parsley().isValid()) {
                        $('.bs-callout-info').removeClass('hidden');
                        $('.bs-callout-warning').addClass('hidden');
                    } else {
                        $('.bs-callout-info').addClass('hidden');
                        $('.bs-callout-warning').removeClass('hidden');
                    }
                };
            });

            $(document).ready(function () {
                $.listen('parsley:field:validate', function () {
                    validateFront();
                });
                $('#demo-form2 .btn').on('click', function () {
                    $('#demo-form2').parsley().validate();
                    validateFront();
                });
                var validateFront = function () {
                    if (true === $('#demo-form2').parsley().isValid()) {
                        $('.bs-callout-info').removeClass('hidden');
                        $('.bs-callout-warning').addClass('hidden');
                    } else {
                        $('.bs-callout-info').addClass('hidden');
                        $('.bs-callout-warning').removeClass('hidden');
                    }
                };
            });
            try {
                hljs.initHighlightingOnLoad();
            } catch (err) {
            }
        </script>
        <!-- /form validation -->
        <!-- editor -->
        <script>
            $(document).ready(function () {
                $('.xcxc').click(function () {
                    $('#descr').val($('#editor').html());
                });
            });

            $(function () {
                function initToolbarBootstrapBindings() {
                    var fonts = ['Serif', 'Sans', 'Arial', 'Arial Black', 'Courier',
                        'Courier New', 'Comic Sans MS', 'Helvetica', 'Impact', 'Lucida Grande', 'Lucida Sans', 'Tahoma', 'Times',
                        'Times New Roman', 'Verdana'],
                            fontTarget = $('[title=Font]').siblings('.dropdown-menu');
                    $.each(fonts, function (idx, fontName) {
                        fontTarget.append($('<li><a data-edit="fontName ' + fontName + '" style="font-family:\'' + fontName + '\'">' + fontName + '</a></li>'));
                    });
                    $('a[title]').tooltip({
                        container: 'body'
                    });
                    $('.dropdown-menu input').click(function () {
                        return false;
                    })
                            .change(function () {
                                $(this).parent('.dropdown-menu').siblings('.dropdown-toggle').dropdown('toggle');
                            })
                            .keydown('esc', function () {
                                this.value = '';
                                $(this).change();
                            });

                    $('[data-role=magic-overlay]').each(function () {
                        var overlay = $(this),
                                target = $(overlay.data('target'));
                        overlay.css('opacity', 0).css('position', 'absolute').offset(target.offset()).width(target.outerWidth()).height(target.outerHeight());
                    });
                    if ("onwebkitspeechchange" in document.createElement("input")) {
                        var editorOffset = $('#editor').offset();
                        $('#voiceBtn').css('position', 'absolute').offset({
                            top: editorOffset.top,
                            left: editorOffset.left + $('#editor').innerWidth() - 35
                        });
                    } else {
                        $('#voiceBtn').hide();
                    }
                }
                ;

                function showErrorAlert(reason, detail) {
                    var msg = '';
                    if (reason === 'unsupported-file-type') {
                        msg = "Unsupported format " + detail;
                    } else {
                        console.log("error uploading file", reason, detail);
                    }
                    $('<div class="alert"> <button type="button" class="close" data-dismiss="alert">&times;</button>' +
                            '<strong>File upload error</strong> ' + msg + ' </div>').prependTo('#alerts');
                }
                ;
                initToolbarBootstrapBindings();
                $('#editor').wysiwyg({
                    fileUploadError: showErrorAlert
                });
                window.prettyPrint && prettyPrint();
            });
        </script>
        <!-- /editor -->
    </body>

</html>
