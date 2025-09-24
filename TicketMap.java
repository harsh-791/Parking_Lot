import java.util.HashMap;
import java.util.Map;

public class TicketMap {
    static Map<String, Ticket> ticketMap = new HashMap<>();

    public static void addTicket(String vehicleID, Ticket ticket) {
        ticketMap.put(vehicleID, ticket);
    }

    public static Ticket getTicketByVehicleID(String vehicleID) {
        return ticketMap.get(vehicleID);
    }
}