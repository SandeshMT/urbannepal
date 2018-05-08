<%-- 
    Document   : MainBlogPage
    Created on : Jan 22, 2017, 9:32:30 PM
    Author     : myhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Urban Nepal</title>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <link rel="stylesheet" type="text/css" href="assets/css/bootstrap.min_2.css">
        <link rel="stylesheet" type="text/css" href="assets/css/font-awesome.min_1.css">
        <link rel="stylesheet" type="text/css" href="assets/css/animate_1.css">
        <link rel="stylesheet" type="text/css" href="assets/css/li-scroller.css">
        <link rel="stylesheet" type="text/css" href="assets/css/slick.css">
        <link rel="stylesheet" type="text/css" href="assets/css/theme.css">
        <link rel="stylesheet" type="text/css" href="assets/css/style_1.css">
        <!--[if lt IE 9]>
        <script src="assets/js/html5shiv.min.js"></script>
        <script src="assets/js/respond.min.js"></script>
        <![endif]-->
        <style>
            * {box-sizing:border-box}
            body {font-family: Verdana,sans-serif;}
            .mySlides {display:none}

            /* Slideshow container */
            .slideshow-container {
                max-width: 1000px;
                position: relative;
                margin: auto;
            }

            /* Caption text */
            .text {
                color: #f2f2f2;
                font-size: 15px;
                padding: 8px 12px;
                position: absolute;
                bottom: 8px;
                width: 100%;
                text-align: center;
            }

            /* Number text (1/3 etc) */
            .numbertext {
                color: #f2f2f2;
                font-size: 12px;
                padding: 8px 12px;
                position: absolute;
                top: 0;
            }

            /* The dots/bullets/indicators */
            .dot {
                height: 13px;
                width: 13px;
                margin: 0 2px;
                background-color: #bbb;
                border-radius: 50%;
                display: inline-block;
                transition: background-color 0.6s ease;
            }

            .active {
                background-color: #717171;
            }

            /* Fading animation */
            .fade {
                -webkit-animation-name: fade;
                -webkit-animation-duration: 1.5s;
                animation-name: fade;
                animation-duration: 1.5s;
            }

            @-webkit-keyframes fade {
                from {opacity: .4} 
                to {opacity: 1}
            }

            @keyframes fade {
                from {opacity: .4} 
                to {opacity: 1}
            }

            /* On smaller screens, decrease text size */
            @media only screen and (max-width: 300px) {
                .text {font-size: 11px}
            }
        </style>
    </head>
    <body>
        <div id="preloader">
            <div id="status">&nbsp;</div>
        </div>
        <a class="scrollToTop" href="#"><i class="fa fa-angle-up"></i></a>
        <div class="container">
            <div class="box_wrapper">
                <jsp:include page="HeaderBlog.jsp"></jsp:include>
                <div class="latest_newsarea"> <span>Latest News</span>
                    <ul id="ticker01" class="news_sticker">
                        <c:forEach items="${latestpostdetails}" var="lpd">
                            <li><a href="SingleNews?pid=${lpd.postId}">${lpd.postTitle}</a></li>
                            </c:forEach>
                    </ul>
                </div>
                <div class="thumbnail_slider_area">
                    <div class="owl-carousel">
                        <c:forEach items="${postdetails}" var="pd">
                            <div class="signle_iteam"> <img src="${pd.featuredimage}" alt="" style="height: 395px; width: 396px;">
                                <div class="sing_commentbox slider_comntbox">
                                    <p><i class="fa fa-calendar"></i>${pd.createdDate}</p>
                                    <i class="fa fa-comments"></i>${pd.views} Views
                                    <i class="fa fa-thumbs-up"></i>${pd.likes} Likes</div>
                                <a class="slider_tittle" href="SingleNews?pid=${pd.postId}">${pd.postTitle}</a></div></c:forEach>
                        </div>
                    </div>
                    <section id="contentbody">
                        <div class="row">
                            <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                                <div class="row">
                                    <div class="left_bar">
                                        <div class="single_leftbar">
                                            <h2><span>Gadgets</span></h2>
                                            <div class="singleleft_inner">
                                                <ul class="recentpost_nav wow fadeInDown">
                                                <c:forEach items="${postdetails}" var="pdtls">
                                                    <c:if test="${pdtls.categories=='Gadgets'}">
                                                        <li><a href="SingleNews?pid=${pdtls.postId}"><img src="${pdtls.featuredimage}" style="height: 80px; width: 150px" alt=""></a> <a class="recent_title" href="SingleNews?pid=${pdtls.postId}">${pdtls.postTitle}</a></li>
                                                            </c:if>
                                                        </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="single_leftbar wow fadeInDown">
                                        <h2><span>Side Add</span></h2>
                                        <div class="singleleft_inner"> <a href="#"><img src="assets/images/150x600.jpg" alt=""></a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-8 col-xs-12">
                            <div class="row">
                                <div class="middle_bar">
                                    <div class="slideshow-container">
                                        <c:forEach items="${latestpostdetails}" var="lpd">
                                            <div class="mySlides fade">
                                                <a href="SingleNews?pid=${lpd.postId}"><img src="${lpd.featuredimage}" style="height: 328px; width: 668px"></a>
                                                <div class="text"><a href="SingleNews?pid=${lpd.postId}">${lpd.postTitle}</a></div>
                                            </div>
                                        </c:forEach>
                                    </div>
                                    <br>

                                    <div style="text-align:center">
                                        <span class="dot"></span> 
                                        <span class="dot"></span> 
                                        <span class="dot"></span> 
                                        <span class="dot"></span> 
                                    </div>
                                    <div class="single_category wow fadeInDown">
                                        <div class="category_title"> <a href="pages/category-archive.html">Blogging</a></div>
                                        <div class="single_category_inner">
                                            <ul class="catg_nav">
                                                <c:forEach items="${postdetails}" var="pdtls">
                                                    <c:if test="${pdtls.categories=='Blogging'}">
                                                        <li>
                                                            <div class="catgimg_container"> <a class="catg1_img" href="SingleNews?pid=${pdtls.postId}"> <img src="${pdtls.featuredimage}" style="height: 150px; width: 310px" alt=""> </a></div>
                                                            <a class="catg_title" href="SingleNews?pid=${pdtls.postId}"> ${pdtls.postTitle}</a>
                                                            <div class="sing_commentbox">
                                                                <p><i class="fa fa-calendar"></i>${pdtls.createdDate}</p>
                                                                <i class="fa fa-comments"></i>${pdtls.views} Views
                                                                <i class="fa fa-thumbs-up"></i>${pdtls.likes} Likes</div>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="single_category  wow fadeInDown">
                                        <div class="category_title"> <a href="pages/category-archive.html">How Tos</a></div>
                                        <div class="single_category_inner">
                                            <ul class="catg_nav catg_nav2">
                                                <c:forEach items="${postdetails}" var="pdtls">
                                                    <c:if test="${pdtls.categories=='How Tos'}">
                                                        <li>
                                                            <div class="catgimg_container"> <a class="catg1_img" href="SingleNews?pid=${pdtls.postId}"> <img src="${pdtls.featuredimage}" style="height: 300px; width: 310px" alt=""> </a></div>
                                                            <a class="catg_title" href="SingleNews?pid=${pdtls.postId}"> ${pdtls.postTitle}</a>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="category_three_fourarea  wow fadeInDown">
                                        <div class="category_three">
                                            <div class="single_category">
                                                <div class="category_title"> <a href="pages/single_page.html">Mobile</a></div>
                                                <div class="single_category_inner">
                                                    <ul class="catg_nav catg_nav3">
                                                        <c:forEach items="${postdetails}" var="pdtls">
                                                            <c:if test="${pdtls.categories=='Mobile'}">
                                                                <li>
                                                                    <div class="catgimg_container"> <a class="catg1_img" href="SingleNews?pid=${pdtls.postId}"> <img src="${pdtls.featuredimage}" style="height: 150px; width: 292px" alt=""> </a></div>
                                                                    <a class="catg_title" href="SingleNews?pid=${pdtls.postId}"> ${pdtls.postTitle}</a>
                                                                </li>
                                                            </c:if>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                        <div class="category_four wow fadeInDown">
                                            <div class="single_category">
                                                <div class="category_title"> <a href="#">News</a></div>
                                                <div class="single_category_inner">
                                                    <ul class="catg_nav catg_nav3">
                                                        <c:forEach items="${postdetails}" var="pdtls">
                                                            <c:if test="${pdtls.categories=='News'}">
                                                                <li>
                                                                    <div class="catgimg_container"> <a class="catg1_img" href="SingleNews?pid=${pdtls.postId}"> <img src="${pdtls.featuredimage}" style="height: 150px; width: 292px;" alt=""> </a></div>
                                                                    <a class="catg_title" href="SingleNews?pid=${pdtls.postId}"> ${pdtls.postTitle}</a>
                                                                </li>
                                                            </c:if>
                                                        </c:forEach>
                                                    </ul>
                                                </div>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="single_category wow fadeInDown">
                                        <div class="category_title"> <a href="#">Make Money Online</a></div>
                                        <div class="single_category_inner">
                                            <ul class="catg3_snav catg5_nav">
                                                <c:forEach items="${postdetails}" var="pdtls">
                                                    <c:if test="${pdtls.categories=='Make money online'}">
                                                        <li>
                                                            <div class="media"> <a href="SingleNews?pid=${pdtls.postId}" class="media-left"> <img alt="" src="${pdtls.featuredimage}" style="height: 70px; width: 70px"> </a>
                                                                <div class="media-body"> <a href="SingleNews?pid=${pdtls.postId}" class="catg_title"> ${pdtls.postTitle}</a>
                                                                    <div class="sing_commentbox">
                                                                        <p><i class="fa fa-calendar"></i>${pdtls.createdDate}</p>
                                                                        <i class="fa fa-comments"></i>${pdtls.views} Views
                                                                        <i class="fa fa-thumbs-up"></i>${pdtls.likes} Likes</div>
                                                                </div>
                                                            </div>
                                                        </li>
                                                    </c:if>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-3 col-md-3 col-sm-12 col-xs-12">
                            <div class="row">
                                <div class="right_bar">
                                    <div class="single_leftbar wow fadeInDown">
                                        <h2><span>Popular Post</span></h2>
                                        <div class="singleleft_inner">
                                            <ul class="catg3_snav ppost_nav wow fadeInDown">
                                                <c:forEach items="${popularpost}" var="ppost">
                                                    <li>
                                                        <div class="media"> <a href="SingleNews?pid=${ppost.postId}" class="media-left"> <img alt="" src="${ppost.featuredimage}" style="height: 70px; width: 70px"> </a>
                                                            <div class="media-body"> <a href="SingleNews?pid=${ppost.postId}" class="catg_title"> ${ppost.postTitle}</a></div>
                                                        </div>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="single_leftbar wow fadeInDown">
                                        <h2><span>Side Ad</span></h2>
                                        <div class="singleleft_inner"> <a href="#"><img alt="" src="assets/images/262x218.jpg"></a></div>
                                    </div>
                                    <div class="single_leftbar wow fadeInDown">
                                        <ul class="nav nav-tabs custom-tabs" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Most Recents</a></li>
                                            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Most Liked</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <ul class="catg3_snav ppost_nav wow fadeInDown">
                                                    <c:forEach items="${latestpostdetails}" var="lpdtls">
                                                        <li>
                                                            <div class="media"> <a class="media-left" href="SingleNews?pid=${lpdtls.postId}"> <img src="${lpdtls.featuredimage}" style="height: 70px; width: 70px" alt=""> </a>
                                                                <div class="media-body"> <a class="catg_title" href="SingleNews?pid=${lpdtls.postId}"> ${lpdtls.postTitle}</a></div>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                            <div role="tabpanel" class="tab-pane fade" id="profile">
                                                <ul class="catg3_snav ppost_nav wow fadeInDown">
                                                    <c:forEach items="${latestpostdetails}" var="lpdtls">
                                                        <li>
                                                            <div class="media"> <a class="media-left" href="SingleNews?pid=${lpdtls.postId}"> <img src="${lpdtls.featuredimage}" style="height: 70px; width: 70px" alt=""> </a>
                                                                <div class="media-body"> <a class="catg_title" href="SingleNews?pid=${lpdtls.postId}"> ${lpdtls.postTitle}</a></div>
                                                            </div>
                                                        </li>
                                                    </c:forEach>
                                                </ul>
                                            </div>
                                        </div>
                                    </div>
                                    <div class="single_leftbar wow fadeInDown">
                                        <h2><span>Labels</span></h2>
                                        <div class="singleleft_inner">
                                            <ul class="label_nav">
                                                <li><a href="#">Arts</a></li>
                                                <li><a href="#">Cinema</a></li>
                                                <li><a href="#">Comedy</a></li>
                                                <li><a href="#">Sports</a></li>
                                                <li><a href="#">Tourism</a></li>
                                                <li><a href="#">Videos</a></li>
                                                <li><a href="#">Nature</a></li>
                                            </ul>
                                        </div>
                                    </div>
                                </div>
                            </div>
                        </div>
                    </div>
                </section>
                <jsp:include page="FooterBlog.jsp"></jsp:include>
            </div>
        </div>
        <script src="assets/js/jquery.min_2.js"></script>
        <script src="assets/js/wow.min_1.js"></script>
        <script src="assets/js/bootstrap.min_2.js"></script>
        <script src="assets/js/slick.min.js"></script>
        <script src="assets/js/jquery.li-scroller.1.0.js"></script>
        <script src="assets/js/custom_1.js"></script>
        <script>
            var slideIndex = 0;
            showSlides();

            function showSlides() {
                var i;
                var slides = document.getElementsByClassName("mySlides");
                var dots = document.getElementsByClassName("dot");
                for (i = 0; i < slides.length; i++) {
                    slides[i].style.display = "none";
                }
                slideIndex++;
                if (slideIndex > slides.length) {
                    slideIndex = 1
                }
                for (i = 0; i < dots.length; i++) {
                    dots[i].className = dots[i].className.replace(" active", "");
                }
                slides[slideIndex - 1].style.display = "block";
                dots[slideIndex - 1].className += " active";
                setTimeout(showSlides, 2000); // Change image every 2 seconds
            }
        </script>
        <script>
            $(document).ready(function () {
                 $("#submitsubscriber").click(function (event) {
                    var email = $("#email").val();
                    var data = 'email=' + encodeURIComponent(email);
                    alert(data);
                    $.ajax({
                        url: "subscriber",
                        type: "POST",
                        data: data,
                        async: false,
                        success: function (response) {
                            window.alert(response);
                        }
                    });
                });
            });
        </script>
        <!--        begin of code for searching news-->
        <script>
            $("#searchingtextfornews").keyup(function (event) {
                var searchtext = $("#searchingtextfornews").val();
                var data = 'searchvalue=' + encodeURIComponent(searchtext);
                var resultList = $("#newssearchvalues");
                var items=[];
                $.ajax({
                    url: "searchposts",
                    type: "POST",
                    data: data,
                    success: function (response) {
                       $.each(response, function(i,item){
                           items.push('<li><a href="SingleNews?pid=' + item.postId + '">' + item.postTitle + '</a></li>');
                       });
                       //$(resultList).append(items.join(''));
                       $(resultList).html(items.join(''));
                    }
                    
                });
//                $.post('searchposts',{searchvalue:searchtext},function(result){
//                    $.each(result, function(i,item){
//                           items.push('<li><a href="SingleNews?pid=' + item.postId + '">' + item.postTitle + '</a></li>');
//                       });
//                       $(resultList).append(items.join(''));
//                });
            });
        </script>
        <!--        end of code for searching news-->
    </body>
</html>
