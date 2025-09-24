public class Charging implements Service {
    private static final int CHARGING_RATE = 3;
    private static final String SERVICE_NAME = "Charging";

    @Override
    public int getPriceRate() {
        return CHARGING_RATE;
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override
    public String toString() {
        return SERVICE_NAME + " (Rate: $" + CHARGING_RATE + "/minute)";
    }
}
