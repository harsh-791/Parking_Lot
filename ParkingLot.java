import java.util.List;
import java.util.Scanner;

public class ParkingLot {
    public static void main(String[] args) throws InterruptedException {
        Service electricService = new Charging();
        Service cleaningService = new Cleaning();

        ParkingSpot spot1 = new BikeSpot(1).addService(electricService);
        ParkingSpot spot2 = new CarSpot(2).addService(electricService);
        ParkingSpot spot3 = new LargeVehicleSpot(3).addService(electricService);
        ParkingSpot spot4 = new BikeSpot(4);
        ParkingSpot spot5 = new CarSpot(5);
        ParkingSpot spot6 = new LargeVehicleSpot(6);

        List<ParkingSpot> parkingSpots = List.of(spot1, spot2, spot3, spot4, spot5, spot6);
        EntryGate entryGate = new EntryGate(1, parkingSpots);
        ExitGate exitGate = new ExitGate(1);

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("Enter vehicle type (BIKE, CAR, LARGE) or WQ to quit:");
            String vehicleTypeInput = scanner.nextLine();
            if (vehicleTypeInput.equalsIgnoreCase("WQ")) {
                break;
            }

            VehicleType vehicleType;
            try {
                vehicleType = VehicleType.valueOf(vehicleTypeInput.toUpperCase());
            } catch (IllegalArgumentException e) {
                System.out.println("Invalid vehicle type. Please try again.");
                continue;
            }

            Vehicle vehicle = new Vehicle("MP09", vehicleType);
            while (true) {
                System.out.println("Enter required service (ELECTRIC, CLEANING) or DONE to finish:");
                String serviceInput = scanner.nextLine();
                if (serviceInput.equalsIgnoreCase("DONE")) {
                    break;
                }
                if (serviceInput.equalsIgnoreCase("ELECTRIC")) {
                    vehicle.addService(electricService);
                } else if (serviceInput.equalsIgnoreCase("CLEANING")) {
                    vehicle.addService(cleaningService);
                } else {
                    System.out.println("Invalid service. Please try again.");
                }
            }
            try {
                Ticket ticket = entryGate.generateTicket(vehicle);
                System.out.println("Ticket generated: " + ticket.getParkingSpot().getType() + " Spot ID: "
                        + ticket.getParkingSpot().getId());
                Thread.sleep(10000);
                exitGate.processPayment(vehicle);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        scanner.close();
    }
}


