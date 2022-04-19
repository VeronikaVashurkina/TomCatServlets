package com.example.demo;

import database.SQLQuery;
import database.query.AirplaneQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "DeleteAirplaneServlet", value = "/DeleteAirplaneServlet")
public class DeleteAirplaneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");

            int id = Integer.parseInt(request.getParameter("id"));
        try {
            new SQLQuery().delete(new AirplaneQuery().delete(id));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/demo_war_exploded/hello-servlet");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
