<%-- 
    Document   : LeftSideMenusBar
    Created on : Jan 2, 2017, 10:54:57 AM
    Author     : myhp
--%>

<div class="col-md-3 left_col">
    <div class="left_col scroll-view">

        <div class="navbar nav_title" style="border: 0;">
            <a href="index.html" class="site_title"><i class="fa fa-paw"></i> <span>Go to Index Page</span></a>
        </div>
        <div class="clearfix"></div>

        <!--                    menu prile quick info -->
        <div class="profile">
            <div class="profile_pic">
                <img src="assets/images/img.jpg" alt="..." class="img-circle profile_img">
            </div>
            <div class="profile_info">
                <span>Welcome,</span>
                <h2>Anthony Fernando</h2>
            </div>
        </div>
        <div class="clearfix"></div>
        <!--                    menu prile quick info -->

        <br />

        <!-- sidebar menu -->
        <div id="sidebar-menu" class="main_menu_side hidden-print main_menu">

            <div class="menu_section">
                <ul class="nav side-menu">
                    <li><a><i class="fa fa-home"></i> Posts <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="displayposts">All Posts</a>
                            </li>
                            <li><a href="addpost">Add New</a>
                            </li>
                            <li><a href="pcategories">Categories</a>
                            </li>
                            <li><a href="ptags">Tags</a>
                            </li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-edit"></i> Media<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="displaymedialibrary">Media Library</a>
                            </li>
                            <li><a href="addmedia">Add New</a>
                            </li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-desktop"></i> Pages<span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="displaypages">All Pages</a>
                            </li>
                            <li><a href="addpage">Add New</a>
                            </li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-table"></i> SP Contacts <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="displaycontacts">All Contacts</a>
                            </li>
                            <li><a href="addcontact">Add New</a>
                            </li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-bar-chart-o"></i> Services <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="displayservices">All Services</a>
                            </li>
                            <li><a href="addservice">Add New Service</a>
                            </li>
                            <li><a href="scategories">Categories</a>
                            </li>
                            <li><a href="stags">Tags </a>
                            </li>
                        </ul>
                    </li>
                    <li><a><i class="fa fa-bug"></i> Users <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="displayusers">All Users</a>
                            </li>
                            <li><a href="adduser">Add New</a>
                            </li>
                        </ul>
                    </li>
                    <li><a href="userprofile"><i class="fa fa-user"></i>Profile</a>
                    </li>
                    <li><a><i class="fa fa-windows"></i> Email <span class="fa fa-chevron-down"></span></a>
                        <ul class="nav child_menu" style="display: none">
                            <li><a href="displayemails">All Email</a>
                            </li>
                            <li><a href="addemail">Add New Email</a>
                            </li>
                        </ul>
                    </li>
                </ul>
            </div>
        </div>
        <!-- /sidebar menu -->

        <!-- /menu footer buttons -->
        <div class="sidebar-footer hidden-small">
            <a data-toggle="tooltip" data-placement="top" title="Settings">
                <span class="glyphicon glyphicon-cog" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="FullScreen">
                <span class="glyphicon glyphicon-fullscreen" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Lock">
                <span class="glyphicon glyphicon-eye-close" aria-hidden="true"></span>
            </a>
            <a data-toggle="tooltip" data-placement="top" title="Logout">
                <span class="glyphicon glyphicon-off" aria-hidden="true"></span>
            </a>
        </div>
        <!-- /menu footer buttons -->
    </div>
</div>
