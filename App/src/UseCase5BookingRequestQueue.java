import java.util.LinkedList;
import java.util.Queue;

// Reservation class representing a guest's booking request
class Reservation {
    private String guestName;
    private String roomType;
    private int requestedRooms;

    public Reservation(String guestName, String roomType, int requestedRooms) {
        this.guestName = guestName;
        this.roomType = roomType;
        this.requestedRooms = requestedRooms;
    }

    public String getGuestName() { return guestName; }
    public String getRoomType() { return roomType; }
    public int getRequestedRooms() { return requestedRooms; }

    public void displayRequest() {
        System.out.println("Guest: " + guestName +
                " | Room Type: " + roomType +
                " | Rooms Requested: " + requestedRooms);
    }
}

// Booking request queue (FIFO)
class BookingRequestQueue {
    private Queue<Reservation> requestQueue;

    public BookingRequestQueue() {
        requestQueue = new LinkedList<>();
    }

    // Add a reservation request to the queue
    public void submitRequest(Reservation reservation) {
        requestQueue.add(reservation);
        System.out.println("Booking request submitted for " + reservation.getGuestName());
    }

    // Peek at the next request without removing it
    public Reservation peekNextRequest() {
        return requestQueue.peek();
    }

    // Process the next request (removes from queue)
    public Reservation processNextRequest() {
        return requestQueue.poll();
    }

    // Display all queued requests
    public void displayAllRequests() {
        System.out.println("Current Booking Queue:");
        if (requestQueue.isEmpty()) {
            System.out.println("No pending requests.");
            return;
        }
        for (Reservation r : requestQueue) {
            r.displayRequest();
        }
        System.out.println();
    }
}

// Main application class
public class UseCase5BookingRequestQueue {
    public static void main(String[] args) {
        BookingRequestQueue bookingQueue = new BookingRequestQueue();

        // Example booking requests
        Reservation r1 = new Reservation("Alice", "Single Room", 1);
        Reservation r2 = new Reservation("Bob", "Double Room", 2);
        Reservation r3 = new Reservation("Charlie", "Suite Room", 1);

        // Submit requests (arrival order preserved)
        bookingQueue.submitRequest(r1);
        bookingQueue.submitRequest(r2);
        bookingQueue.submitRequest(r3);

        System.out.println();
        bookingQueue.displayAllRequests();

        // Peek at the next request to be processed
        Reservation next = bookingQueue.peekNextRequest();
        System.out.println("Next request to process:");
        if (next != null) {
            next.displayRequest();
        }
    }
}