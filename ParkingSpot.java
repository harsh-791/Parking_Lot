import java.util.Set;
import java.util.HashSet;

public abstract class ParkingSpot {
    private int id;
    private boolean isOccupied;
    private VehicleType type;
    private Set<Service> supportedServices;

    ParkingSpot(int id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.supportedServices = new HashSet<>();
        this.isOccupied = false;
    }

    ParkingSpot addService(Service service) {
        this.supportedServices.add(service);
        return this;
    }

    VehicleType getType() {
        return type;
    }

    Set<Service> getSupportedServices() {
        return supportedServices;
    }

    boolean isOccupied() {
        return isOccupied;
    }

    void setOccupied(boolean occupied) {
        isOccupied = occupied;
    }

    int totalPriceOfServices() {
        int total = 0;
        for (Service service : supportedServices) {
            total += service.getPriceRate();
        }
        return total;
    }

    int getId() {
        return id;
    }

    abstract int getPricePerMinute();
}
