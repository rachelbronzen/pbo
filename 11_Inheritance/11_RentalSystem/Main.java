import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        RentalSystem rentalSystem = new RentalSystem();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;
        System.out.println("Welcome to the Rach's Rental!");
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Add Car Rental");
            System.out.println("2. Add Motorcycle Rental");
            System.out.println("3. Display All Rentals");
            System.out.println("4. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter car brand: ");
                    String carBrand = scanner.nextLine();
                    System.out.print("Enter car year: ");
                    int carYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter renter name: ");
                    String carRenterName = scanner.nextLine();
                    System.out.print("Enter renter phone: ");
                    String carRenterPhone = scanner.nextLine();

                    rentalSystem.addCarRental(carBrand, carYear, carRenterName, carRenterPhone);
                    break;

                case 2:
                    System.out.print("Enter motorcycle brand: ");
                    String motoBrand = scanner.nextLine();
                    System.out.print("Enter motorcycle year: ");
                    int motoYear = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Enter renter name: ");
                    String motoRenterName = scanner.nextLine();
                    System.out.print("Enter renter phone: ");
                    String motoRenterPhone = scanner.nextLine();

                    rentalSystem.addMotorcycleRental(motoBrand, motoYear, motoRenterName, motoRenterPhone);
                    break;

                case 3:
                    rentalSystem.displayAllRentals();
                    break;

                case 4:
                    running = false;
                    System.out.println("Thank you dear! Have a blessing day!");
                    break;

                default:
                    System.out.println("Invalid option.");
            }
            System.out.println();
        }

        scanner.close();
    }
}
