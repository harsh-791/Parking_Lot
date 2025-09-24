public class BikeSpot extends ParkingSpot {

    BikeSpot(int id) {
        super(id, VehicleType.BIKE);
    }

    @Override
    int getPricePerMinute() {
        return 1;
    }
}