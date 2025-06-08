package model;

import java.util.ArrayList;
import java.util.List;

public class Airplane {
    private String id;
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

    @Override
    public String toString() {
        return "Airplane{" +
                "seats=" + seats.toString() +
                ", capacity=" + capacity +
                '}';
    }
}
