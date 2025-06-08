package model;

import enums.BookingStatus;

public class Booking {
    private String id;
    private Flight flight;
    private User passenger;
    private Seat seats;
    private double totalPrice;
    private BookingStatus status;

    public Booking(String id, Flight flight, User passenger, Seat seats, double totalPrice) {
        this.id = id;
        this.flight = flight;
        this.passenger = passenger;
        this.seats = seats;
        this.totalPrice = totalPrice;
        this.status = BookingStatus.PENDING;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public User getPassenger() {
        return passenger;
    }

    public void setPassenger(User passenger) {
        this.passenger = passenger;
    }

    public Seat getSeats() {
        return seats;
    }

    public void setSeats(Seat seats) {
        this.seats = seats;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
