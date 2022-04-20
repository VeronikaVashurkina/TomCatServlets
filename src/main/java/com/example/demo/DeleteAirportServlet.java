package com.example.demo;

import database.SQLQuery;
import database.query.AirplaneQuery;
import database.query.AirportQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteAirportServlet", value = "/DeleteAirportServlet")
public class DeleteAirportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

        int id = Integer.parseInt(request.getParameter("id"));
        try {
            new SQLQuery().delete(new AirportQuery().delete(id));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/demo_war_exploded/AllAirportsServlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
