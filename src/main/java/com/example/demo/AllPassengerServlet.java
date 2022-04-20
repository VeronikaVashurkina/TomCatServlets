package com.example.demo;

import database.SQLQuery;
import database.query.PassengerQuery;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllPassengerServlet", value = "/AllPassengerServlet")
public class AllPassengerServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            request.setAttribute("All", new SQLQuery().selectAllPassenger(new PassengerQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllPassenger(new PassengerQuery().selectAll()));
            RequestDispatcher rd = request.getRequestDispatcher("AllPassengers.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}
