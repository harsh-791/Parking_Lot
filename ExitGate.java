public class ExitGate {
    int id;

    ExitGate(int id) {
        this.id = id;
    }

    void processPayment(Vehicle vh) {
        Ticket ticket = TicketMap.getTicketByVehicleID(vh.getId());
        ParkingSpot parkingSpot = ticket.getParkingSpot();
        long endTime = System.currentTimeMillis();
        long durationInMinutes = (endTime - ticket.getStartTime()) / (1000);
        int totalFee = (int) (durationInMinutes
                * (parkingSpot.getPricePerMinute() + parkingSpot.totalPriceOfServices()));
        parkingSpot.setOccupied(false);

        System.out.println("Total parking fee paid for ticket ID " + ticket.getId() + " is: $" + totalFee);
    }
}