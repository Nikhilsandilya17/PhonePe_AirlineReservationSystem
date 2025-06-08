package repository;

import model.Flight;

import java.util.List;

public interface FlightRepository {
    void addFlight(Flight flight);

    List<Flight> getAllFlights();
}
