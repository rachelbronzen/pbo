public class Car extends Vehicle {
    public Car(String brand, int year, String renterName, String renterPhone) {
        super(brand, year, renterName, renterPhone);
    }

    @Override
    public void displayDetails() {
        System.out.println("Car Details:");
        super.displayDetails();
    }
}
