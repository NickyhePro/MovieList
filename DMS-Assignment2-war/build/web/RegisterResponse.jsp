<%-- 
    Document   : RegisterResponse
    Created on : Sep 13, 2018, 6:06:35 PM
    Author     : nickyhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Register</title>
    </head>

    <% boolean registered = false; %>

    <body>
        <jsp:useBean id="User" class="App.User" scope="session"/>
        <jsp:useBean id="UserBean" class="App.UserBean" scope="session"/>
        <jsp:setProperty name="User" property="email" />
        <jsp:setProperty name="User" property="password" />

        <%
            registered = UserBean.register(User);
        %>

        <% if (registered == true) { %>
        <h1>Sign up successfully</h1>
        <h2><a href="/DMS-Assignment2-war/ViewMovies.jsp">Go to the Movie List</a></h2>
        <%} else {
        %>
        <h1>Register failed</h1>
        <h2><a href="/DMS-Assignment2-war/Register.jsp">Try again?</a></h2>
        <%}%>
    </body>
</html>
