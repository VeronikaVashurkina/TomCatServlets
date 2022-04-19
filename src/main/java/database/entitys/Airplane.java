package database.entitys;

public class Airplane {
    private int airplaneId;
    private String airplaneModel;
    private int airplaneCapacity;
    private int flightId;

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    public String getAirplaneModel() {
        return airplaneModel;
    }

    public void setAirplaneModel(String airplaneModel) {
        this.airplaneModel = airplaneModel;
    }

    public int getAirplaneCapacity() {
        return airplaneCapacity;
    }

    public void setAirplaneCapacity(int airplaneCapacity) {
        this.airplaneCapacity = airplaneCapacity;
    }

    public int getFlightId() {
        return flightId;
    }

    public void setFlightId(int flightId) {
        this.flightId = flightId;
    }

    public Airplane(int airplaneId, String airplaneModel, int airplaneCapasity, int flightId) {
        this.airplaneId = airplaneId;
        this.airplaneModel = airplaneModel;
        this.airplaneCapacity = airplaneCapasity;
        this.flightId = flightId;
    }
}
