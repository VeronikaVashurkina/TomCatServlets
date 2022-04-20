package com.example.demo;

import database.SQLQuery;
import database.query.FlightQuery;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllFlightServlet", value = "/AllFlightServlet")
public class AllFlightServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            request.setAttribute("All", new SQLQuery().selectAllFlight(new FlightQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllFlight(new FlightQuery().selectAll()));
            RequestDispatcher rd = request.getRequestDispatcher("AllFlight.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}

