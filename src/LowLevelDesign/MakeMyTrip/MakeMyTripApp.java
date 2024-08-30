package LowLevelDesign.MakeMyTrip;

import java.util.*;

public class MakeMyTripApp {
    public static void main(String[] args) {
        // Create instances of FlightController, Admins, and Customers
        FlightController flightController = new FlightController();

        // Create Admins with unique IDs
        Admin admin1 = new Admin(1);
        Admin admin2 = new Admin(2);

        // Create Customers with unique IDs and initial seat as null
        Customer customer1 = new Customer(new HashSet<>(), null, 1);
        Customer customer2 = new Customer(new HashSet<>(), null, 2);

        // Create some seats with types
        Seat seat1 = new Seat(101, SeatType.ECONOMY);
        Seat seat2 = new Seat(102, SeatType.PREMIUM);
        Seat seat3 = new Seat(201, SeatType.ECONOMY);

        // Create flights and add seats to them
        Flight flight1 = new Flight(1, 101, "New York", "Los Angeles", "2024-09-15");
        flight1.availableSeats.add(seat1);
        flight1.availableSeats.add(seat2);

        Flight flight2 = new Flight(2, 102, "San Francisco", "Chicago", "2024-09-16");
        flight2.availableSeats.add(seat3);

        // Admins add flights
        flightController.addFlight(admin1, flight1);
        flightController.addFlight(admin2, flight2);

        // Customers search for flights
        List<Flight> flightsFromNYToLA = flightController.fetchFlight("New York", "Los Angeles", "2024-09-15");
        List<Flight> flightsFromSFToChicago = flightController.fetchFlight("San Francisco", "Chicago", "2024-09-16");

        // Customers book seats
        if (!flightsFromNYToLA.isEmpty()) {
            flightController.book(customer1, flightsFromNYToLA.get(0), seat1);
            System.out.println("Customer 1 booked seat " + seat1.seatId + " on flight " + flightsFromNYToLA.get(0).flightId);
        }

        if (!flightsFromSFToChicago.isEmpty()) {
            flightController.book(customer2, flightsFromSFToChicago.get(0), seat3);
            System.out.println("Customer 2 booked seat " + seat3.seatId + " on flight " + flightsFromSFToChicago.get(0).flightId);
        }

        // Customers cancel bookings
        flightController.cancelBooking(customer1, flightsFromNYToLA.get(0));
        System.out.println("Customer 1 canceled their booking.");

        // Verify the seat has been made available again
        Set<Seat> availableSeats = flightController.availableFlightSeats(flightsFromNYToLA.get(0));
        System.out.println("Available seats on flight " + flightsFromNYToLA.get(0).flightId + ": " + availableSeats.size());

        // Print booked flights for customers
        System.out.println("Customer 1 booked flights: " + customer1.getBookedFlights().size());
        System.out.println("Customer 2 booked flights: " + customer2.getBookedFlights().size());
    }
}

class FlightController {
    private List<Flight> activeFlights;

    FlightController() {
        activeFlights = new ArrayList<>();
    }

    public void book(Customer customer, Flight flight, Seat seat) {
        if (flight.availableSeats.contains(seat)) {
            if (!flight.userMap.containsKey(seat)) {
                customer.setSeat(seat);
                customer.addFlight(flight); // Add to booked flights
                flight.availableSeats.remove(seat);
                flight.userMap.put(seat, customer);
                System.out.println("Booking successful.");
            } else {
                System.out.println("Seat is already booked.");
            }
        } else {
            System.out.println("Seat not available.");
        }
    }

    public void cancelBooking(Customer customer, Flight flight) {
        Seat seat = customer.getSeat();
        if (seat != null && flight.userMap.containsKey(seat) && flight.userMap.get(seat).equals(customer)) {
            customer.removeFlight(flight); // Remove from booked flights
            flight.availableSeats.add(seat);
            flight.userMap.remove(seat);
            customer.setSeat(null); // Reset seat after cancellation
            System.out.println("Flight " + flight.flightId + " booking has been cancelled.");
        } else {
            System.out.println("No such booking exists.");
        }
    }

    public void addFlight(Admin admin, Flight flight) {
        if (!activeFlights.contains(flight)) {
            activeFlights.add(flight);
            System.out.println("Flight added successfully.");
        } else {
            System.out.println("Flight already exists.");
        }
    }

    public void removeFlight(Admin admin, Flight flight) {
        if (activeFlights.remove(flight)) {
            System.out.println("Flight removed successfully.");
        } else {
            System.out.println("Flight not found.");
        }
    }

    public List<Flight> fetchFlight(String start, String end, String date) {
        List<Flight> flights = new ArrayList<>();
        for (Flight flight : activeFlights) {
            if (flight.start.equals(start) && flight.end.equals(end) && flight.date.equals(date)) {
                flights.add(flight);
            }
        }
        return flights;
    }

    public Set<Seat> availableFlightSeats(Flight flight) {
        if (flight.availableSeats.isEmpty()) {
            System.out.println("No available seats found.");
            return new HashSet<>();
        }
        return flight.availableSeats;
    }
}

class User {
    int userId;

    public User(int userId) {
        this.userId = userId;
    }
}

class Customer extends User {
    private Set<Flight> bookedFlights;
    private Seat seat;

    public Customer(Set<Flight> bookedFlights, Seat seat, int customerId) {
        super(customerId);
        this.bookedFlights = bookedFlights;
        this.seat = seat;
    }

    public void addFlight(Flight flight) {
        bookedFlights.add(flight);
    }

    public void removeFlight(Flight flight) {
        bookedFlights.remove(flight);
    }

    public Set<Flight> getBookedFlights() {
        return bookedFlights;
    }

    public void setSeat(Seat seat) {
        this.seat = seat;
    }

    public Seat getSeat() {
        return seat;
    }
}

class Admin extends User {
    public Admin(int adminId) {
        super(adminId);
    }
}

class Flight {
    int flightId;
    int tripId;
    String start;
    String end;
    String date;
    Set<Seat> availableSeats;
    Map<Seat, Customer> userMap;

    public Flight(int flightId, int tripId, String start, String end, String date) {
        this.flightId = flightId;
        this.tripId = tripId;
        this.start = start;
        this.end = end;
        this.date = date;
        this.availableSeats = new HashSet<>();
        this.userMap = new HashMap<>();
    }
}

class Seat {
    int seatId;
    SeatType type;

    public Seat(int seatId, SeatType type) {
        this.seatId = seatId;
        this.type = type;
    }
}

enum SeatType {
    ECONOMY, PREMIUM;
}
