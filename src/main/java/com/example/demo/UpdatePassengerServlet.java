package com.example.demo;

import database.SQLQuery;
import database.entitys.Passenger;
import database.query.AirplaneQuery;
import database.query.PassengerQuery;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;

@WebServlet(name = "UpdatePassengerServlet", value = "/UpdatePassengerServlet")
public class UpdatePassengerServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("One", new SQLQuery().selectAllPassenger(new PassengerQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.getSession().setAttribute("One", new SQLQuery().selectAllPassenger(new PassengerQuery().select(Integer.parseInt(request.getParameter("id")))));
            request.setAttribute("All", new SQLQuery().selectAllAirplane(new AirplaneQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllAirplane(new AirplaneQuery().selectAll()));


            RequestDispatcher rd = request.getRequestDispatcher("/UpdatePassenger.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String surname = request.getParameter("surname");
        String name = request.getParameter("name");
        String middleName = request.getParameter("middle_name");
        String sex = request.getParameter("sex");
        String password = request.getParameter("password");
        String nationality = request.getParameter("nationality");
        int airplaneId= Integer.parseInt(request.getParameter("airplane_id"));
        Passenger airplane = new Passenger(Integer.parseInt(request.getParameter("id")), surname,name,middleName,sex,password,nationality,airplaneId);
        try {
            new SQLQuery()
                    .update(new PassengerQuery()
                            .update(airplane
                                    .getPassengerId(),airplane
                                    .getPassengerSurname(),airplane
                                    .getPassengerName(),airplane
                                    .getPassengerMiddleName(),airplane
                                    .getPassengerSex(),airplane
                                    .getPassengerPassword(),airplane
                                    .getPassengerNationality(),airplane
                                    .getAirplaneId()));
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        response.sendRedirect("/demo_war_exploded/AllPassengerServlet");


    }

}


