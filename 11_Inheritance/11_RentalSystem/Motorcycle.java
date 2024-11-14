public class Motorcycle extends Vehicle {
    public Motorcycle(String brand, int year, String renterName, String renterPhone) {
        super(brand, year, renterName, renterPhone);
    }

    @Override
    public void displayDetails() {
        System.out.println("Motorcycle Details:");
        super.displayDetails();
    }
}
