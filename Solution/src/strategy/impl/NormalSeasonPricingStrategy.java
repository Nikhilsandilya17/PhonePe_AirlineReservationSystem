package strategy.impl;

import enums.SeatType;
import strategy.PricingStrategy;

import static constants.ApplicationConstants.BASE_FARE;
import static constants.ApplicationConstants.INVALID_SEAT_TYPE;

public class NormalSeasonPricingStrategy implements PricingStrategy {
    private final SeatType seatType;

    public NormalSeasonPricingStrategy(SeatType seatType) {
        this.seatType = seatType;
    }

    @Override
    public double getPrice() {
        return switch (seatType) {
            case PASSENGER -> BASE_FARE;
            case BUSINESS -> BASE_FARE * 3;
            case ECONOMY -> BASE_FARE * 2;
            default -> throw new IllegalArgumentException(INVALID_SEAT_TYPE);
        };
    }
}