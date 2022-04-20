package com.example.demo;

import database.SQLQuery;
import database.entitys.Luggage;
import database.query.LuggageQuery;
import database.query.PassengerQuery;


import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddLuggageServlet", value = "/AddLuggageServlet")
public class AddLuggageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            request.setAttribute("All", new SQLQuery().selectAllPassenger(new PassengerQuery().selectAll()));
            request.getSession().setAttribute("All", new SQLQuery().selectAllPassenger(new PassengerQuery().selectAll()));
            RequestDispatcher rd = request.getRequestDispatcher("/AddLuggage.jsp");
            rd.forward(request, response);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            int kg = Integer.parseInt(request.getParameter("kg"));
            int flightId= Integer.parseInt(request.getParameter("passenger_id"));
            Luggage airplane = new Luggage(getId()+1, kg,flightId);
            new SQLQuery().insert(new LuggageQuery().insert(airplane.getLuggageId(),airplane.getLuggageWeight(),airplane.getPassengerId()));
            response.sendRedirect("/demo_war_exploded/AllLuggageServlet");

        } catch (Exception e) {
            request.setAttribute("err", e.getMessage());
            doGet(request, response);
        }
    }

    protected int getId() throws ClassNotFoundException {
        List<Luggage> list=(ArrayList)new SQLQuery().selectAllLuggage(new LuggageQuery().selectAll());
        int max=0;
        for (Luggage item : list){
            int number=item.getLuggageId();
            if(number>max)max=number;
        }
        return max;
    }



}
