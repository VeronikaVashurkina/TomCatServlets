package com.example.demo;

import database.SQLQuery;
import database.query.AirplaneQuery;
import database.query.AirportQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllAirportsServlet", value = "/AllAirportsServlet")
public class AllAirportsServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            request.setAttribute("All", new SQLQuery().selectAllAirport(new AirportQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllAirport(new AirportQuery().selectAll()));
            RequestDispatcher rd = request.getRequestDispatcher("AllAirports.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }
}
