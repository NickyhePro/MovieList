<%-- 
    Document   : ViewMovies
    Created on : Sep 13, 2018, 9:45:11 PM
    Author     : nickyhe
--%>

<%@page import="App.Movie"%>
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Movies</title>
    </head>

    <% List<Movie> movies; %>
    <body>
        <jsp:useBean id="MovieBean" class="App.MovieBean" scope="session"/>

        <% movies = MovieBean.getMovie(); %>
        <h1>Movie List</h1>
        
            <%
                for (int i = 0; i < movies.size(); i++) {%>
            <p>
                <%=(i+1)+". "+movies.get(i)%>
            </p> 
            <%}%>
        <h4><a href="/DMS-Assignment2-war/AddMovie.jsp">Add a new movie</a></h4>
        <h4><a href="/DMS-Assignment2-war/index.html">Go Back to Home Page</a></h4>
    </body>
</html>

