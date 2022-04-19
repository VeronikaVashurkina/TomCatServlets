package database.query;

public class AirplaneQuery {

    public String delete(int airplaneId) {
        return "delete from airplane where airplane_id =" + airplaneId;
    }

    public String select(int airplaneId) {
        return "select * from airplane where airplane_id =" + airplaneId;
    }

    public String selectAll(){return "select * from airplane";}
    public String insert(int airplaneId, String airplaneModel, int airplaneCapacity, int flightId) {
        return "insert into airplane values ('" + airplaneId + "', '" + airplaneModel + "', '" + airplaneCapacity + "', '" + flightId + "');";
    }
public String update(int airplaneId, String newAirplaneModel, int newAirplaneCapacity, int newFlightId){
    return "update airplane set airplane_model= '"+newAirplaneModel+"' where airplane_id= '"+airplaneId+"' ;"+
            "update airplane set airplane_capacity= '"+newAirplaneCapacity+"' where airplane_id= '"+airplaneId+"' ;"+
            "update airplane set flight_id= '"+newFlightId+"' where airplane_id= '"+airplaneId+"' ;";
}
}
