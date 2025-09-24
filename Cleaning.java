public class Cleaning implements Service {
    private static final int CLEANING_RATE = 2;
    private static final String SERVICE_NAME = "Cleaning";

    @Override
    public int getPriceRate() {
        return CLEANING_RATE;
    }

    @Override
    public String getServiceName() {
        return SERVICE_NAME;
    }

    @Override
    public String toString() {
        return SERVICE_NAME + " (Rate: $" + CLEANING_RATE + "/minute)";
    }
}
