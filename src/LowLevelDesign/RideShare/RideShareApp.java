package LowLevelDesign.RideShare;

import java.util.*;

public class RideShareApp {
    public static void main(String[] args) {
        RideService rideService = new RideService();

        Vehicle vehicle1 = new Vehicle(1, 4);
        Driver driver1 = new Driver(1, vehicle1);
        rideService.registerDriver(driver1);

        Rider rider1 = new Rider(1);
        rideService.registerRider(rider1);

        Ride ride1 = rideService.createRide(driver1, "A", "B", 2, 10);
        rideService.bookRide(rider1, ride1);
        rideService.generateBill(ride1);

        System.out.println("Driver's Revenue: " + rideService.fetchDriverRevenue(driver1));
    }
}
abstract class User {
    int userId;

    public User(int userId) {
        this.userId = userId;
    }

    public int getUserId() {
        return userId;
    }
}

class Driver extends User {
    int driverId;
    Vehicle vehicle;
    List<Ride> ridesTaken;

    public Driver(int driverId, Vehicle vehicle) {
        super(driverId);
        this.driverId = driverId;
        this.vehicle = vehicle;
        this.ridesTaken = new ArrayList<>();
    }

    public int getDriverId() {
        return driverId;
    }

    public void addRide(Ride ride) {
        ridesTaken.add(ride);
    }

    public List<Ride> getRidesTaken() {
        return ridesTaken;
    }

    public double fetchRevenue() {
        double totalRevenue = 0.0;
        for (Ride ride : ridesTaken) {
            totalRevenue += ride.getAmountCharged();
        }
        return totalRevenue;
    }
}

class Rider extends User {
    int riderId;
    List<Ride> ridesBooked;

    public Rider(int riderId) {
        super(riderId);
        this.riderId = riderId;
        this.ridesBooked = new ArrayList<>();
    }

    public int getRiderId() {
        return riderId;
    }

    public void addRide(Ride ride) {
        ridesBooked.add(ride);
    }

    public List<Ride> getRidesBooked() {
        return ridesBooked;
    }
}

class Vehicle {
    int vehicleId;
    int seats;

    public Vehicle(int vehicleId, int seats) {
        this.vehicleId = vehicleId;
        this.seats = seats;
    }

    public int getSeats() {
        return seats;
    }
}

class Ride {
    int rideId;
    String origin;
    String destination;
    int seats;
    int distance;
    double amountCharged;
    String status;

    public Ride(int rideId, String origin, String destination, int seats, int distance) {
        this.rideId = rideId;
        this.origin = origin;
        this.destination = destination;
        this.seats = seats;
        this.distance = distance;
        this.status = "ONGOING";
        this.amountCharged = calculateAmount();
    }

    private double calculateAmount() {
        double ratePerKM = 10; // Example rate per KM
        if (seats >= 2) {
            return distance * seats * 0.75 * ratePerKM;
        } else {
            return distance * ratePerKM;
        }
    }

    public void closeRide() {
        this.status = "COMPLETED";
    }

    public double getAmountCharged() {
        return amountCharged;
    }

    public String getStatus() {
        return status;
    }
}

class RideService {
    List<Driver> drivers;
    List<Rider> riders;
    List<Ride> rides;

    public RideService() {
        this.drivers = new ArrayList<>();
        this.riders = new ArrayList<>();
        this.rides = new ArrayList<>();
    }

    public void registerDriver(Driver driver) {
        drivers.add(driver);
    }

    public void registerRider(Rider rider) {
        riders.add(rider);
    }

    public Ride createRide(Driver driver, String origin, String destination, int seats, int distance) {
        Ride ride = new Ride(rides.size() + 1, origin, destination, seats, distance);
        driver.addRide(ride);
        rides.add(ride);
        return ride;
    }

    public void bookRide(Rider rider, Ride ride) {
        if (ride.getStatus().equals("ONGOING")) {
            rider.addRide(ride);
        }
    }

    public void generateBill(Ride ride) {
        ride.closeRide();
        System.out.println("Ride Completed. Amount Charged: " + ride.getAmountCharged());
    }

    public boolean checkRideValidity(Ride ride, int requestedSeats) {
        return ride.getStatus().equals("ONGOING") && ride.seats >= requestedSeats;
    }

    public void updateRideStatus(Ride ride, String status) {
        ride.status = status;
    }

    public double fetchDriverRevenue(Driver driver) {
        return driver.fetchRevenue();
    }
}
