<%-- 
    Document   : AddMovieResponse
    Created on : Sep 13, 2018, 10:49:16 PM
    Author     : nickyhe
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Response</title>
    </head>
    
    <% boolean check = false; %>
    
    <body>
        <jsp:useBean id="Movie" class="App.Movie" scope="session"/>
        <jsp:useBean id="MovieBean" class="App.MovieBean" scope="session"/>
        <jsp:setProperty name="Movie" property="name" />
        <jsp:setProperty name="Movie" property="year" />
        <jsp:setProperty name="Movie" property="type" />
        <jsp:setProperty name="Movie" property="directors" />

        <%
            check = MovieBean.addMovie(Movie);
        %>

        <% if (check == true) { %>
        <h1>Movie has been added successfully</h1>
        <h2><a href="/DMS-Assignment2-war/ViewMovies.jsp">Go to the Movie List</a></h2>
        <%} else {
        %>
        <h1>Adding failed</h1>
        <h2><a href="/DMS-Assignment2-war/AddMovie.jsp">Try again?</a></h2>
        <%}%>
    </body>
</html>
