package strategy.impl;

import enums.SeatType;
import strategy.PricingStrategy;

import static constants.ApplicationConstants.BASE_FARE;
import static constants.ApplicationConstants.INVALID_SEAT_TYPE;

public class FestivalPricingStrategy implements PricingStrategy {

    private final SeatType seatType;

    public FestivalPricingStrategy(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public double getPrice() {
        return switch (seatType) {
            case PASSENGER -> BASE_FARE;
            case BUSINESS -> BASE_FARE * 3.2;
            case ECONOMY -> BASE_FARE * 2.1;
            default -> throw new IllegalArgumentException(INVALID_SEAT_TYPE);
        };
    }
}
