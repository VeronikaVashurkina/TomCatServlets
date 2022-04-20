package database.query;

public class PassengerQuery {
    public String delete(int passengerId) {
        return "delete from passenger where passenger_id =" + passengerId;
    }

    public String select(int passengerId) {
        return "select * from passenger where passenger_id =" + passengerId;
    }

    public String selectAll(){return "select * from passenger";}
    public String insert(int passengerId, String passengerSurname, String passengerName, String passengerMiddleName,String passengerSex,String passengerPassword,String passengerNationality,int airplaneId) {
        return "insert into passenger values ('" + passengerId + "', '" + passengerSurname + "', '" + passengerName + "', '" + passengerMiddleName +"', '" + passengerSex +"', '" + passengerPassword +"', '" + passengerNationality +"', '" + airplaneId + "');";
    }
    public String update(int passengerId, String newPassengerSurname, String newPassengerName, String newPassengerMiddleName,String newPassengerSex,String newPassengerPassword,String newPassengerNationality,int newAirplaneId){
        return "update passenger set passenger_surname= '"+newPassengerSurname+"' where passenger_id= '"+passengerId+"' ;"+
                "update passenger set passenger_name= '"+newPassengerName+"' where passenger_id= '"+passengerId+"' ;"+
                "update passenger set passenger_middle_name= '"+newPassengerMiddleName+"' where passenger_id= '"+passengerId+"' ;"+
                "update passenger set passenger_sex= '"+newPassengerSex+"' where passenger_id= '"+passengerId+"' ;"+
                "update passenger set passenger_password= '"+newPassengerPassword+"' where passenger_id= '"+passengerId+"' ;"+
                "update passenger set passenger_nationality= '"+newPassengerNationality+"' where passenger_id= '"+passengerId+"' ;"+
                "update passenger set airplane_id= '"+newAirplaneId+"' where passenger_id= '"+passengerId+"' ;";
    }
}

