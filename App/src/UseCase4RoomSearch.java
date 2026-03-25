import java.util.*;

// Abstract Room class (same as before)
abstract class Room {
    private String type;
    private int beds;
    private double size;
    private double price;

    public Room(String type, int beds, double size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    public String getType() { return type; }
    public int getBeds() { return beds; }
    public double getSize() { return size; }
    public double getPrice() { return price; }

    public abstract void displayDetails();
}

// Concrete Room classes
class SingleRoom extends Room {
    public SingleRoom() { super("Single Room", 1, 20.0, 50.0); }
    @Override public void displayDetails() {
        System.out.println(getType() + " - Beds: " + getBeds() + ", Size: " + getSize() + " sqm, Price: $" + getPrice());
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() { super("Double Room", 2, 35.0, 80.0); }
    @Override public void displayDetails() {
        System.out.println(getType() + " - Beds: " + getBeds() + ", Size: " + getSize() + " sqm, Price: $" + getPrice());
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() { super("Suite Room", 3, 60.0, 150.0); }
    @Override public void displayDetails() {
        System.out.println(getType() + " - Beds: " + getBeds() + ", Size: " + getSize() + " sqm, Price: $" + getPrice());
    }
}

// Centralized inventory (read/write)
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() { inventory = new HashMap<>(); }

    public void registerRoomType(String roomType, int availableCount) {
        inventory.put(roomType, availableCount);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + change);
    }

    public Map<String, Integer> getInventorySnapshot() {
        // Return a copy to ensure read-only access for search
        return new HashMap<>(inventory);
    }
}

// Search service for Use Case 4
class RoomSearchService {
    private RoomInventory inventory;
    private List<Room> rooms;

    public RoomSearchService(RoomInventory inventory, List<Room> rooms) {
        this.inventory = inventory;
        this.rooms = rooms;
    }

    public void displayAvailableRooms() {
        System.out.println("Available Rooms for Booking:");
        boolean anyAvailable = false;

        Map<String, Integer> snapshot = inventory.getInventorySnapshot();

        for (Room room : rooms) {
            int available = snapshot.getOrDefault(room.getType(), 0);
            if (available > 0) {
                room.displayDetails();
                System.out.println("Available: " + available);
                System.out.println();
                anyAvailable = true;
            }
        }

        if (!anyAvailable) {
            System.out.println("No rooms available at the moment.");
        }
    }
}

// Main application class
public class UseCase4RoomSearch {
    public static void main(String[] args) {
        // Initialize rooms
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();
        List<Room> allRooms = Arrays.asList(singleRoom, doubleRoom, suiteRoom);

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.registerRoomType(singleRoom.getType(), 5);
        inventory.registerRoomType(doubleRoom.getType(), 0); // Example: no double rooms available
        inventory.registerRoomType(suiteRoom.getType(), 2);

        // Initialize search service
        RoomSearchService searchService = new RoomSearchService(inventory, allRooms);

        // Perform search (read-only)
        System.out.println("Welcome to Book My Stay!");
        System.out.println("===========================");
        searchService.displayAvailableRooms();
        System.out.println("Search complete. Inventory state unchanged.");
    }
}