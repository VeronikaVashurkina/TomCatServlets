package com.example.demo;

import database.SQLQuery;
import database.entitys.Airplane;
import database.query.AirplaneQuery;
import database.query.FlightQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdateAirplaneServlet", value = "/UpdateAirplaneServlet")
public class UpdateAirplaneServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("One", new SQLQuery().selectAllAirplane(new AirplaneQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.getSession().setAttribute("One", new SQLQuery().selectAllAirplane(new AirplaneQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.setAttribute("All", new SQLQuery().selectAllFlight(new FlightQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllFlight(new FlightQuery().selectAll()));


        RequestDispatcher rd = request.getRequestDispatcher("/UpdateAirplane.jsp");
        rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String model = request.getParameter("model");
        int kg = Integer.parseInt(request.getParameter("kg"));
        int flightId = Integer.parseInt(request.getParameter("flight_id"));
        Airplane airplane = new Airplane(Integer.parseInt(request.getParameter("id")), model, kg, flightId);
        try {
            new SQLQuery().insert(new AirplaneQuery().update(airplane.getAirplaneId(), airplane.getAirplaneModel(), airplane.getAirplaneCapacity(), airplane.getFlightId()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        response.sendRedirect("/demo_war_exploded/hello-servlet");

    }

}


