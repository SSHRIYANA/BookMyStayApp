/**
 * UseCase3InventorySetup
 *
 * Demonstrates centralized inventory management using HashMap
 * as a single source of truth for room availability.
 *
 * @version 3.0
 */

import java.util.HashMap;

/**
 * RoomInventory class manages room availability centrally
 */
class RoomInventory {

    private HashMap<String, Integer> inventory;

    /**
     * Constructor initializes room availability
     */
    public RoomInventory() {

        inventory = new HashMap<>();

        inventory.put("Single Room", 5);
        inventory.put("Double Room", 3);
        inventory.put("Suite Room", 2);
    }

    /**
     * Get availability of a specific room type
     */
    public int getAvailability(String roomType) {

        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * Update availability of a specific room type
     */
    public void updateAvailability(String roomType, int newCount) {

        inventory.put(roomType, newCount);
    }

    /**
     * Display full inventory status
     */
    public void displayInventory() {

        System.out.println("Current Room Inventory Status:");

        for (String roomType : inventory.keySet()) {

            System.out.println(roomType + " Available: "
                    + inventory.get(roomType));
        }
    }
}


/**
 * Main application class
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Booking Management System v3.0\n");

        // Initialize inventory
        RoomInventory inventory = new RoomInventory();

        // Display inventory
        inventory.displayInventory();

        // Example update
        System.out.println("\nUpdating Single Room availability...\n");

        inventory.updateAvailability("Single Room", 4);

        // Display updated inventory
        inventory.displayInventory();

        System.out.println("\nInventory Initialized Successfully.");
    }
}