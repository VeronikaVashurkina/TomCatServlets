package com.example.demo;

import database.SQLQuery;
import database.entitys.Airplane;
import database.query.AirplaneQuery;
import database.query.FlightQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddAirplaneServlet", value = "/AddAirplaneServlet")
public class AddAirplaneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setAttribute("All", new SQLQuery().selectAllFlight(new FlightQuery().selectAll()));
        request.getSession().setAttribute("All", new SQLQuery().selectAllFlight(new FlightQuery().selectAll()));
        RequestDispatcher rd = request.getRequestDispatcher("/AddAirplane.jsp");
        rd.forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {

            String model = request.getParameter("model");
            int kg = Integer.parseInt(request.getParameter("kg"));
            int flightId= Integer.parseInt(request.getParameter("flight_id"));

            Airplane airplane = new Airplane(getId()+1, model, kg,flightId);
            new SQLQuery().insert(new AirplaneQuery().insert(airplane.getAirplaneId(),airplane.getAirplaneModel(),airplane.getAirplaneCapacity(),airplane.getFlightId()));
            response.sendRedirect("/demo_war_exploded/hello-servlet");

        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }

    protected int getId(){
        List<Airplane> list=(ArrayList)new SQLQuery().selectAllFlight(new FlightQuery().selectAll());
        int max=0;
        for (Airplane item : list){
            int number=item.getFlightId();
            if(number>max)max=number;
        }
        return max;
    }



}
