package com.example.demo;

import database.SQLQuery;
import database.query.AirplaneQuery;

import java.io.*;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class AllAirplanesServlet extends HttpServlet {
@Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            request.setAttribute("All", new SQLQuery().selectAllAirplane(new AirplaneQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllAirplane(new AirplaneQuery().selectAll()));
            RequestDispatcher rd = request.getRequestDispatcher("AllAirplanes.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }


}