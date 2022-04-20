package com.example.demo;

import database.SQLQuery;
import database.entitys.Flight;
import database.query.AirportQuery;
import database.query.FlightQuery;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddFlightServlet", value = "/AddFlightServlet")
public class AddFlightServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("All", new SQLQuery().selectAllAirport(new AirportQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllAirport(new AirportQuery().selectAll()));
            RequestDispatcher rd = request.getRequestDispatcher("/AddFlight.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String name = request.getParameter("name");
            String date = request.getParameter("date");
            String time = request.getParameter("time");
            int airportId= Integer.parseInt(request.getParameter("airport_id"));
            Flight airplane = new Flight(getId()+1, name, date,time,airportId);
            new SQLQuery().insert(new FlightQuery().insert(airplane.getFlightId(),airplane.getFlightName(),airplane.getFlightDate(),airplane.getFlightTime(),airplane.getAirportId()));
            response.sendRedirect("/demo_war_exploded/AllFlightServlet");

        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }

    protected int getId() throws ClassNotFoundException {
        List<Flight> list=(ArrayList)new SQLQuery().selectAllFlight(new FlightQuery().selectAll());
        int max=0;
        for (Flight item : list){
            int number=item.getFlightId();
            if(number>max)max=number;
        }
        return max;
    }



}


