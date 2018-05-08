<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<footer id="footer">
    <div class="footer_top">
        <div class="col-lg-3 col-md-3 col-sm-6">
            <div class="single_footer_top wow fadeInLeft">
                <h2>Follow By Email</h2>
                <div class="subscribe_area">
                    <p>"Subscribe here to get our newsletter, it is safe just Put your Email and click subscribe"</p>
                    <form action="#">
                        <div class="subscribe_mail">
                            <input class="form-control" id="email" type="email" placeholder="Email Address">
                            <i class="fa fa-envelope"></i></div>
                        <input class="submit_btn" id="submitsubscriber" type="submit" value="Subscribe">
                    </form>
                </div>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6">
            <div class="single_footer_top wow fadeInLeft">
                <h2>Popular Post</h2>
                <ul class="catg3_snav ppost_nav">
                    <c:forEach items="${popularpost}" var="ppost">
                    <li>
                        <div class="media"> <a class="media-left" href="SingleNews?pid=${ppost.postId}"> <img src="${ppost.featuredimage}" style="height: 70px; width: 70px;" alt=""> </a>
                            <div class="media-body"> <a class="catg_title" href="SingleNews?pid=${ppost.postId}"> ${ppost.postTitle}</a></div>
                        </div>
                    </li>
                    </c:forEach>
                </ul>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6">
            <div class="single_footer_top wow fadeInRight">
                <h2>Tags</h2>
                <ul class="footer_labels">
                    <li><a href="#">Comedy</a></li>
                    <li><a href="#">Arts</a></li>
                    <li><a href="#">Cinema</a></li>
                    <li><a href="#">Nature</a></li>
                    <li><a href="#">Sports</a></li>
                    <li><a href="#">Tourism</a></li>
                    <li><a href="#">Videos</a></li>
                </ul>
            </div>
        </div>
        <div class="col-lg-3 col-md-3 col-sm-6">
            <div class="single_footer_top wow fadeInRight">
                <h2>Contact Form</h2>
                <form action="#" class="contact_form">
                    <label>Name</label>
                    <input class="form-control" type="text">
                    <label>Email*</label>
                    <input class="form-control" type="email">
                    <label>Subject*</label>
                    <input class="form-control" type="subject">
                    <label>Message*</label>
                    <textarea class="form-control" cols="30" rows="10"></textarea>
                    <input class="send_btn" type="submit" value="Send">
                </form>
            </div>
        </div>
    </div>
    <div class="footer_bottom">
        <div class="footer_bottom_left">
            <p>Copyright &copy; 2045</p>
        </div>
    </div>
</footer>
