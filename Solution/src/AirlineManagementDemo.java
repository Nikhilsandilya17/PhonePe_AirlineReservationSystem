import enums.SeatType;
import exceptions.FlightNotFoundException;
import model.Airplane;
import model.Flight;
import model.User;
import service.AirplaneService;
import service.FlightService;
import service.UserService;
import service.impl.AirplaneServiceImpl;
import service.impl.FlightServiceImpl;
import service.impl.UserServiceImpl;
import strategy.PricingStrategy;
import strategy.impl.NormalSeasonPricingStrategy;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public class AirlineManagementDemo {
    public static void main(String[] args) throws FlightNotFoundException {
        UserService userService = UserServiceImpl.getInstance();
        AirplaneService airplaneService = AirplaneServiceImpl.getInstance();
        FlightService flightService = FlightServiceImpl.getInstance();

        User user1 = userService.registerUser("Nikhil", "nikhil@gcom");
        User user2 = userService.registerUser("Sandy", "sandy@gcom");

        Airplane airplane1 = airplaneService.addAirplane(10);
        Airplane airplane2 = airplaneService.addAirplane(5);

        //Add a new Flight
        LocalDateTime departureTime1 = LocalDateTime.now().plusDays(1);
        LocalDateTime arrivalTime1 = departureTime1.plusHours(2);
        Flight flight1 = flightService.addFlight("Indore", "Bangalore", departureTime1, arrivalTime1, airplane1);
        System.out.println(flight1.getFlightNumber());

        LocalDateTime departureTime2 = LocalDateTime.now().plusDays(2);
        LocalDateTime arrivalTime2 = departureTime2.plusHours(3);
        Flight flight2 = flightService.addFlight("Delhi", "Mumbai", departureTime2, arrivalTime2, airplane2);
        System.out.println(flight2.getFlightNumber());

        //Search for a flight
        List<Flight> searchResults = flightService.searchFlight("Indore", "Bangalore", LocalDate.now().plusDays(1));

        if (!searchResults.isEmpty()) {
            PricingStrategy pricingStrategy = new NormalSeasonPricingStrategy(SeatType.ECONOMY);
            flightService.bookFlight(searchResults.get(0), user1, SeatType.ECONOMY, pricingStrategy);
        }

        flightService.updateFlight(flight2);
        try {
            flightService.cancelFlight(flight2);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        flightService.cancelBooking(flight1, user1);

    }

}
