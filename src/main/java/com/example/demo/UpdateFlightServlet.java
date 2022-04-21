package com.example.demo;

import database.SQLQuery;
import database.entitys.Flight;
import database.query.AirportQuery;
import database.query.FlightQuery;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.text.ParseException;

@WebServlet(name = "UpdateFlightServlet", value = "/UpdateFlightServlet")
public class UpdateFlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("One", new SQLQuery().selectAllFlight(new FlightQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.getSession().setAttribute("One", new SQLQuery().selectAllFlight(new FlightQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.setAttribute("All", new SQLQuery().selectAllAirport(new AirportQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllAirport(new AirportQuery().selectAll()));


            RequestDispatcher rd = request.getRequestDispatcher("/UpdateFlight.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String name = request.getParameter("name");
        String date = request.getParameter("date").replace('-','.');
        String time = request.getParameter("time");
        int airportId= Integer.parseInt(request.getParameter("airport_id"));

        Flight airplane = null;
        try {
            airplane = new Flight(Integer.parseInt(request.getParameter("id")), name, date,time,airportId);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        try {
            new SQLQuery().update(new FlightQuery().update(airplane.getFlightId(),airplane.getFlightName(),airplane.getFlightDate(),airplane.getFlightTime(),airplane.getAirportId()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/AllFlightServlet");


    }

}