package database;

import database.entitys.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.*;
import java.util.ArrayList;
import java.util.Properties;

public  class SQLQuery {

    private static Properties properties = new Properties();
    private static String url;
    private static String user;
    private static String password;

    public SQLQuery() {
        try (FileInputStream in = new FileInputStream("C:\\Users\\Вероника\\Desktop\\8 семак\\kursovicWEB\\курсач\\TomCat\\src\\main\\resources\\application.properties")) {
            properties.load(in);
            url = properties.getProperty("jdbc.url");
            user = properties.getProperty("jdbc.user");
            password = properties.getProperty("jdbc.password");
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void insert(String sql) {
        try (Connection connection = DriverManager
                .getConnection(url, user, password);
             Statement statement = connection.createStatement();) {
            statement.executeUpdate(sql);

            connection.setAutoCommit(false);
            connection.commit();

        } catch (Exception e) {
            System.out.println(e);

        }
    }

    //selects /////////////////////

    public static ArrayList<Airplane> selectAllAirplane(String sql) {
        ArrayList<Airplane> records = new ArrayList<Airplane>();
        try (Connection connection = DriverManager
                .getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int newAirplaneId = resultSet.getInt("airplane_id");
                String newAirplaneModel = resultSet.getString("airplane_model");
                int newAirplaneCapacity = resultSet.getInt("airplane_capacity");
                int newFlightId = resultSet.getInt("flight_id");
                Airplane record = new Airplane(newAirplaneId,newAirplaneModel,newAirplaneCapacity,newFlightId);
                records.add(record);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return records;
    }

    public static ArrayList<Airport> selectAllAirport(String sql) {
        ArrayList<Airport> records = new ArrayList<Airport>();
        try (Connection connection = DriverManager
                .getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql);) {
            while (resultSet.next()) {
                int newAirportId = resultSet.getInt("airport_id");
                String newAirplaneModel = resultSet.getString("airport_name");
                String  newCity = resultSet.getString("city");
                Airport record = new Airport(newAirportId,newAirplaneModel,newCity);
                records.add(record);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return records;
    }

    public static ArrayList<Flight> selectAllFlight(String sql) {
        ArrayList<Flight> records = new ArrayList<Flight>();
        try (Connection connection = DriverManager
                .getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int newFlightId = resultSet.getInt("flight_id");
                String newFlightName = resultSet.getString("flight_name");
                Date newFlightDate = resultSet.getDate("flight_date");
                Time newFlightTime = resultSet.getTime("flight_time");
                int newAirportId = resultSet.getInt("airport_id");
                Flight record = new Flight(newFlightId,newFlightName,newFlightDate,newFlightTime,newAirportId);
                records.add(record);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return records;
    }


    public static ArrayList<Luggage> selectAllLuggage(String sql) {
        ArrayList<Luggage> records = new ArrayList<Luggage>();
        try (Connection connection = DriverManager
                .getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int newLuggageId = resultSet.getInt("luggage_id");
                int newLuggageWeight = resultSet.getInt("luggage_weight");
                int newPassengerId = resultSet.getInt("passenger_id");
                Luggage record = new Luggage(newLuggageId,newLuggageWeight,newPassengerId);
                records.add(record);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return records;
    }


    public static ArrayList<Passenger> selectAllPassenger(String sql) {
        ArrayList<Passenger> records = new ArrayList<Passenger>();
        try (Connection connection = DriverManager
                .getConnection(url, user, password);
             Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                int newPassengerId = resultSet.getInt("passenger_id");
                String newPassengerSurname = resultSet.getString("passenger_surname");
                String newPassengerName = resultSet.getString("passenger_name");
                String newPassengerMiddleName = resultSet.getString("passenger_middle_name");
                String newPassengerSex = resultSet.getString("passenger_sex");
                String newPassengerPassword = resultSet.getString("passenger_password");
                String newPassengerNationality = resultSet.getString("passenger_nationality");
                int newAirplaneId = resultSet.getInt("airplane_id");
                Passenger record = new Passenger(newPassengerId,newPassengerSurname,newPassengerName,newPassengerMiddleName,newPassengerSex,newPassengerPassword,newPassengerNationality,newAirplaneId);
                records.add(record);
            }

        } catch (Exception e) {
            System.out.println(e);
        }
        return records;
    }



    public static void update(String sql) {
        try (Connection connection = DriverManager
                .getConnection(url, user, password);
             Statement statement = connection.createStatement()) {
            connection.setAutoCommit(false);
            statement.executeUpdate(sql);
            connection.commit();

        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public static void delete(String sql) {
        try (Connection connection = DriverManager
                .getConnection(url, user, password);
             Statement statement = connection.createStatement()
        ) {
            statement.executeUpdate(sql);
            connection.setAutoCommit(false);
            connection.commit();


        } catch (Exception e) {
            System.out.println(e);
        }
    }




}