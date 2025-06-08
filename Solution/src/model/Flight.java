package model;

import enums.FlightStatus;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

public class Flight {

    /**
     * a journey by air
     * an airplane that takes you on a particular journey, So there is a diff between a flight and an airplane.
     */

    private String flightNumber;
    private String origin;
    private String destination;
    private LocalDateTime departureTime;
    private LocalDateTime arrivalTime;
    private FlightStatus flightStatus;
    private final Airplane assignedAirplane;
    private Map<String, String> seatMapping;
    private List<Seat> availableSeats;

    public Flight(String origin, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Airplane assignedAirplane) {
        this.origin = origin;
        this.destination = destination;
        this.departureTime = departureTime;
        this.arrivalTime = arrivalTime;
        this.flightStatus = FlightStatus.ON_TIME;
        this.assignedAirplane = assignedAirplane;
        this.availableSeats = this.assignedAirplane.getSeats();
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public void setFlightNumber(String flightNumber) {
        this.flightNumber = flightNumber;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public LocalDateTime getDepartureTime() {
        return departureTime;
    }

    public void setDepartureTime(LocalDateTime departureTime) {
        this.departureTime = departureTime;
    }

    public LocalDateTime getArrivalTime() {
        return arrivalTime;
    }

    public void setArrivalTime(LocalDateTime arrivalTime) {
        this.arrivalTime = arrivalTime;
    }

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Airplane getAssignedAirplane() {
        return assignedAirplane;
    }


    public List<Seat> getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(List<Seat> availableSeats) {
        this.availableSeats = availableSeats;
    }
}
