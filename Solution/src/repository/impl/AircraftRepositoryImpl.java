package repository.impl;

import model.Airplane;
import repository.AircraftRepository;

import java.util.HashMap;
import java.util.Map;

public class AircraftRepositoryImpl implements AircraftRepository {
    private final Map<String, Airplane> airplanes;

    public AircraftRepositoryImpl() {
        airplanes = new HashMap<>();
    }

    @Override
    public void createAirplane(Airplane airplane) {
        System.out.println("Saving airplane with capacity: " + airplane.getCapacity());
        airplanes.put(airplane.getId(), airplane);
    }
}
