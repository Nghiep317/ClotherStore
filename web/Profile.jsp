<%-- 
    Document   : Profile
    Created on : Jun 7, 2024, 1:40:03 PM
    Author     : thien
--%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8" />
        <meta http-equiv="X-UA-Compatible" content="IE=edge" />
        <meta name="viewport" content="width=device-width, initial-scale=1" />

        <link rel="icon" href="img/fav-icon.png" type="image/x-icon" />
        <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
        <title>Persuit</title>

        <!-- Icon css link -->
        <link href="css/font-awesome.min.css" rel="stylesheet" />
        <link href="vendors/line-icon/css/simple-line-icons.css" rel="stylesheet" />
        <link href="vendors/elegant-icon/style.css" rel="stylesheet" />
        <!-- Bootstrap -->
        <link href="css/bootstrap.min.css" rel="stylesheet" />

        <!-- Rev slider css -->
        <link href="vendors/revolution/css/settings.css" rel="stylesheet" />
        <link href="vendors/revolution/css/layers.css" rel="stylesheet" />
        <link href="vendors/revolution/css/navigation.css" rel="stylesheet" />

        <!-- Extra plugin css -->
        <link href="vendors/owl-carousel/owl.carousel.min.css" rel="stylesheet" />
        <link
            href="vendors/bootstrap-selector/css/bootstrap-select.min.css"
            rel="stylesheet"
            />
        <link href="vendors/jquery-ui/jquery-ui.css" rel="stylesheet" />

        <link href="css/style.css" rel="stylesheet" />
        <link href="css/responsive.css" rel="stylesheet" />

        <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
          <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
          <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
        <![endif]-->
    </head>
    <body>
        <!--================Menu Area =================-->
        <header class="shop_header_area carousel_menu_area">
            <div class="carousel_top_header row m0">
                <div class="container">
                    <div class="carousel_top_h_inner">
                        <div class="float-md-left">
                            <div class="top_header_left">
                                <div class="selector">
                                    <select
                                        class="language_drop"
                                        name="countries"
                                        id="countries"
                                        style="width: 300px"
                                        >
                                        <option
                                            value="yt"
                                            data-image="img/icon/flag-1.png"
                                            data-imagecss="flag yt"
                                            data-title="English"
                                            >
                                            English
                                        </option>
                                        <option
                                            value="yu"
                                            data-image="img/icon/flag-1.png"
                                            data-imagecss="flag yu"
                                            data-title="Bangladesh"
                                            >
                                            Bangla
                                        </option>
                                        <option
                                            value="yt"
                                            data-image="img/icon/flag-1.png"
                                            data-imagecss="flag yt"
                                            data-title="English"
                                            >
                                            English
                                        </option>
                                        <option
                                            value="yu"
                                            data-image="img/icon/flag-1.png"
                                            data-imagecss="flag yu"
                                            data-title="Bangladesh"
                                            >
                                            Bangla
                                        </option>
                                    </select>
                                </div>
                                <select class="selectpicker usd_select">
                                    <option>USD</option>
                                    <option>$</option>
                                    <option>$</option>
                                </select>
                            </div>
                        </div>
                        <div class="float-md-right">
                            <div class="top_header_middle">
                                <a href="#"
                                   ><i class="fa fa-phone"></i> Call Us:
                                    <span>+84 987 654 321</span></a
                                >
                                <a href="#"
                                   ><i class="fa fa-envelope"></i> Email:
                                    <span>support@yourdomain.com</span></a
                                >
                            </div>
                        </div>
                    </div>
                </div>
            </div>
            <div class="carousel_menu_inner">
                <div class="container">
                    <nav class="navbar navbar-expand-lg navbar-light bg-light">
                        <a class="navbar-brand" href="#"
                           ><img src="img/logo.png" alt=""
                              /></a>
                        <button
                            class="navbar-toggler"
                            type="button"
                            data-toggle="collapse"
                            data-target="#navbarSupportedContent"
                            aria-controls="navbarSupportedContent"
                            aria-expanded="false"
                            aria-label="Toggle navigation"
                            >
                            <span class="navbar-toggler-icon"></span>
                        </button>

                        <div class="collapse navbar-collapse" id="navbarSupportedContent">
                            <ul class="navbar-nav mr-auto">
                                <li class="nav-item dropdown submenu">
                                    <a
                                        class="nav-link dropdown-toggle"
                                        href="#"
                                        role="button"
                                        data-toggle="dropdown"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                        >
                                        Home <i class="fa fa-angle-down" aria-hidden="true"></i>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item">
                                            <a class="nav-link" href="index.html">Home Simple</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="home-carousel.html"
                                               >Home Carousel</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="home-fullwidth.html"
                                               >Home Full Width</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="home-parallax.html"
                                               >Home Parallax</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="home-sidebar.html"
                                               >Home Boxed</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="home-fixed-menu.html"
                                               >Home Fixed</a
                                            >
                                        </li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown submenu active">
                                    <a
                                        class="nav-link dropdown-toggle"
                                        href="#"
                                        role="button"
                                        data-toggle="dropdown"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                        >
                                        Pages <i class="fa fa-angle-down" aria-hidden="true"></i>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item">
                                            <a class="nav-link" href="compare.html">Compare</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="checkout.html"
                                               >Checkout Method</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="register.html"
                                               >Checkout Register</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="track.html">Track</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="login.html">Login</a>
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="404.html">404</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="nav-item dropdown submenu">
                                    <a
                                        class="nav-link dropdown-toggle"
                                        href="#"
                                        role="button"
                                        data-toggle="dropdown"
                                        aria-haspopup="true"
                                        aria-expanded="false"
                                        >
                                        Shop <i class="fa fa-angle-down" aria-hidden="true"></i>
                                    </a>
                                    <ul class="dropdown-menu">
                                        <li class="nav-item">
                                            <a
                                                class="nav-link"
                                                href="categories-no-sidebar-2column.html"
                                                >Prodcut No Sidebar</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a
                                                class="nav-link"
                                                href="categories-no-sidebar-3column.html"
                                                >Prodcut Two Column</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a
                                                class="nav-link"
                                                href="categories-no-sidebar-4column.html"
                                                >Product Grid</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="categories-left-sidebar.html"
                                               >Categories Left Sidebar</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="categories-right-sidebar.html"
                                               >Categories Right Sidebar</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a
                                                class="nav-link"
                                                href="categories-grid-left-sidebar.html"
                                                >Categories Grid Sidebar</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="product-details.html"
                                               >Prodcut Details 01</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="product-details2.html"
                                               >Prodcut Details 02</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="product-details3.html"
                                               >Prodcut Details 03</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="shopping-cart.html"
                                               >Shopping Cart 01</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="shopping-cart2.html"
                                               >Shopping Cart 02</a
                                            >
                                        </li>
                                        <li class="nav-item">
                                            <a class="nav-link" href="empty-cart.html">Empty Cart</a>
                                        </li>
                                    </ul>
                                </li>
                                <li class="nav-item"><a class="nav-link" href="#">Blog</a></li>
                                <li class="nav-item">
                                    <a class="nav-link" href="#">lookbook</a>
                                </li>
                                <li class="nav-item">
                                    <a class="nav-link" href="contact.html">Contact</a>
                                </li>
                            </ul>
                            <ul class="navbar-nav justify-content-end">
                                <li class="search_icon">
                                    <a href="#"><i class="icon-magnifier icons"></i></a>
                                </li>
                                <c:if test="${AccSession != null}">
                                    <a href="#" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="icon-user icons"></i> 
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="userDropdown">
                                        <a class="dropdown-item" href="#">Welcome ${AccSession.username}</a>
                                        <a class="dropdown-item" href="ProfileController?accountID=${AccSession.user_id}">Profile</a>
                                        <a class="dropdown-item" href="LogOut">Log Out</a>
                                    </div>
                                </c:if>
                                <c:if test="${AccSession == null}">
                                    <a href="#" id="userDropdown" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                        <i class="icon-user icons"></i>
                                    </a>
                                    <div class="dropdown-menu" aria-labelledby="userDropdown">
                                        <a class="dropdown-item" href="Login.jsp">Login</a>
                                        <a class="dropdown-item" href="Register.jsp">Register</a>
                                    </div>
                                </c:if>
                            </ul>
                        </div>
                    </nav>
                </div>
            </div>
        </header>
        <!--================End Menu Area =================-->

        <!--================Categories Banner Area =================-->
        <section class="solid_banner_area">
            <div class="container">
                <div class="solid_banner_inner">
                    <h3>Profile</h3>
                    <ul>
                        <li>
                            <a href="index.html"><strong>Home</strong></a>
                            <span>>Profile</span>
                        </li>
                    </ul>
                </div>
            </div>
        </section>
        <!--================End Categories Banner Area =================-->

        <section class="checkout_method_area p_100">
            <div class="container">
                <div class="row">
                    <div class="col-md-4">
                        <div class="card">
                            <div class="card-body text-center ">
                                <img
                                    src="./img/avata.png"
                                    class="rounded-circle mb-3 w-25"
                                    alt="User Profile Picture"
                                    />
                                <h4 class="card-title">${AccSession.username}</h4>
                                <p class="card-text">${AccSession.email}</p>
                                <button class="btn btn-primary btn-block" onclick="window.location.href = 'UpdateProfile'">
                                    Update Profile
                                </button>
                                <button class="btn btn-secondary btn-block" onclick="window.location.href = 'Logout'">
                                    Logout
                                </button>
                                <button class="btn btn-secondary btn-block" onclick="deleteUser(${AccSession.user_id})">
                                    Delete
                                </button>
                            </div>
                        </div>
                    </div>
                    <div class="col-md-8">
                        <div class="card">
                            <div class="card-header">Profile Details</div>
                            <div class="card-body">
                                <c:if test="${AccSession != null}">
                                    <form action="UpdateProfile" method="POST">
                                        <input
                                            type="hidden"
                                            class="form-control"
                                            id="id"
                                            name="userid"
                                            value="${AccSession.user_id}"
                                            />
                                        <div class="form-group row">
                                            <label for="name" class="col-sm-3 col-form-label">Name</label>
                                            <div class="col-sm-9">
                                                <input
                                                    type="text"
                                                    class="form-control"
                                                    id="name"
                                                    name="username"
                                                    value="${AccSession.username}"
                                                    />
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="email" class="col-sm-3 col-form-label">Email</label>
                                            <div class="col-sm-9">
                                                <input
                                                    readonly="true"
                                                    type="email"
                                                    class="form-control"
                                                    id="email"
                                                    name="email"
                                                    value="${AccSession.email}"
                                                    />
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="password" class="col-sm-3 col-form-label">Password</label>
                                            <div class="col-sm-9">
                                                <input
                                                    type="password"
                                                    class="form-control"
                                                    id="password"
                                                    name="password"
                                                    placeholder="Enter new password"
                                                    />
                                            </div>
                                        </div>
                                        <div class="form-group row">
                                            <label for="confirm-password" class="col-sm-3 col-form-label">Confirm Password</label>
                                            <div class="col-sm-9">
                                                <input
                                                    type="password"
                                                    class="form-control"
                                                    id="confirm-password"
                                                    name="confirm-password"
                                                    placeholder="Confirm new password"
                                                    />
                                            </div>
                                        </div>
                                        <button type="submit" class="btn btn-success btn-block">
                                            Save Changes
                                        </button>
                                    </form>
                                </c:if>
                                <c:if test="${AccSession == null}">
                                    <p>User not found.</p>
                                </c:if>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </section>

        <script>
            function deleteUser(userId) {
                if (confirm("Are you sure you want to delete this user?")) {
                    window.location.href = "DeleteProfile?userID=" + userId;
                }
            }
        </script>

        <script type="text/javascript">
            // Hàm để tự đóng thông báo sau một khoảng thời gian
            function closeAlert() {
                // Lấy tất cả các thành phần có class là 'alert'
                var alerts = document.getElementsByClassName('alert');

                // Duyệt qua từng thông báo
                for (var i = 0; i < alerts.length; i++) {
                    // Đóng thông báo sau 3 giây
                    setTimeout(function () {
                        alerts[i].style.display = 'none';
                    }, 3000);
                }
            }

            // Gọi hàm tự đóng khi trang được tải
            window.onload = closeAlert;
        </script>

        <!--================End Categories Banner Area =================-->

        <!--================Footer Area =================-->
        <footer class="footer_area">
            <div class="container">
                <div class="footer_widgets">
                    <div class="row">
                        <div class="col-lg-4 col-md-4 col-6">
                            <aside class="f_widget f_about_widget">
                                <img src="img/logo.png" alt="" />
                                <p>
                                    Persuit is a Premium PSD Template. Best choice for your online
                                    store. Let purchase it to enjoy now
                                </p>
                                <h6>Social:</h6>
                                <ul>
                                    <li>
                                        <a href="#"><i class="social_facebook"></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="social_twitter"></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="social_pinterest"></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="social_instagram"></i></a>
                                    </li>
                                    <li>
                                        <a href="#"><i class="social_youtube"></i></a>
                                    </li>
                                </ul>
                            </aside>
                        </div>
                        <div class="col-lg-2 col-md-4 col-6">
                            <aside class="f_widget link_widget f_info_widget">
                                <div class="f_w_title">
                                    <h3>Information</h3>
                                </div>
                                <ul>
                                    <li><a href="#">About us</a></li>
                                    <li><a href="#">Delivery information</a></li>
                                    <li><a href="#">Terms & Conditions</a></li>
                                    <li><a href="#">Help Center</a></li>
                                    <li><a href="#">Returns & Refunds</a></li>
                                </ul>
                            </aside>
                        </div>
                        <div class="col-lg-2 col-md-4 col-6">
                            <aside class="f_widget link_widget f_service_widget">
                                <div class="f_w_title">
                                    <h3>Customer Service</h3>
                                </div>
                                <ul>
                                    <li><a href="#">My account</a></li>
                                    <li><a href="#">Ordr History</a></li>
                                    <li><a href="#">Wish List</a></li>
                                    <li><a href="#">Newsletter</a></li>
                                    <li><a href="#">Contact Us</a></li>
                                </ul>
                            </aside>
                        </div>
                        <div class="col-lg-2 col-md-4 col-6">
                            <aside class="f_widget link_widget f_extra_widget">
                                <div class="f_w_title">
                                    <h3>Extras</h3>
                                </div>
                                <ul>
                                    <li><a href="#">Brands</a></li>
                                    <li><a href="#">Gift Vouchers</a></li>
                                    <li><a href="#">Affiliates</a></li>
                                    <li><a href="#">Specials</a></li>
                                </ul>
                            </aside>
                        </div>
                        <div class="col-lg-2 col-md-4 col-6">
                            <aside class="f_widget link_widget f_account_widget">
                                <div class="f_w_title">
                                    <h3>My Account</h3>
                                </div>
                                <ul>
                                    <li><a href="#">My account</a></li>
                                    <li><a href="#">Ordr History</a></li>
                                    <li><a href="#">Wish List</a></li>
                                    <li><a href="#">Newsletter</a></li>
                                </ul>
                            </aside>
                        </div>
                    </div>
                </div>
                <div class="footer_copyright">
                    <h5>
                        ©
                        <script>
                            document.write(new Date().getFullYear());
                        </script>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                        Copyright &copy;
                        <script>
                            document.write(new Date().getFullYear());
                        </script>
                        All rights reserved | This template is made with
                        <i class="fa fa-heart-o" aria-hidden="true"></i> by
                        <a href="https://colorlib.com" target="_blank">Colorlib</a>
                        <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
                    </h5>
                </div>
            </div>
        </footer>
        <!--================End Footer Area =================-->

        <!-- jQuery (necessary for Bootstrap's JavaScript plugins) -->
        <script src="js/jquery-3.2.1.min.js"></script>
        <!-- Include all compiled plugins (below), or include individual files as needed -->
        <script src="js/popper.min.js"></script>
        <script src="js/bootstrap.min.js"></script>
        <!-- Rev slider js -->
        <script src="vendors/revolution/js/jquery.themepunch.tools.min.js"></script>
        <script src="vendors/revolution/js/jquery.themepunch.revolution.min.js"></script>
        <script src="vendors/revolution/js/extensions/revolution.extension.actions.min.js"></script>
        <script src="vendors/revolution/js/extensions/revolution.extension.video.min.js"></script>
        <script src="vendors/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
        <script src="vendors/revolution/js/extensions/revolution.extension.layeranimation.min.js"></script>
        <script src="vendors/revolution/js/extensions/revolution.extension.navigation.min.js"></script>
        <script src="vendors/revolution/js/extensions/revolution.extension.slideanims.min.js"></script>
        <!-- Extra plugin css -->
        <script src="vendors/counterup/jquery.waypoints.min.js"></script>
        <script src="vendors/counterup/jquery.counterup.min.js"></script>
        <script src="vendors/owl-carousel/owl.carousel.min.js"></script>
        <script src="vendors/bootstrap-selector/js/bootstrap-select.min.js"></script>
        <script src="vendors/image-dropdown/jquery.dd.min.js"></script>
        <script src="js/smoothscroll.js"></script>
        <script src="vendors/isotope/imagesloaded.pkgd.min.js"></script>
        <script src="vendors/isotope/isotope.pkgd.min.js"></script>
        <script src="vendors/magnify-popup/jquery.magnific-popup.min.js"></script>
        <script src="vendors/vertical-slider/js/jQuery.verticalCarousel.js"></script>
        <script src="vendors/jquery-ui/jquery-ui.js"></script>

        <script src="js/theme.js"></script>
    </body>
</html>
