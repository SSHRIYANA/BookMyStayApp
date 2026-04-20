import java.util.HashMap;
import java.util.Map;

// Domain Model
class Room {
    private String type;
    private int beds;
    private int size;
    private double price;

    public Room(String type, int beds, int size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public int getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }
}

// Inventory (State Holder)
class RoomInventory {
    private Map<String, Integer> availability;

    public RoomInventory() {
        availability = new HashMap<>();
    }

    public void setAvailability(String type, int count) {
        availability.put(type, count);
    }

    // Read-only access (defensive copy)
    public Map<String, Integer> getRoomAvailability() {
        return new HashMap<>(availability);
    }
}

// Search Service (Read-only logic)
class RoomSearchService {

    public void searchAvailableRooms(
            RoomInventory inventory,
            Room singleRoom,
            Room doubleRoom,
            Room suiteRoom) {

        Map<String, Integer> availability = inventory.getRoomAvailability();

        System.out.println("=== Room Search Results ===\n");

        if (availability.get("Single") != null && availability.get("Single") > 0) {
            printRoom(singleRoom, availability.get("Single"));
        }

        if (availability.get("Double") != null && availability.get("Double") > 0) {
            printRoom(doubleRoom, availability.get("Double"));
        }

        if (availability.get("Suite") != null && availability.get("Suite") > 0) {
            printRoom(suiteRoom, availability.get("Suite"));
        }
    }

    private void printRoom(Room room, int available) {
        System.out.println(room.getType() + " Room:");
        System.out.println("Beds: " + room.getBeds());
        System.out.println("Size: " + room.getSize() + " sqft");
        System.out.println("Price per night: ₹" + room.getPrice());
        System.out.println("Available: " + available);
        System.out.println();
    }
}

// Main Class (Entry Point)
public class BookMyStayApp {

    public static void main(String[] args) {

        // Room objects (Domain layer)
        Room singleRoom = new Room("Single", 1, 250, 1500.0);
        Room doubleRoom = new Room("Double", 2, 400, 2500.0);
        Room suiteRoom = new Room("Suite", 3, 750, 5000.0);

        // Inventory setup
        RoomInventory inventory = new RoomInventory();
        inventory.setAvailability("Single", 5);
        inventory.setAvailability("Double", 3);
        inventory.setAvailability("Suite", 2);

        // Search (Read-only operation)
        RoomSearchService searchService = new RoomSearchService();
        searchService.searchAvailableRooms(
                inventory,
                singleRoom,
                doubleRoom,
                suiteRoom
        );
    }
}