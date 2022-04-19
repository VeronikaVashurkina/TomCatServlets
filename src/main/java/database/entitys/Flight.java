package database.entitys;

import java.sql.Time;
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
