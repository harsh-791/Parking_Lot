public class LargeVehicleSpot extends ParkingSpot {
    private static final int BASE_PRICE_PER_MINUTE = 5;

    LargeVehicleSpot(int id) {
        super(id, VehicleType.LARGE_VH);
    }

    @Override
    int getPricePerMinute() {
        return BASE_PRICE_PER_MINUTE;
    }
}
