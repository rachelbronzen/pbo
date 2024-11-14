import java.util.ArrayList;
import java.util.Scanner;

public class RentalSystem {
    private ArrayList<Car> carRentals;
    private ArrayList<Motorcycle> motorcycleRentals;

    public RentalSystem() {
        carRentals = new ArrayList<>();
        motorcycleRentals = new ArrayList<>();
    }

    public void addCarRental(String brand, int year, String renterName, String renterPhone) {
        Car car = new Car(brand, year, renterName, renterPhone);
        carRentals.add(car);
        System.out.println("Car rental added!");
    }

    public void addMotorcycleRental(String brand, int year, String renterName, String renterPhone) {
        Motorcycle motorcycle = new Motorcycle(brand, year, renterName, renterPhone);
        motorcycleRentals.add(motorcycle);
        System.out.println("Motorcycle rental added!");
    }

    public void displayAllRentals() {
        System.out.println("All Car Rentals:");
        for (Car car : carRentals) {
            car.displayDetails();
            System.out.println("--------------------");
        }
        System.out.println("All Motorcycle Rentals:");
        for (Motorcycle motorcycle : motorcycleRentals) {
            motorcycle.displayDetails();
            System.out.println("--------------------");
        }
    }
}
