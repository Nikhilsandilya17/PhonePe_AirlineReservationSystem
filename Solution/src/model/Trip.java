package model;

public class Trip {
    private String id;
    private String origin;
    private String destination;
    private String scheduledFlyTime;
    private Airplane assignedAirplane;
    private int fare;

    public Trip(String id, String origin, String destination, String scheduledFlyTime) {
        this.id = id;
        this.origin = origin;
        this.destination = destination;
        this.scheduledFlyTime = scheduledFlyTime;
        fare = 0;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getScheduledFlyTime() {
        return scheduledFlyTime;
    }

    public void setScheduledFlyTime(String scheduledFlyTime) {
        this.scheduledFlyTime = scheduledFlyTime;
    }

    public Airplane getAssignedAirplane() {
        return assignedAirplane;
    }

    public void setAssignedAirplane(Airplane assignedAirplane) {
        this.assignedAirplane = assignedAirplane;
    }

    public int getFare() {
        return fare;
    }

    public void setFare(int fare) {
        this.fare = fare;
    }
}
