package service.impl;

import enums.SeatType;
import model.Airplane;
import model.Seat;
import repository.AircraftRepository;
import repository.impl.AircraftRepositoryImpl;
import service.AirplaneService;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;

public class AirplaneServiceImpl implements AirplaneService {
    private static AirplaneService airplaneService;
    private final AircraftRepository aircraftRepository;

    public static AirplaneService getInstance() {
        if (airplaneService == null) {
            airplaneService = new AirplaneServiceImpl();
        }
        return airplaneService;
    }

    public AirplaneServiceImpl() {
        aircraftRepository = new AircraftRepositoryImpl();
    }

    @Override
    public Airplane addAirplane(int capacity) {
        Airplane airplane = createAirplane(capacity);
        createSeatsAsPerSeatType(capacity, airplane);
        aircraftRepository.createAirplane(airplane);
        return airplane;
    }


    private Airplane createAirplane(int capacity) {
        return new Airplane(generateId(), capacity);
    }

    private void createSeatsAsPerSeatType(int capacity, Airplane airplane) {
        int totalRatio = Arrays.stream(SeatType.values())
                .mapToInt(SeatType::getCountOfSeats)
                .sum();

        List<Seat> seats = new ArrayList<>();
        int seatId = 1;
        for (SeatType type : SeatType.values()) {
            int numSeats = (capacity * type.getCountOfSeats()) / totalRatio;
            for (int i = 0; i < numSeats; i++) {
                seats.add(new Seat(seatId++, type));
            }
        }
        airplane.setSeats(seats);
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
