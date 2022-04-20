package com.example.demo;

import database.SQLQuery;
import database.query.AirplaneQuery;
import database.query.LuggageQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "AllLuggageServlet", value = "/AllLuggageServlet")
public class AllLuggageServlet extends HttpServlet {
    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
        try {
            request.setAttribute("All", new SQLQuery().selectAllLuggage(new LuggageQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllLuggage(new LuggageQuery().selectAll()));
            RequestDispatcher rd = request.getRequestDispatcher("AllLuggage.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }



}
