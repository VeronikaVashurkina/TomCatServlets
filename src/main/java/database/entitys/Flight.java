package database.entitys;

import java.sql.Time;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Flight {
    private int flightId;
    private String flightName;
    private Date flightDate;
    private Time flightTime;
    private int airportId;

    public Flight(int flightId, String flightName, Date flightDate, Time flightTime, int airportId) {
        this.flightId = flightId;
        this.flightName = flightName;
        this.flightDate = flightDate;
        this.flightTime = flightTime;
        this.airportId = airportId;
    }

    public Flight(int flightId, String name, String date, String time, int airportId) throws ParseException {
        this.flightId = flightId;
        this.flightName = name;
        SimpleDateFormat format = new SimpleDateFormat();
       // format.applyPattern("dd.MM.yyyy");
        format.applyPattern("yyyy.MM.dd");

        this.flightDate = format.parse(date);
        this.flightTime = Time.valueOf(time+":00");
        this.airportId = airportId;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public String getFlightName() {
        return flightName;
    }

    public void setFlightName(String flightName) {
        this.flightName = flightName;
    }

    public Date getFlightDate() {
        return flightDate;
    }

    public void setFlightDate(Date flightDate) {
        this.flightDate = flightDate;
    }

    public Time getFlightTime() {
        return flightTime;
    }

    public void setFlightTime(Time flightTime) {
        this.flightTime = flightTime;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }
}
