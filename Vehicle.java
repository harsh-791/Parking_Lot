import java.util.HashSet;
import java.util.Set;

public class Vehicle {
    String id;
    VehicleType type;
    Set<Service> reqServices;

    Vehicle(String id, VehicleType type) {
        this.id = id;
        this.type = type;
        this.reqServices = new HashSet<>();
    }

    VehicleType getType() {
        return type;
    }

    Set<Service> getReqServices() {
        return reqServices;
    }

    String getId() {
        return id;
    }

    Vehicle addService(Service reqService) {
        this.reqServices.add(reqService);
        return this;
    }
}