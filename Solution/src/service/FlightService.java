package service;

import enums.SeatType;
import exceptions.FlightNotFoundException;
import model.Airplane;
import model.Flight;
import model.User;
import strategy.PricingStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public interface FlightService {
    Flight addFlight(String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Airplane airplane);

    List<Flight> searchFlight(String indore, String bangalore, LocalDate reservationDay) throws FlightNotFoundException;

    void bookFlight(Flight flight, User user, SeatType seatType, PricingStrategy pricingStrategy);

    void updateFlight(Flight flight);

    void cancelFlight(Flight flight);

    void cancelBooking(Flight flight, User user);
}
