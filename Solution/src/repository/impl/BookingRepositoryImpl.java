package repository.impl;

import model.Booking;
import repository.BookingRepository;

import java.util.HashMap;
import java.util.Map;

public class BookingRepositoryImpl implements BookingRepository {
    private final Map<String, Booking> bookings;

    public BookingRepositoryImpl() {
        bookings = new HashMap<>();
    }

    @Override
    public void createBooking(Booking booking) {
        System.out.println("Booking created: " + booking.getId());
        bookings.put(booking.getPassenger().getId(), booking);
    }

    @Override
    public Booking getBookingsByFlight(String flightNumber) {
        System.out.println("Retrieving bookings for flight: " + flightNumber);
        return bookings.values().stream()
                .filter(booking -> booking.getFlight().getFlightNumber().equals(flightNumber))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Booking getBookingByUser(String id) {
        return bookings.get(id);
    }
}
