<%-- 
    Document   : Login
    Created on : Sep 13, 2018, 5:53:44 PM
    Author     : nickyhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Login to your account</title>
    </head>
    <body>
        <h1>Login to your account below</h1>
        <form action="LoginServlet" method="POST">
            Your email:<br>
            <input type="text" name="email" value="Your email..."><br>
            Your password:<br>
            <input type="text" name="password" value="At least 6 characters..."><br>
            <input type="submit" value="Login">
        </form>
        <h4><a href="/DMS-Assignment2-war/index.html">Go Back to Home Page</a></h4>
    </body>
</html>
