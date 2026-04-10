/**
 * UseCase2RoomInitialization
 *
 * Demonstrates object modeling using abstraction and inheritance
 * for different room types in the Hotel Booking Management System.
 *
 * @version 2.0
 */

/**
 * Abstract Room class representing common room properties
 */
abstract class Room {

    protected int numberOfBeds;
    protected int roomSize;
    protected double price;

    public Room(int numberOfBeds, int roomSize, double price) {
        this.numberOfBeds = numberOfBeds;
        this.roomSize = roomSize;
        this.price = price;
    }

    public void displayRoomDetails() {
        System.out.println("Beds: " + numberOfBeds);
        System.out.println("Room Size: " + roomSize + " sq.ft");
        System.out.println("Price: ₹" + price);
    }
}

/**
 * Single Room class
 */
class SingleRoom extends Room {

    public SingleRoom() {
        super(1, 150, 2000);
    }
}

/**
 * Double Room class
 */
class DoubleRoom extends Room {

    public DoubleRoom() {
        super(2, 250, 3500);
    }
}

/**
 * Suite Room class
 */
class SuiteRoom extends Room {

    public SuiteRoom() {
        super(3, 500, 6000);
    }
}

/**
 * Main application class
 */
public class BookMyStayApp {

    public static void main(String[] args) {

        System.out.println("Hotel Booking Management System v2.0");
        System.out.println("Room Availability Status\n");

        // Create room objects using polymorphism
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Static availability variables
        int singleRoomAvailability = 5;
        int doubleRoomAvailability = 3;
        int suiteRoomAvailability = 2;

        // Display Single Room details
        System.out.println("Single Room Details:");
        singleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + singleRoomAvailability);

        System.out.println();

        // Display Double Room details
        System.out.println("Double Room Details:");
        doubleRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + doubleRoomAvailability);

        System.out.println();

        // Display Suite Room details
        System.out.println("Suite Room Details:");
        suiteRoom.displayRoomDetails();
        System.out.println("Available Rooms: " + suiteRoomAvailability);

        System.out.println("\nSystem Initialized Successfully.");
    }
}