<%-- 
    Document   : Register
    Created on : Jun 4, 2024, 11:23:32 PM
    Author     : thien
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
        <style>
            body {
                background-color: #fff; /* Màu nền trắng */
                font-family: Arial, sans-serif; /* Font chữ mặc định */
                margin: 0;
                padding: 0;
            }

            #content {
                width: 50%;
                margin: 50px auto;
                background-color: #ffc107; /* Màu cam */
                padding: 20px;
                border-radius: 10px;
                box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.5); /* Đổ bóng */
            }

            #form {
                text-align: center;
            }

            #form-title {
                margin-bottom: 20px;
            }

            #form-title span {
                margin-right: 20px;
            }

            #form-content {
                text-align: left;
            }

            label {
                font-weight: bold;
                color: #333;
            }

            input[type="text"],
            input[type="password"] {
                width: 100%;
                padding: 10px;
                margin-bottom: 10px;
                border: 1px solid #ccc;
                border-radius: 5px;
                box-sizing: border-box; /* Đảm bảo kích thước của input đúng như mong đợi */
            }

            .msg-error {
                color: red;
                font-style: italic;
            }

            input[type="submit"] {
                width: 100%;
                padding: 10px;
                background-color: #333; /* Màu nút */
                color: #fff;
                border: none;
                border-radius: 5px;
                cursor: pointer;
                transition: background-color 0.3s; /* Hiệu ứng chuyển đổi màu nền khi di chuột qua */
            }

            input[type="submit"]:hover {
                background-color: #555; /* Màu nền khi di chuột qua */
            }
body {
    background-color: #fff; /* Màu nền trắng */
    color: #000; /* Màu chữ đen */
    font-family: Arial, sans-serif; /* Font chữ mặc định */
    margin: 0;
    padding: 0;
}

#content {
    width: 50%;
    margin: 50px auto;
    background-color: #000; /* Màu nền đen */
    color: #fff; /* Màu chữ trắng */
    padding: 20px;
    border-radius: 10px;
    box-shadow: 0px 0px 10px 0px rgba(0,0,0,0.5); /* Đổ bóng */
}

#form {
    text-align: center;
}

#form-title {
    margin-bottom: 20px;
}

#form-title span {
    margin-right: 20px;
}

#form-content {
    text-align: left;
}

label {
    font-weight: bold;
}

input[type="text"],
input[type="password"] {
    width: 100%;
    padding: 10px;
    margin-bottom: 10px;
    border: 1px solid #fff; /* Viền trắng */
    border-radius: 5px;
    box-sizing: border-box; /* Đảm bảo kích thước của input đúng như mong đợi */
    background-color: transparent; /* Nền trong suốt */
    color: #fff; /* Màu chữ trắng */
}

.msg-error {
    color: red;
    font-style: italic;
}

input[type="submit"],
input[type="button"] {
    width: 100%;
    padding: 10px;
    border: none;
    border-radius: 5px;
    cursor: pointer;
    transition: background-color 0.3s; /* Hiệu ứng chuyển đổi màu nền khi di chuột qua */
}

input[type="submit"] {
    background-color: #fff; /* Màu nền nút Sign In */
    color: #000; /* Màu chữ đen */
    margin-bottom: 10px;
}

input[type="submit"]:hover {
    background-color: #eee; /* Màu nền khi di chuột qua */
}

input[type="button"][value="FACEBOOK LOGIN"],
input[type="button"][value="ZALO LOGIN"] {
    background-color: #000; /* Màu nền nút Facebook và Zalo Login */
    color: #fff; /* Màu chữ trắng */
    margin-bottom: 30px;
}

a {
    color: #fff; /* Màu chữ trắng */
    text-decoration: none; /* Gỡ bỏ gạch chân của liên kết */
}

a:hover {
    text-decoration: underline; /* Hiệu ứng gạch chân khi di chuột qua */
}

        </style>
    </head>
    <body>
        <div class="header_top_area">
            <div class="container">
                <div class="row">
                    <div class="col-lg-3">
                        <div class="top_header_left">
                            <div class="selector">
                                <select class="language_drop" name="countries" id="countries" style="width:300px;">
                                    <option value='yt' data-image="img/icon/flag-1.png" data-imagecss="flag yt" data-title="English">English</option>
                                    <option value='yu' data-image="img/icon/flag-1.png" data-imagecss="flag yu" data-title="Bangladesh">Bangla</option>
                                    <option value='yt' data-image="img/icon/flag-1.png" data-imagecss="flag yt" data-title="English">English</option>
                                    <option value='yu' data-image="img/icon/flag-1.png" data-imagecss="flag yu" data-title="Bangladesh">Bangla</option>
                                </select>
                            </div>
                            <select class="selectpicker usd_select">
                                <option>USD</option>
                                <option>$</option>
                                <option>$</option>
                            </select>
                            <div class="input-group">
                                <input type="text" class="form-control" placeholder="Search" aria-label="Search">
                                <span class="input-group-btn">
                                    <button class="btn btn-secondary" type="button"><i class="icon-magnifier"></i></button>
                                </span>
                            </div>
                        </div>
                    </div>
                    <div class="col-lg-6">
                        <div class="top_header_middle">
                            <a href="#"><i class="fa fa-phone"></i> Call Us: <span>+84 987 654 321</span></a>
                            <a href="#"><i class="fa fa-envelope"></i> Email: <span>support@yourdomain.com</span></a>
                            <img src="img/logo.png" alt="">
                        </div>
                    </div>
                    <div class="col-lg-3">
                        <div class="top_right_header">
                            <ul class="header_social">
                                <li><a href="#"><i class="fa fa-facebook"></i></a></li>
                                <li><a href="#"><i class="fa fa-twitter"></i></a></li>
                                <li><a href="#"><i class="fa fa-pinterest"></i></a></li>
                                <li><a href="#"><i class="fa fa-instagram"></i></a></li>
                                <li><a href="#"><i class="fa fa-youtube-play"></i></a></li>
                            </ul>
                          

                            <ul class="top_right">
                                <li class="user dropdown">
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
                                </li>
                            </ul>

                        </div>
                    </div>
                </div>
            </div>
        </div>
        <!--================End Top Header Area =================-->

        <!--================Menu Area =================-->
        <header class="shop_header_area">
            <div class="container">
                <nav class="navbar navbar-expand-lg navbar-light bg-light">
                    <a class="navbar-brand" href="#"><img src="img/logo.png" alt=""></a>
                    <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarSupportedContent" aria-controls="navbarSupportedContent" aria-expanded="false" aria-label="Toggle navigation">
                        <span class="navbar-toggler-icon"></span>
                    </button>

                    <div class="collapse navbar-collapse" id="navbarSupportedContent">
                        <ul class="navbar-nav categories">
                            <li class="nav-item">
                                <select class="selectpicker">
                                    <option>Categories</option>
                                    <option>Categories 2</option>
                                    <option>Categories 3</option>
                                </select>
                            </li>
                        </ul>
                        <ul class="navbar-nav">
                            <li class="nav-item dropdown submenu active">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Home <i class="fa fa-angle-down" aria-hidden="true"></i>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="index.html">Home Simple</a></li>
                                    <li class="nav-item"><a class="nav-link" href="home-carousel.html">Home Carousel</a></li>
                                    <li class="nav-item"><a class="nav-link" href="home-fullwidth.html">Home Full Width</a></li>
                                    <li class="nav-item"><a class="nav-link" href="home-parallax.html">Home Parallax</a></li>
                                    <li class="nav-item"><a class="nav-link" href="home-sidebar.html">Home Boxed</a></li>
                                    <li class="nav-item"><a class="nav-link" href="home-fixed-menu.html">Home Fixed</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown submenu">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Pages <i class="fa fa-angle-down" aria-hidden="true"></i>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="compare.html">Compare</a></li>
                                    <li class="nav-item"><a class="nav-link" href="checkout.html">Checkout Method</a></li>
                                    <li class="nav-item"><a class="nav-link" href="register.html">Checkout Register</a></li>
                                    <li class="nav-item"><a class="nav-link" href="track.html">Track</a></li>
                                    <li class="nav-item"><a class="nav-link" href="login.html">Login</a></li>
                                    <li class="nav-item"><a class="nav-link" href="404.html">404</a></li>
                                </ul>
                            </li>
                            <li class="nav-item dropdown submenu">
                                <a class="nav-link dropdown-toggle" href="#" role="button" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    Shop <i class="fa fa-angle-down" aria-hidden="true"></i>
                                </a>
                                <ul class="dropdown-menu">
                                    <li class="nav-item"><a class="nav-link" href="categories-no-sidebar-2column.html">Prodcut No Sidebar</a></li>
                                    <li class="nav-item"><a class="nav-link" href="categories-no-sidebar-3column.html">Prodcut Two Column</a></li>
                                    <li class="nav-item"><a class="nav-link" href="categories-no-sidebar-4column.html">Product Grid</a></li>
                                    <li class="nav-item"><a class="nav-link" href="categories-left-sidebar.html">Categories Left Sidebar</a></li>
                                    <li class="nav-item"><a class="nav-link" href="categories-right-sidebar.html">Categories Right Sidebar</a></li>
                                    <li class="nav-item"><a class="nav-link" href="categories-grid-left-sidebar.html">Categories Grid Sidebar</a></li>
                                    <li class="nav-item"><a class="nav-link" href="product-details.html">Prodcut Details 01</a></li>
                                    <li class="nav-item"><a class="nav-link" href="product-details2.html">Prodcut Details 02</a></li>
                                    <li class="nav-item"><a class="nav-link" href="product-details3.html">Prodcut Details 03</a></li>
                                    <li class="nav-item"><a class="nav-link" href="shopping-cart.html">Shopping Cart 01</a></li>
                                    <li class="nav-item"><a class="nav-link" href="shopping-cart2.html">Shopping Cart 02</a></li>
                                    <li class="nav-item"><a class="nav-link" href="empty-cart.html">Empty Cart</a></li>
                                </ul>
                            </li>
                            <li class="nav-item"><a class="nav-link" href="#">Blog</a></li>
                            <li class="nav-item"><a class="nav-link" href="#">lookbook</a></li>
                            <li class="nav-item"><a class="nav-link" href="product">Products</a></li>
                        </ul>
                    </div>
                </nav>
            </div>
        </header>
        <div id="content">

            <div id="form">
                <div id="form-title">
                    <span><a href="<%=request.getContextPath()%>/Register">Register</a></span>
                    <span><a href="<%=request.getContextPath()%>/Login" style="color: blue;">Login</a></span>
                </div>
                <div id="form-content">
                    <center style="color: blue;">
                        <%
                            if(request.getAttribute("msg") != null){
                                out.print(request.getAttribute("msg"));
                            }
                        %>
                    </center>
                    <form action="Login" method="post">
                        <label>Email<span style="color: red;">*</span></label><br/>
                        <input type="text" name = "txtEmail" value = ${txtEmail}><br/>
                        <%if(request.getAttribute("msgEmail") != null) {%>
                        <span class="msg-error">
                            <% out.print(request.getAttribute("msgEmail"));%>
                        </span>
                        <%}%>
                        <br/>
                        <label>Password<span style="color: red;">*</span></label><br/>
                        <input type="password" name = "txtPass"/><br/>
                        <%if(request.getAttribute("msgPass") != null) {%>
                        <span class="msg-error">
                            <% out.print(request.getAttribute("msgPass"));%>
                        </span>
                        <%}%>
                        <div><a href="<%=request.getContextPath()%>/forgot.jsp" style="text-decoration: none;">Forgot password?</a></div>
                        <input type="submit" value="SIGN IN"/><br/>
                        <input type="button" value="FACEBOOK LOGIN" style="background-color: #3b5998;"/><br/>
                        <input type="button" value="ZALO LOGIN" style="background-color: #009dff;margin-bottom: 30px;"/>
                    </form>
                </div>
            </div>
        </div>
    </body>
</html>
