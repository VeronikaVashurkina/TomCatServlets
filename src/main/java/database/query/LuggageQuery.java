package database.query;

public class LuggageQuery {
    public String delete(int luggageId) {
        return "delete from luggage where luggage_id =" + luggageId;
    }

    public String select(int luggageId) {
        return "select * from luggage where luggage_id =" + luggageId;
    }

    public String selectAll(){return "select * from luggage";}
    public String insert(int luggageId, int luggageWeight, int passengerId) {
        return "insert into luggage values ('" + luggageId + "', '" + luggageWeight + "', '" + passengerId +  "');";
    }
    public String update(int luggageId, int newLuggageWeight, int newPassengerId){
        return "update luggage set luggage_weight= '"+newLuggageWeight+"' where luggage_id= '"+luggageId+"' ;"+
                "update luggage set passenger_id= '"+newPassengerId+"' where luggage_id= '"+luggageId+"' ;";
    }
}

