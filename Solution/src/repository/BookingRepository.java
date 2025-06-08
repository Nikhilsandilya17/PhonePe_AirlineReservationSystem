package repository;

import model.Booking;

public interface BookingRepository {
    void createBooking(Booking booking);

    Booking getBookingsByFlight(String flightNumber);

    Booking getBookingByUser(String id);
}
