<%-- 
    Document   : LoginResponse
    Created on : Sep 13, 2018, 6:06:47 PM
    Author     : nickyhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login</title>
    </head>
    
    <% boolean loginCheck = false; %>
    
    <body>
        <jsp:useBean id="User" class="App.User" scope="session"/>
        <jsp:useBean id="UserBean" class="App.UserBean" scope="session"/>
        <jsp:setProperty name="User" property="email" />
        <jsp:setProperty name="User" property="password" />

        <%
            loginCheck = UserBean.login(User);
        %>

        <% if (loginCheck == true) { %>
        <h1>Log in successfully</h1>
        <h2><a href="/DMS-Assignment2-war/ViewMovies.jsp">Go to the Movie List</a></h2>
        <%} else {
        %>
        <h1>Password or email wrong.</h1>
        <h2><a href="/DMS-Assignment2-war/Login.jsp">Try again?</a></h2>
        <%}%>
    </body>
</html>
