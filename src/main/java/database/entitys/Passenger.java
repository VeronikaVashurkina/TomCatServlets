package database.entitys;

public class Passenger {
    private  int passengerId;
    private String passengerSurname;
    private String passengerName;
    private String passengerMiddleName;
    private String passengerSex;
    private String passengerPassword;
    private String passengerNationality;
    private int airplaneId;

    public Passenger(int passengerId, String passengerSurname, String passengerName, String passengerMiddleName, String passengerSex, String passengerPassword, String passengerNationality, int airplaneId) {
        this.passengerId = passengerId;
        this.passengerSurname = passengerSurname;
        this.passengerName = passengerName;
        this.passengerMiddleName = passengerMiddleName;
        this.passengerSex = passengerSex;
        this.passengerPassword = passengerPassword;
        this.passengerNationality = passengerNationality;
        this.airplaneId = airplaneId;
    }
    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public String getPassengerSurname() {
        return passengerSurname;
    }

    public void setPassengerSurname(String passengerSurname) {
        this.passengerSurname = passengerSurname;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String passengerName) {
        this.passengerName = passengerName;
    }

    public String getPassengerMiddleName() {
        return passengerMiddleName;
    }

    public void setPassengerMiddleName(String passengerMiddleName) {
        this.passengerMiddleName = passengerMiddleName;
    }

    public String getPassengerSex() {
        return passengerSex;
    }

    public void setPassengerSex(String passengerSex) {
        this.passengerSex = passengerSex;
    }

    public String getPassengerPassword() {
        return passengerPassword;
    }

    public void setPassengerPassword(String passengerPassword) {
        this.passengerPassword = passengerPassword;
    }

    public String getPassengerNationality() {
        return passengerNationality;
    }

    public void setPassengerNationality(String passengerNationality) {
        this.passengerNationality = passengerNationality;
    }

    public int getAirplaneId() {
        return airplaneId;
    }

    public void setAirplaneId(int airplaneId) {
        this.airplaneId = airplaneId;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "passengerId=" + passengerId +
                ", passengerSurname='" + passengerSurname + '\'' +
                ", passengerName='" + passengerName + '\'' +
                ", passengerMiddleName='" + passengerMiddleName + '\'' +
                ", passengerSex='" + passengerSex + '\'' +
                ", passengerPassword='" + passengerPassword + '\'' +
                ", passengerNationality='" + passengerNationality + '\'' +
                ", airplaneId=" + airplaneId +
                '}';
    }
}
