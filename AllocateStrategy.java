import java.util.List;

public class AllocateStrategy {

    public ParkingSpot allocateSpot(Vehicle vehicle, List<ParkingSpot> availableSpots) {
        int minServiceCount = Integer.MAX_VALUE;
        ParkingSpot bestSpot = null;
        for (ParkingSpot spot : availableSpots) {
            if (isEligible(vehicle, spot)) {
                int serviceCount = spot.getSupportedServices().size();
                if (serviceCount < minServiceCount) {
                    minServiceCount = serviceCount;
                    bestSpot = spot;
                }
            }
        }
        if (bestSpot != null) {
            bestSpot.setOccupied(true);
        }
        return bestSpot;
    }

    boolean isEligible(Vehicle vehicle, ParkingSpot spot) {
        if (spot.isOccupied()) {
            return false;
        }
        if (spot.getType() != vehicle.getType()) {
            return false;
        }
        for (Service reqService : vehicle.getReqServices()) {
            if (!spot.getSupportedServices().contains(reqService)) {
                return false;
            }
        }
        return true;
    }
}