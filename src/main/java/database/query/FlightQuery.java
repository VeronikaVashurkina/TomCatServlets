package database.query;

import java.sql.Time;
import java.util.Date;

public class FlightQuery {
    public String delete(int flightId) {
        return "delete from flight where flight_id =" + flightId;
    }

    public String select(int flightId) {
        return "select * from flight where flight_id =" + flightId;
    }

    public String selectAll(){return "select * from flight";}
    public String insert(int flightId, String flightName, Date flightDate, Time flightTime,int airportId) {
        return "insert into flight values ('" + flightId + "', '" + flightName + "', '" + flightDate + "', '" + flightTime +"', '" + airportId + "');";
    }
    public String update(int flightId, String newFlightName, Date newFlightDate, Time newFlightTime,int newAirportId){
        return "update flight set flight_name= '"+newFlightName+"' where flight_id= '"+flightId+"' ;"+
                "update flight set flight_date= '"+newFlightDate+"' where flight_id= '"+flightId+"' ;"+
                "update flight set flight_time= '"+newFlightTime+"' where flight_id= '"+flightId+"' ;"+
                "update flight set airport_id= '"+newAirportId+"' where flight_id= '"+flightId+"' ;";
    }
}

