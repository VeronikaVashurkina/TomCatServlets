package com.example.demo;

import database.SQLQuery;
import database.entitys.Airplane;
import database.entitys.Luggage;
import database.query.AirplaneQuery;
import database.query.FlightQuery;
import database.query.LuggageQuery;
import database.query.PassengerQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateLuggageServlet", value = "/UpdateLuggageServlet")
public class UpdateLuggageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("One", new SQLQuery().selectAllLuggage(new LuggageQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.getSession().setAttribute("One", new SQLQuery().selectAllLuggage(new LuggageQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.setAttribute("All", new SQLQuery().selectAllPassenger(new PassengerQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllPassenger(new PassengerQuery().selectAll()));


            RequestDispatcher rd = request.getRequestDispatcher("/UpdateLuggage.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        int kg = Integer.parseInt(request.getParameter("kg"));
        int flightId = Integer.parseInt(request.getParameter("passenger_id"));
        Luggage airplane = new Luggage(Integer.parseInt(request.getParameter("id")), kg,flightId);
        try {
            new SQLQuery().update(new LuggageQuery().update(airplane.getLuggageId(),airplane.getLuggageWeight(),airplane.getPassengerId()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        response.sendRedirect("/demo_war_exploded/AllLuggageServlet");

    }

}