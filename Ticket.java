public class Ticket {
    private int id;
    private ParkingSpot parkingSpot;
    private long startTime;

    Ticket(int id, ParkingSpot parkingSpot, long startTime) {
        this.id = id;
        this.parkingSpot = parkingSpot;
        this.startTime = startTime;
    }

    public int getId() {
        return id;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public long getStartTime() {
        return startTime;
    }
}