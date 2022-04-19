package database.entitys;

public class Airport {
    private int airportId;
    private String airportName;
    private String city;

    public Airport(int airportId, String airportName, String city) {
        this.airportId = airportId;
        this.airportName = airportName;
        this.city = city;
    }

    public int getAirportId() {
        return airportId;
    }

    public void setAirportId(int airportId) {
        this.airportId = airportId;
    }

    public String getAirportName() {
        return airportName;
    }

    public void setAirportName(String airportName) {
        this.airportName = airportName;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}
