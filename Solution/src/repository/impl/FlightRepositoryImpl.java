package repository.impl;

import model.Flight;
import repository.FlightRepository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FlightRepositoryImpl implements FlightRepository {

    private final Map<String, Flight> flights;

    public FlightRepositoryImpl() {
        flights = new HashMap<>();
    }

    @Override
    public void addFlight(Flight flight) {
        System.out.println("Creating flight from " + flight.getOrigin() + " to" + flight.getDestination());
        flights.put(flight.getFlightNumber(), flight);
    }

    @Override
    public List<Flight> getAllFlights() {
        return new ArrayList<>(flights.values());
    }
}
