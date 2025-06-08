package model;

import enums.SeatType;
import strategy.PricingStrategy;

public class Seat {
    private int id;
    private SeatType seatType;
    private boolean isAvailable;

    public Seat(int id, SeatType seatType) {
        this.id = id;
        this.seatType = seatType;
        isAvailable = true;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public SeatType getSeatType() {
        return seatType;
    }

    public void setSeatType(SeatType seatType) {
        this.seatType = seatType;
    }

    public boolean isAvailable() {
        return isAvailable;
    }

    public void setAvailable(boolean available) {
        isAvailable = available;
    }

    @Override
    public String toString() {
        return "Seat{" +
                "seatType=" + seatType +
                '}';
    }

    public double getPrice(PricingStrategy strategy) {
        return strategy.getPrice();
    }


}
