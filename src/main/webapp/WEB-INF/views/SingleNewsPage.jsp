<%-- 
    Document   : SingleNewsPage
    Created on : Jan 22, 2017, 9:48:35 PM
    Author     : myhp
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <title>Urban Nepal | Single Blog</title>
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
        <script src="../assets/js/html5shiv.min.js"></script>
        <script src="../assets/js/respond.min.js"></script>
        <![endif]-->

        <!--        begin of code for comments-->
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
        <!--        end of code for comments-->
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
                <section id="contentbody">
                    <div class="row">
                        <div class="col-lg-2 col-md-2 col-sm-4 col-xs-12">
                            <div class="row">
                                <div class="left_bar">
                                    <div class="single_leftbar">
                                        <h2><span>Recent Post</span></h2>
                                        <div class="singleleft_inner">
                                            <ul class="recentpost_nav wow fadeInDown">
                                                <c:forEach items="${latestpostdetails}" var="lpd">
                                                    <li><a href="SingleNews?pid=${lpd.postId}"><img src="${lpd.featuredimage}" style="height: 80px; width: 150px" alt=""></a> <a class="recent_title" href="SingleNews?pid=${lpd.postId}"> ${lpd.postTitle}</a></li>
                                                        </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="single_leftbar wow fadeInDown">
                                        <h2><span>Side Add</span></h2>
                                        <div class="singleleft_inner"> <a href="#"><img src="../assets/images/150x600.jpg" alt=""></a></div>
                                    </div>
                                </div>
                            </div>
                        </div>
                        <div class="col-lg-7 col-md-7 col-sm-8 col-xs-12">
                            <div class="row">
                                <div class="middle_bar">
                                    <div class="single_post_area">
                                        <c:forEach items="${singlepostdetails}" var="pd">
                                            <ol class="breadcrumb">
                                                <li><a href="#"><i class="fa fa-home"></i>Home<i class="fa fa-angle-right"></i></a></li>
                                                <li><a href="#">Category<i class="fa fa-angle-right"></i></a></li>
                                                <li class="active">${pd.categories}</li>
                                            </ol>
                                            <h2 class="post_title wow ">${pd.postTitle}</h2>
                                            <i class="fa fa-user"></i>${pd.owner}<i class="fa fa-clock-o"></i>${pd.createdDate}
                                            <div class="single_post_content">
                                                <img src="${pd.featuredimage}" alt="Featured Image" <br/><br/>
                                                ${pd.description}
                                            </div>
                                            <div class="social_area wow fadeInLeft">
                                                <h2><strong>Share on:</strong></h2>
                                                <ul>
                                                    <li><a href="https://www.facebook.com/sharer.php?u=${pageContext.request.requestURL}?${pageContext.request.queryString}" onclick="window.open(this.href, 'mywin', 'left=50,top=50,width=600,height=350,toolbar=0');
                                                                        return false;" data-slimstat-clicked="false" data-slimstat-type="0" data-slimstat-tracking="true" data-slimstat-callback="true"><span class="fa fa-facebook"></span></a></li>
                                                    <li><a href="https://twitter.com/intent/tweet?text=${pageContext.request.queryString}&url=${pageContext.request.requestURL}?${pageContext.request.queryString}&via=${pageContext.request.requestURL}" data-slimstat-clicked="false" data-slimstat-type="0" data-slimstat-tracking="true" data-slimstat-callback="true"><span class="fa fa-twitter"></span></a></li>
                                                    <li><a href="https://plus.google.com/share?url=${pageContext.request.requestURL}?${pageContext.request.queryString}" onclick="javascript:window.open(this.href,
                                                                        '', 'menubar=no,toolbar=no,resizable=yes,scrollbars=yes,height=600,width=600');
                                                                        return false;"><span class="fa fa-google-plus"></span></a></li>
                                                    <li><a href="http://pinterest.com/pin/create/button/?url=${pageContext.request.requestURL}?${pageContext.request.queryString}" onclick="window.open(this.href, 'mywin', 'left=50,top=50,width=600,height=350,toolbar=0');
                                                                        return false;" data-slimstat-clicked="false" data-slimstat-type="0" data-slimstat-tracking="true" data-slimstat-callback="true"><span class="fa fa-pinterest"></span></a></li>
                                                    <li>
                                                        <a title="SumoMe" class="sumome-share-client-animated sumome-share-client-share" data-sumome-share="sumome" href="javascript:void(0);" data-slimstat-clicked="false" data-slimstat-type="2" data-slimstat-tracking="false" data-slimstat-callback="false" style="background: rgb(15, 82, 186); color: rgb(255, 255, 255);">
                                                            <img src="//sumome-140a.kxcdn.com/static/a553b90bc1c6b02c17001fd50ddffcc23a71de5e…t/images/apps/9e8a4d2a-6f8c-415e-851b-bdfe4c01d5c1/sumome-white-60.png" alt="SumoMe" data-pin-nopin="true">
                                                        </a>
                                                    </li>
                                                </ul>
                                            </div>
                                            <input id="pid" type="hidden" value="${pd.postId}">
                                            <input id="views" type="hidden" value="${pd.views}">
                                            <input id="likes" type="hidden" value="${pd.likes}">
                                        </c:forEach>
                                        <div >
                                            <h4>Recent Comments2</h4>
                                            <ul class="messages" id="commentResults">
                                            </ul>
                                        </div>    
                                        <div class="social_area wow fadeInLeft">
                                            <div class="col-md-9 col-sm-9 col-xs-12">
                                                <div class="col-md-9 col-sm-9 col-xs-12">
                                                    <input type="text" id="maincomment" name="comments" placeholder="Leave a reply" />
                                                </div>
                                            </div>
                                            <input id="maincmtbtn" class="send_btn" type="submit" value="Submit">
                                        </div>
                                        <div class="post_footer">
                                            <ul class="post_pager">
                                                <c:forEach items="${previouspostdetails}" var="ppdetails">
                                                    <li class="previous wow fadeInLeftBig"> <a href="SingleNews?pid=${ppdetails.postId}">
                                                            <p><i class="fa fa-hand-o-left"></i><strong>Previous</strong></p>
                                                            <span>${ppdetails.postTitle}</span> </a></li>
                                                        </c:forEach>  
                                                        <c:forEach items="${nextpostdetails}" var="npd">
                                                    <li class="next wow fadeInRightBig"> <a href="SingleNews?pid=${npd.postId}">
                                                            <p><i class="fa fa-hand-o-right"></i><strong>Next</strong></p>
                                                            <span>${npd.postTitle}</span> </a></li>
                                                        </c:forEach>
                                            </ul>
                                        </div>
                                        <div class="related_post">
                                            <h2 class="wow fadeInLeftBig">Related Posts you may like <i class="fa fa-thumbs-o-up"></i></h2>
                                            <ul class="recentpost_nav relatedpost_nav wow fadeInDown animated">
                                                <c:forEach items="${relatedpostdetails}" var="rpd">
                                                    <li><a href="SingleNews?pid=${rpd.postId}"><img alt="" src="${rpd.featuredimage}" style="height: 80px; width: 150px"></a> <a href="SingleNews?pid=${rpd.postId}" class="recent_title"> ${rpd.postTitle}</a></li>
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
                                                <c:forEach items="${postdetails}" var="pdtls">
                                                    <li>
                                                        <div class="media"> <a href="SingleNews?pid=${pdtls.postId}" class="media-left"> <img alt="" src="${pdtls.featuredimage}" style="height: 70px; width: 70px"> </a>
                                                            <div class="media-body"> <a href="SingleNews?pid=${pdtls.postId}" class="catg_title"> ${pdtls.postTitle}</a></div>
                                                        </div>
                                                    </li>
                                                </c:forEach>
                                            </ul>
                                        </div>
                                    </div>
                                    <div class="single_leftbar wow fadeInDown">
                                        <h2><span>Side Ad</span></h2>
                                        <div class="singleleft_inner"> <a href="#"><img alt="" src="../assets/images/262x218.jpg"></a></div>
                                    </div>
                                    <div class="single_leftbar wow fadeInDown">
                                        <ul class="nav nav-tabs custom-tabs" role="tablist">
                                            <li role="presentation" class="active"><a href="#home" aria-controls="home" role="tab" data-toggle="tab">Most Popular</a></li>
                                            <li role="presentation"><a href="#profile" aria-controls="profile" role="tab" data-toggle="tab">Most Liked</a></li>
                                        </ul>
                                        <div class="tab-content">
                                            <div role="tabpanel" class="tab-pane fade in active" id="home">
                                                <ul class="catg3_snav ppost_nav wow fadeInDown">
                                                    <c:forEach items="${popularpost}" var="lpdtls">
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
                                                                $(document).ready(function () {

                                                        var postId = $("#pid").val();
                                                                var views = $("#views").val();
                                                                var data = 'postId=' + encodeURIComponent(postId)
                                                                + '&views=' + encodeURIComponent(views);
                                                                $.ajax({
                                                                url: "updateViews",
                                                                        type: "POST",
                                                                        data: data,
                                                                        async: false,
                                                                        success: function (response) {
                                                                        console.log(response);
                                                                        }
                                                                });
                                                                var items = [];
                                                                var cmtId = [];
                                                                $.ajax({
                                                                url: "displayMainComments",
                                                                        type: "POST",
                                                                        data: data,
                                                                        success: function (response) {
                                                                        var div = $("#commentResults");
                                                                                $.each(response, function (i, item) {
                                                                                finalId = i + 1;
                                                                                        items.push('<li><h5>' + item.commentBy + '</h5>\n\
                                                                                    <input type="hidden" class="maincmtId" value=' + item.commentId + ' id=cmti' + finalId + ' readonly/>\n\
                                                                                    <p>' + item.comment + '</p>\n\
                                                                                    <button class="reply" id=' + finalId + '>Reply</button>\n\
                                                                                                  <div style="margin-left: 30px" id=' + finalId + '>\n\
                                                                                                        <div id="repliesofcomments">hlooo everyone...</div>\n\
                                                                                                        <div class="firstHC" id=' + finalId + ' >\n\
                                                                                                           <input type="text" id=rcmt' + finalId + ' />\n\
                                                                                                           <input type="Submit" value="Submit1" class="submitFirstReply" id=' + finalId + ' />\n\
                                                                                                        </div>\n\
                                                                                                        </div></li>');
                                                                                                cmtId.push(item.commentId);
                                                                                                var rcid=("#cmti"+finalId).val();
                                                                                                var pid = $("#pid").val();
                                                                                                var dt = 'postId=' + encodeURIComponent(pid)
                                                                                                + '&cmtId=' + encodeURIComponent(cmtId);
                                                                                                var replycmts = [];
                                                                                                $.ajax({
                                                                                                url: "displayReplyComments",
                                                                                                        type: "POST",
                                                                                                        data: dt,
                                                                                                        success: function (results) {
                                                                                                        console.log(results);
                                                                                                        $.each(results, function(i, res){
                                                                                                        replycmts.push(res.comment);
                                                                                                        });
                                                                                                                $("#repliesofcomments").append(replycmts.join(''));
                                                                                                        }
                                                                                                });
                                                                                                //end of replies comments
                                                                                });
                                                                                
                                                                                //$(resultList).append(items.join(''));
                                                                                $(div).html(items.join(''));
                                                                                $(".firstHC").hide();
                                                                                //begin of code for showing comenting area when clicked on reply button
                                                                                var clickedButtonId = "";
                                                                                $(".reply").click(function (e) {
                                                                        clickedButtonId = e.target.id;
                                                                                alert(clickedButtonId);
                                                                                $(this).hide();
                                                                                $("div[id=" + clickedButtonId + "]").show();
                                                                        });
                                                                                //end of code for showing comenting area when clicked on reply button
                                                                                //begin of saving first level of reply to main comments
                                                                                var clickedSubmitButtonForFirstReply = "";
                                                                                 $(".submitFirstReply").click(function (e) {
                                                                        clickedSubmitButtonForFirstReply = e.target.id;
                                                                                alert(clickedSubmitButtonForFirstReply);
                                                                                var commentId = $("#cmti" + clickedSubmitButtonForFirstReply).val();
                                                                                var postId = $("#pid").val();
                                                                                var firstReply = $("#rcmt" + clickedSubmitButtonForFirstReply).val();
                                                                                var data = 'commentId=' + encodeURIComponent(commentId)
                                                                                + '&postId=' + encodeURIComponent(postId)
                                                                                + '&firstRely=' + encodeURIComponent(firstReply);
                                                                                alert(data);
                                                                                $.ajax({
                                                                                url: "savefirstreplycomment",
                                                                                        type: "POST",
                                                                                        data: data,
                                                                                        success: function (response) {
                                                                                        window.alert(response);
                                                                                        }
                                                                                });
                                                                        });
                                                                                //end of saving first level of reply to main comments
                                                                        }
                                                                });
                                                                $(".firstHC").hide();
                                                        });        </script>
        <!--        begin of code for hiding and showing comment input fields by using clicked button's id-->
        <script>
                    var clickedButtonId = "";
                    $(".reply").click(function (e) {
            clickedButtonId = e.target.id;
                    alert(clickedButtonId);
                    $(this).hide();
                    $("div[id=" + clickedButtonId + "]").show();
            });        </script>
        <!--        end of code for hiding and showing comment input fields-->
        <!--        begin of code for saving subscriber-->
        <script>
                     $("#submitsubscriber").click(function (event) {
            var email = $("#email").val();
                    var data = 'email=' + encodeURIComponent(email);
                    $.ajax({
                    url: "subscriber",
                            type: "POST",
                            data: data,
                            async: false,
                            success: function (response) {
                            window.alert(response);
                            }
                    });
            });        </script>
        <!--        end of code for saving subscriber-->
        <!--        begin of code for saving main comments-->
        <script>
                     $("#maincmtbtn").click(function (event) {
            var comment = $("#maincomment").val();
                    var postId = $("#pid").val();
                    var data = 'comment=' + encodeURIComponent(comment)
                    + '&postId=' + encodeURIComponent(postId);
                    alert(data);
                    $.ajax({
                    url: "savemaincomment",
                            type: "POST",
                            data: data,
                            success: function (response) {
                            window.alert(response);
                            }
                    });
            });        </script>
        <!--        end of code for saving main comments-->
        <!--        begin of code for saving first reply for comments-->
        <script>
                    var clickedSubmitButtonForFirstReply = "";
                     $(".submitFirstReply").click(function (e) {
            clickedSubmitButtonForFirstReply = e.target.id;
                    alert(clickedSubmitButtonForFirstReply);
                    var commentId = $("#cmti" + clickedSubmitButtonForFirstReply).val();
                    var postId = $("#pid").val();
                    var firstReply = $("#rcmt" + clickedSubmitButtonForFirstReply).val();
                    var data = 'commentId=' + encodeURIComponent(commentId)
                    + '&postId=' + encodeURIComponent(postId)
                    + '&firstRely=' + encodeURIComponent(firstReply);
                    alert(data);
                    $.ajax({
                    url: "savefirstreplycomment",
                            type: "POST",
                            data: data,
                            success: function (response) {
                            window.alert(response);
                            }
                    });
            });        </script>
        <!--        end of code for saving first reply for comments-->
        <!--        begin of code for searching news-->
        <script>
                    $("#searchingtextfornews").keyup(function (event) {
            var searchtext = $("#searchingtextfornews").val();
                    var data = 'searchvalue=' + encodeURIComponent(searchtext);
                    var resultList = $("#newssearchvalues");
                    var items = [];
                    $.ajax({
                    url: "searchposts",
                            type: "POST",
                            data: data,
                            success: function (response) {
                            $.each(response, function (i, item) {
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
