public class CarSpot extends ParkingSpot {

    CarSpot(int id) {
        super(id, VehicleType.CAR);
    }

    @Override
    int getPricePerMinute() {
        return 2;
    }
}