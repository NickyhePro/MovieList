/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author nickyhe
 */
@WebServlet(name = "AddMovieServlet", urlPatterns = {"/AddMovieServlet"})
public class AddMovieServlet extends HttpServlet {

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            String name = request.getParameter("name");
            String year = request.getParameter("year");
            String type = request.getParameter("type");
            String directors = request.getParameter("directors");
            if(name != null && year != null && type != null && directors != null)
            {
                request.setAttribute("name", name);
                request.setAttribute("year", year);
                request.setAttribute("type", type);
                request.setAttribute("directors", directors);
                getServletContext().getRequestDispatcher("/AddMovieResponse.jsp").forward(request, response);
            }
        }
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }
}
