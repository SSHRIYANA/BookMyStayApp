// Abstract class representing a generic room
abstract class Room {
    private String type;
    private int beds;
    private double price;
    private double size; // in square meters

    // Constructor
    public Room(String type, int beds, double size, double price) {
        this.type = type;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }

    // Getter methods
    public String getType() {
        return type;
    }

    public int getBeds() {
        return beds;
    }

    public double getPrice() {
        return price;
    }

    public double getSize() {
        return size;
    }

    // Abstract method to display room details
    public abstract void displayDetails();
}

// Concrete room classes
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

// Main application class
public class UseCase2RoomInitialization {

    public static void main(String[] args) {
        // Static availability variables
        int singleRoomAvailable = 5;
        int doubleRoomAvailable = 3;
        int suiteRoomAvailable = 2;

        // Create room objects
        Room singleRoom = new SingleRoom();
        Room doubleRoom = new DoubleRoom();
        Room suiteRoom = new SuiteRoom();

        // Display room details and availability
        System.out.println("Welcome to Book My Stay!");
        System.out.println("===========================");

        singleRoom.displayDetails();
        System.out.println("Available: " + singleRoomAvailable);
        System.out.println();

        doubleRoom.displayDetails();
        System.out.println("Available: " + doubleRoomAvailable);
        System.out.println();

        suiteRoom.displayDetails();
        System.out.println("Available: " + suiteRoomAvailable);
        System.out.println();

        System.out.println("Thank you for visiting!");
    }
}