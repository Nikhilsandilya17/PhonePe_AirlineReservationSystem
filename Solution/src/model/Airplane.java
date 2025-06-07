package model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private String id;
    private Trip currentTrip;
    private int capacity;
    private List<Seat> seats;

    public Airplane(String id, int capacity) {
        this.id = id;
        this.capacity = capacity;
        seats = new ArrayList<>();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Trip getCurrentTrip() {
        return currentTrip;
    }

    public void setCurrentTrip(Trip currentTrip) {
        this.currentTrip = currentTrip;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Seat> getSeats() {
        return seats;
    }

    public void setSeats(List<Seat> seats) {
        this.seats = seats;
    }
}
