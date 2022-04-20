package database.query;

public class AirportQuery {
    public String delete(int airportId) {
        return "delete from airport where airport_id =" + airportId;
    }

    public String select(int airportId) {
        return "select * from airport where airport_id =" + airportId;
    }
    public String selectAll(){return "select * from airport";}

    public String insert(int airportId, String airportName, String City) {
        return "insert into airport values ('" + airportId + "', '" + airportName + "', '" + City  + "');";
    }
    public String update(int airportId, String newAirportName, String newCity){
        return "update airport set airport_name= '"+newAirportName+"' where airport_id= '"+airportId+"' ;"+
                "update airport set city= '"+newCity+"' where airport_id= '"+airportId+"' ;";
    }
}

