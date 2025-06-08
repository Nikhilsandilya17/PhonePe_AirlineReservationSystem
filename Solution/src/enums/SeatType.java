package enums;

public enum SeatType {
    ECONOMY(3),
    BUSINESS(2),
    PASSENGER(5);

    private final int countOfSeats;

    SeatType(int countOfSeats) {
        this.countOfSeats = countOfSeats;
    }

    public int getCountOfSeats() {
        return countOfSeats;
    }
}
