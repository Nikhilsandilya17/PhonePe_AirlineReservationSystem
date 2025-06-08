package service.impl;

import enums.BookingStatus;
import enums.FlightStatus;
import enums.SeatType;
import exceptions.BookingNotFoundException;
import exceptions.FlightNotFoundException;
import exceptions.SeatNotAvailableException;
import model.Airplane;
import model.Booking;
import model.Flight;
import model.Seat;
import model.User;
import repository.BookingRepository;
import repository.FlightRepository;
import repository.impl.BookingRepositoryImpl;
import repository.impl.FlightRepositoryImpl;
import service.FlightService;
import strategy.PricingStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import static constants.ApplicationConstants.BOOKING_CANCELLED;
import static constants.ApplicationConstants.BOOKING_NOT_FOUND_FOR_FLIGHT;
import static constants.ApplicationConstants.BOOKING_NOT_FOUND_FOR_USER;
import static constants.ApplicationConstants.FLIGHTS_NOT_FOUND;
import static constants.ApplicationConstants.FLIGHT_CANCELLED;
import static constants.ApplicationConstants.SEATS_NOT_AVAILABLE;

public class FlightServiceImpl implements FlightService {
    private static FlightService flightService;

    public static FlightService getInstance() {
        if (flightService == null) {
            flightService = new FlightServiceImpl();
        }
        return flightService;
    }

    private final FlightRepository flightRepository;
    private final BookingRepository bookingRepository;

    public FlightServiceImpl() {
        flightRepository = new FlightRepositoryImpl();
        bookingRepository = new BookingRepositoryImpl();
    }


    @Override
    public Flight addFlight(String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Airplane airplane) {
        Flight flight = createFlight(source, destination, departureTime, arrivalTime, airplane);
        flight.setFlightNumber(generateId());
        flightRepository.addFlight(flight);
        return flight;
    }

    @Override
    public List<Flight> searchFlight(String source, String destination, LocalDate reservationDay) throws FlightNotFoundException {
        List<Flight> matchingFlights = flightRepository.getAllFlights().stream()
                .filter(flight -> isMatchingFlight(flight, source, destination, reservationDay))
                .toList();

        if (matchingFlights.isEmpty()) {
            throw new FlightNotFoundException(FLIGHTS_NOT_FOUND + source + " to " + destination);
        }
        System.out.println("Found " + matchingFlights.size() + " flights from " + source + " to " + destination + " on " + reservationDay);
        return matchingFlights;
    }

    @Override
    public void bookFlight(Flight flight, User user, SeatType seatType, PricingStrategy pricingStrategy) throws SeatNotAvailableException {
        Seat selectedSeat = allocateSeat(flight, seatType);
        if (selectedSeat == null) {
            throw new SeatNotAvailableException(SEATS_NOT_AVAILABLE + seatType);
        }
        selectedSeat.setAvailable(false);
        double totalPrice = selectedSeat.getPrice(pricingStrategy);
        Booking booking = new Booking(user.getEmail(), flight, user, selectedSeat, totalPrice);
        booking.setStatus(BookingStatus.CONFIRMED);
        bookingRepository.createBooking(booking);
        System.out.println("Seat " + selectedSeat.getSeatType() + " booked for user " + user.getName() + " costing: " + totalPrice);
    }

    private Seat allocateSeat(Flight flight, SeatType seatType) {
        if (flight.getFlightStatus() != FlightStatus.CANCELLED) {
            for (Seat seat : flight.getAvailableSeats()) {
                if (seat.isAvailable() && seat.getSeatType() == seatType) {
                    return seat;
                }
            }
            return null;
        }
        return null;
    }


    @Override
    public void updateFlight(Flight flight) {
        flight.setFlightStatus(FlightStatus.DELAYED);
    }

    @Override
    public void cancelFlight(Flight flight) {
        flight.setFlightStatus(FlightStatus.CANCELLED);
        Booking booking = bookingRepository.getBookingsByFlight(flight.getFlightNumber());
        if (booking == null) {
            throw new BookingNotFoundException(BOOKING_NOT_FOUND_FOR_FLIGHT + flight.getFlightNumber());
        }
        booking.setStatus(BookingStatus.CANCELLED);
        User passenger = booking.getPassenger();
        notifyUser(passenger);
        System.out.println("Flight " + flight.getFlightNumber() + " has been cancelled.");
    }


    private void notifyUser(User passenger) {
        System.out.println(FLIGHT_CANCELLED + passenger.getName());
    }

    public void cancelBooking(Flight flight, User user) {
        Booking booking = bookingRepository.getBookingByUser(user.getId());
        if (booking != null) {
            Seat seat = booking.getSeats();
            seat.setAvailable(true);
            booking.setStatus(BookingStatus.CANCELLED);
            System.out.println(BOOKING_CANCELLED + user.getName());
        } else {
            throw new BookingNotFoundException(BOOKING_NOT_FOUND_FOR_USER + user.getName());
        }
    }

    private boolean isMatchingFlight(Flight flight, String source, String destination, LocalDate reservationDay) {
        return flight.getOrigin().equalsIgnoreCase(source)
                && flight.getDestination().equalsIgnoreCase(destination)
                && flight.getDepartureTime().toLocalDate().equals(reservationDay);
    }

    private Flight createFlight(String source, String destination, LocalDateTime departureTime, LocalDateTime arrivalTime, Airplane airplane) {
        return new Flight(source, destination, departureTime, arrivalTime, airplane);
    }

    private String generateId() {
        return UUID.randomUUID().toString();
    }
}
