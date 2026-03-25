import java.util.HashMap;
import java.util.Map;

// Abstract Room class (reuse from previous version)
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

    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public double getSize() {
        return size;
    }

    public double getPrice() {
        return price;
    }

    public abstract void displayDetails();
}

// Concrete Room classes
class SingleRoom extends Room {
    public SingleRoom() {
        super("Single Room", 1, 20.0, 50.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(getType() + " - Beds: " + getBeds() + ", Size: " + getSize() + " sqm, Price: $" + getPrice());
    }
}

class DoubleRoom extends Room {
    public DoubleRoom() {
        super("Double Room", 2, 35.0, 80.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(getType() + " - Beds: " + getBeds() + ", Size: " + getSize() + " sqm, Price: $" + getPrice());
    }
}

class SuiteRoom extends Room {
    public SuiteRoom() {
        super("Suite Room", 3, 60.0, 150.0);
    }

    @Override
    public void displayDetails() {
        System.out.println(getType() + " - Beds: " + getBeds() + ", Size: " + getSize() + " sqm, Price: $" + getPrice());
    }
}

// Centralized Room Inventory
class RoomInventory {
    private Map<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
    }

    // Register a room type with initial availability
    public void registerRoomType(String roomType, int availableCount) {
        inventory.put(roomType, availableCount);
    }

    // Get current availability for a room type
    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    // Update availability after booking or cancellation
    public void updateAvailability(String roomType, int change) {
        int current = inventory.getOrDefault(roomType, 0);
        inventory.put(roomType, current + change);
    }

    // Display the full inventory state
    public void displayInventory() {
        System.out.println("Current Room Inventory:");
        for (String roomType : inventory.keySet()) {
            System.out.println(roomType + ": " + inventory.get(roomType) + " available");
        }
        System.out.println();
    }
}

// Main application class
public class UseCase3InventorySetup {
    public static void main(String[] args) {
        // Initialize rooms
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();
        inventory.registerRoomType(singleRoom.getType(), 5);
        inventory.registerRoomType(doubleRoom.getType(), 3);
        inventory.registerRoomType(suiteRoom.getType(), 2);

        // Display room details
        System.out.println("Welcome to Book My Stay!");
        System.out.println("===========================");
        singleRoom.displayDetails();
        doubleRoom.displayDetails();
        suiteRoom.displayDetails();
        System.out.println();

        // Display inventory
        inventory.displayInventory();

        // Example of booking a room
        System.out.println("Booking 1 Single Room...");
        inventory.updateAvailability(singleRoom.getType(), -1);

        // Display inventory after update
        inventory.displayInventory();

        System.out.println("Thank you for visiting!");
    }
}