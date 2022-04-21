package com.example.demo;

import database.SQLQuery;
import database.entitys.Airport;
import database.query.AirportQuery;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "AddAirportServlet", value = "/AddAirportServlet")
public class AddAirportServlet extends HttpServlet {
        @Override
        protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                RequestDispatcher rd = request.getRequestDispatcher("/AddAirport.jsp");
                rd.forward(request, response);


        }

        @Override
        protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            try {
                request.setCharacterEncoding("UTF-8");
                String name = request.getParameter("name");
                String city = request.getParameter("city");
                Airport airport= new Airport(getId()+1,name,city);
                new SQLQuery().insert(new AirportQuery().insert(airport.getAirportId(),airport.getAirportName(),airport.getCity()));
                response.sendRedirect("/demo_war_exploded/AllAirportsServlet");

            } catch (Exception e) {
                request.setAttribute("err", e.getMessage());
                doGet(request, response);
            }
        }

        protected int getId() throws ClassNotFoundException {
            List<Airport> list=(ArrayList)new SQLQuery().selectAllAirport(new AirportQuery().selectAll());
            int max=0;
            for (Airport item : list){
                int number=item.getAirportId();
                if(number>max)max=number;
            }
            return max;
        }



    }