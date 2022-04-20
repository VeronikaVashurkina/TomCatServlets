package com.example.demo;

import database.SQLQuery;
import database.entitys.Airplane;
import database.entitys.Airport;
import database.query.AirplaneQuery;
import database.query.AirportQuery;
import database.query.FlightQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateAirportServlet", value = "/UpdateAirportServlet")
public class UpdateAirportServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("One", new SQLQuery().selectAllAirport(new AirportQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.getSession().setAttribute("One", new SQLQuery().selectAllAirport(new AirportQuery().select(Integer.parseInt(request.getParameter("id")))));



            RequestDispatcher rd = request.getRequestDispatcher("/UpdateAirport.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String city = request.getParameter("city");
        Airport airport = new Airport(Integer.parseInt(request.getParameter("id")), name,city);
        try {
            new SQLQuery().insert(new AirportQuery().update(airport.getAirportId(), airport.getAirportName(),airport.getCity()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/demo_war_exploded/AllAirportsServlet");

    }
}
