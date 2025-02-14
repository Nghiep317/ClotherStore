<%@page import="DAL.*" %>
<%@page import="controllers.*" %>
<%@page import="models.*" %>
<%@page import="java.util.ArrayList" %>
<%@page import="DTO.*" %>
<% String path =request.getContextPath();%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="UTF-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1.0">
        <title>Shope Store</title>
        <link rel="icon" type="image/x-icon" href="<%=path%>/img/logo.png">
        <link href="<%=path%>/css/style.css" rel="stylesheet" type="text/css"/>
        <link href="<%=path%>/css/bootstrap/bootstrap.min.css" rel="stylesheet" type="text/css"/>
    </head>
    <body >
    <div id="container">
        <div id="header">
            <div id="logo">
                <a href="<%=path%>/category-list"><img src="<%=path%>/img/logo.png" style="width: 100px; height: 100px;margin: 10px;"/></a>
            </div>

            <nav class="navbar navbar-light timkiem">
                <div class="container-fluid">
                    <form action="search" method="post" class="d-flex" style="width: 100%;">
                        <input name="txtSearch" class="form-control me-2" type="search" placeholder="Search Product by name" aria-label="Search" value="${nameSearch}">
                        <button class="btn btn-outline-success search-btn" type="submit">Search</button>
                    </form>
                </div>
            </nav>

            <div id="banner"  >
                <ul style="margin-bottom: 0">
                    <li><a href="<%=path%>/cart" class="nav-link siennaa" > Cart: ${size} ${size == null ? "0 item" : "items"}</a></li>
                        <%
                            if(session.getAttribute("AccSession")==null){
                        %>
                    <li><a href="<%=path%>/account/signin"  class="nav-link siennaa" >Sign In</a></li>
                    <li><a href="<%=path%>/account/signup"  class="nav-link siennaa">Sign Up</a></li>
                        <% 
                            }else{
                                Account acc = (Account) request.getSession().getAttribute("AccSession");
                        %>
                    <li><a href="<%=path%>/account/profile?accountID=<%=acc.getAccountID() %>"  class="nav-link siennaa">Profile</a></li>
                    <li><a href="<%=path%>/account/signin"  class="nav-link siennaa">Sign Out</a></li>
                        <%
                            }
                        %>
                </ul>
            </div>
        </div>
