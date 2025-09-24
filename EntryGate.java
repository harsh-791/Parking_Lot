import java.util.List;

public class EntryGate {
    int id;
    int ticketId;
    List<ParkingSpot> parkingSpots;
    AllocateStrategy allocateStrategy = new AllocateStrategy();

    EntryGate(int id, List<ParkingSpot> parkingSpots) {
        this.id = id;
        this.parkingSpots = parkingSpots;
        this.ticketId = 1;
    }

    Ticket generateTicket(Vehicle vehicle) {
        ParkingSpot allocatedSpot = allocateStrategy.allocateSpot(vehicle, parkingSpots);
        if (allocatedSpot == null) {
            throw new IllegalArgumentException("No suitable parking spot available.");
        }
        Ticket ticket = new Ticket(ticketId++, allocatedSpot, System.currentTimeMillis());
        TicketMap.addTicket(vehicle.getId(), ticket);
        return ticket;
    }
}