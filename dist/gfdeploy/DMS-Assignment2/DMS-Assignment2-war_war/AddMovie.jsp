<%-- 
    Document   : AddMovie
    Created on : Sep 13, 2018, 10:46:05 PM
    Author     : nickyhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Add Movie</title>
    </head>
    <body>
        <h1>Add a new movie below</h1>
        <form name="Login" action="AddMovieResponse.jsp">
            Name:<br>
            <input type="text" name="name" value=""><br>
            Year:<br>
            <input type="text" name="year" value=""><br>
            Type:<br>
            <input type="text" name="type" value=""><br>
            Directors:<br>
            <input type="text" name="directors" value=""><br>
            <input type="submit" value="Submit">
        </form>
        <h4><a href="/DMS-Assignment2-war/index.html">Go Back to Home Page</a></h4>
    </body>
</html>
