import java.util.*;

// ======================= USER =======================
class User {
    private int userId;
    private String name;

    public User(int userId, String name) {
        this.userId = userId;
        this.name = name;
    }

    public String getName() {
        return name;
    }
}

// ======================= DRIVER =======================
class Driver {
    private int driverId;
    private String name;
    private boolean available = true;

    public Driver(int driverId, String name) {
        this.driverId = driverId;
        this.name = name;
    }

    public boolean isAvailable() {
        return available;
    }

    public void assignRide() {
        available = false;
    }

    public void completeRide() {
        available = true;
    }

    public String getName() {
        return name;
    }
}

// ======================= RIDE =======================
class Ride {
    private User user;
    private Driver driver;
    private double distance;
    private double fare;

    public Ride(User user, Driver driver, double distance) {
        this.user = user;
        this.driver = driver;
        this.distance = distance;
    }

    public void setFare(double fare) {
        this.fare = fare;
    }

    public String getDetails() {
        return "User: " + user.getName() +
               ", Driver: " + driver.getName() +
               ", Distance: " + distance + " km" +
               ", Fare: ₹" + fare;
    }
}

// ======================= FARE CALCULATOR =======================
interface FareCalculator {
    double calculateFare(double distance);
}

// ======================= NORMAL FARE =======================
class NormalFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 10;
    }
}

// ======================= PEAK FARE =======================
class PeakFare implements FareCalculator {
    public double calculateFare(double distance) {
        return distance * 15;
    }
}

// ======================= CUSTOM EXCEPTION =======================
class NoDriverAvailableException extends Exception {
    public NoDriverAvailableException(String message) {
        super(message);
    }
}

// ======================= RIDE SERVICE =======================
class RideService {
    private List<Driver> drivers;
    private List<Ride> rideHistory = new ArrayList<>();

    public RideService(List<Driver> drivers) {
        this.drivers = drivers;
    }

    public Ride bookRide(User user, double distance, FareCalculator fareCalculator)
            throws NoDriverAvailableException {

        Driver assignedDriver = null;

        for (Driver driver : drivers) {
            if (driver.isAvailable()) {
                assignedDriver = driver;
                break;
            }
        }

        if (assignedDriver == null) {
            throw new NoDriverAvailableException("No drivers available!");
        }

        assignedDriver.assignRide();

        Ride ride = new Ride(user, assignedDriver, distance);
        double fare = fareCalculator.calculateFare(distance);
        ride.setFare(fare);

        rideHistory.add(ride);
        return ride;
    }

    public List<Ride> getRideHistory() {
        return rideHistory;
    }
}

// ======================= MAIN APP =======================
public class RideBookSystem {
    public static void main(String[] args) {
        try {
            User user = new User(1, "Ayush");

            List<Driver> drivers = new ArrayList<>();
            drivers.add(new Driver(101, "Ravi"));
            drivers.add(new Driver(102, "Amit"));

            RideService rideService = new RideService(drivers);

            FareCalculator fareCalculator = new PeakFare(); // Polymorphism

            Ride ride = rideService.bookRide(user, 12.5, fareCalculator);
            System.out.println(ride.getDetails());

        } catch (NoDriverAvailableException e) {
            System.out.println(e.getMessage());
        }
    }
}
