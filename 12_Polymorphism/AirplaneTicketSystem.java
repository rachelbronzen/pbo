import java.util.ArrayList;
import java.util.Scanner;

public class AirplaneTicketSystem {
    private ArrayList<Ticket> tickets = new ArrayList<>();

    public void start() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to The Lemon Airplane!");

        while (true) {
            System.out.println("Choose ticket level (economy, business, first) or type 'stop' to finish:");
            String level = scanner.nextLine();

            if (level.equalsIgnoreCase("stop")) {
                break;
            }

            System.out.println("Enter the number of tickets you want to buy:");
            int quantity;
            try {
                quantity = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Invalid number! Please try again.");
                continue;
            }

            Ticket ticket;
            switch (level.toLowerCase()) {
                case "economy":
                    ticket = new EconomyTicket(quantity);
                    break;
                case "business":
                    ticket = new BusinessTicket(quantity);
                    break;
                case "first":
                    ticket = new FirstClassTicket(quantity);
                    break;
                default:
                    System.out.println("Invalid level. Please try again.");
                    continue;
            }

            tickets.add(ticket);
            System.out.println(quantity + " " + ticket.getLevel() + " ticket(s) added to your cart.\n");
        }

        displaySummary();
        scanner.close();
    }

    private void displaySummary() {
        if (tickets.isEmpty()) {
            System.out.println("No tickets purchased.");
            return;
        }

        double totalPrice = 0;
        System.out.println("\n--- Purchase Summary ---");
        for (Ticket ticket : tickets) {
            System.out.println("Level: " + ticket.getLevel());
            System.out.println("Quantity: " + ticket.getQuantity());
            System.out.println("Facilities: " + ticket.getFacilities());
            System.out.println("Price: $" + ticket.getPrice());
            totalPrice += ticket.getPrice();
            System.out.println("-------------------------");
        }
        System.out.println("Total Price: $" + totalPrice);
        System.out.println("Thank you for using the Lemon Airplane!");
    }
}
