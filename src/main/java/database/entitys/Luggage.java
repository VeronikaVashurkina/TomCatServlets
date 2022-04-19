package database.entitys;

public class Luggage {
    private int luggageId;
    private int luggageWeight;
    private int passengerId;

    public int getLuggageId() {
        return luggageId;
    }

    public void setLuggageId(int luggageId) {
        this.luggageId = luggageId;
    }

    public int getLuggageWeight() {
        return luggageWeight;
    }

    public void setLuggageWeight(int luggageWeight) {
        this.luggageWeight = luggageWeight;
    }

    public int getPassengerId() {
        return passengerId;
    }

    public void setPassengerId(int passengerId) {
        this.passengerId = passengerId;
    }

    public Luggage(int luggageId, int luggageWeight, int passengerId) {
        this.luggageId = luggageId;
        this.luggageWeight = luggageWeight;
        this.passengerId = passengerId;
    }
}
