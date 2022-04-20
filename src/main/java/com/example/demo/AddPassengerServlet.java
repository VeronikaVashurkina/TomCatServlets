package com.example.demo;

import database.SQLQuery;
import database.entitys.Passenger;
import database.query.AirplaneQuery;
import database.query.PassengerQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddPassengerServlet", value = "/AddPassengerServlet")
public class AddPassengerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("All", new SQLQuery().selectAllAirplane(new AirplaneQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllAirport(new AirplaneQuery().selectAll()));
            RequestDispatcher rd = request.getRequestDispatcher("/AddPassenger.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String surname = request.getParameter("surname");
            String name = request.getParameter("name");
            String middleName = request.getParameter("middle_name");
            String sex = request.getParameter("sex");
            String password = request.getParameter("password");
            String nationality = request.getParameter("nationality");
            int airplaneId= Integer.parseInt(request.getParameter("airplane_id"));
            Passenger airplane = new Passenger(getId()+1, surname,name,middleName,sex,password,nationality,airplaneId);
            new SQLQuery().insert(new PassengerQuery().insert(airplane.getPassengerId(),airplane.getPassengerSurname(),airplane.getPassengerName(),airplane.getPassengerMiddleName(),airplane.getPassengerSex(),airplane.getPassengerPassword(),airplane.getPassengerNationality(),airplane.getAirplaneId()));
            response.sendRedirect("/demo_war_exploded/AllPassengersServlet");

        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }

    protected int getId() throws ClassNotFoundException {
        List<Passenger> list=(ArrayList)new SQLQuery().selectAllPassenger(new PassengerQuery().selectAll());
        int max=0;
        for (Passenger item : list){
            int number=item.getPassengerId();
            if(number>max)max=number;
        }
        return max;
    }



}
