public class Vehicle {
    private String brand;
    private int year;
    private String renterName;
    private String renterPhone;

    public Vehicle(String brand, int year, String renterName, String renterPhone) {
        this.brand = brand;
        this.year = year;
        this.renterName = renterName;
        this.renterPhone = renterPhone;
    }

    public String getBrand() {
        return brand;
    }

    public int getYear() {
        return year;
    }

    public String getRenterName() {
        return renterName;
    }

    public String getRenterPhone() {
        return renterPhone;
    }

    public void displayDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Year: " + year);
        System.out.println("Renter Name: " + renterName);
        System.out.println("Renter Phone: " + renterPhone);
    }
}
