package enums;

public enum SeatType {
    ECONOMY(2),
    BUSINESS(3),
    PASSENGER(1);

    private final int fareMultiplier;

    SeatType(int fareMultiplier) {
        this.fareMultiplier = fareMultiplier;
    }

    public int getFareMultiplier() {
        return fareMultiplier;
    }
}
