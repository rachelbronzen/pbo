import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Auction {
    private Map<Integer, Lot> lots; 
    private boolean isOpen; 
    private Person auctioneer;

    public Auction(Person auctioneer) {
        this.lots = new HashMap<>();
        this.isOpen = true;
        this.auctioneer = auctioneer;
    }

    public void addLot(Lot lot) {
        lots.put(lot.getLotNumber(), lot);
    }

    public boolean placeBid(int lotNumber, Bid bid) {
        if (!isOpen) {
            System.out.println("The auction is currently closed.");
            return false;
        }
        Lot lot = lots.get(lotNumber);
        if (lot == null) {
            System.out.println("Please enter the correct lot number.");
            return false;
        }

        if (lot.getCurrentBid() == null || bid.getAmount() > lot.getCurrentBid().getAmount()) {
            lot.setCurrentBid(bid);
            System.out.println("Bid placed successfully!");
            return true;
        }
        else {
            System.out.println("Bid is too low. Please bid higher than the current highest bid. \n" + lot.getCurrentBid());
            return false;
        }
    }

    public void closeAuction() {
        this.isOpen = false;
        System.out.println("Auction closed. Here are the results:");
        for (Lot lot : lots.values()) {
            if (lot.getCurrentBid() != null) {
                System.out.println("Lot " + lot.getLotNumber() + ": Sold to " + lot.getCurrentBid().getPerson().getName() + " for $" + lot.getCurrentBid().getAmount());
            } else {
                System.out.println("Lot " + lot.getLotNumber() + ": No bids.");
            }
        }
    }

    public void openAuction() {
        this.isOpen = true;
        System.out.println("Auction is now open again.");
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Auction auction = new Auction(new Person("Auctioneer"));

        auction.addLot(new Lot(1, "Vase"));
        auction.addLot(new Lot(2, "Pendant"));

        System.out.println("Welcome to the Auction Project XII!");
        boolean running = true;
        
        while (running) {
            System.out.println("\nThe commands:");
            System.out.println("1. Bid");
            System.out.println("2. Close Auction");
            System.out.println("3. Reopen Auction");
            System.out.println("4. Exit");
            System.out.print("Enter command: ");
            int command = scanner.nextInt();

            switch (command) {
                case 1:
                    if (auction.isOpen) {
                        System.out.println("The Lot:");
                        System.out.println("1. George IV Opaline Vase");
                        System.out.println("2. Marie Antoinette’s Pearl & Diamond Pendant");
                        System.out.println("Enter lot number: ");
                        int lotNumber = scanner.nextInt();
                        System.out.print("Enter your name: ");
                        scanner.nextLine();
                        String name = scanner.nextLine();
                        System.out.print("Enter your bid amount: $");
                        double amount = scanner.nextDouble();

                        Person bidder = new Person(name);
                        Bid bid = new Bid(bidder, amount);
                        boolean success = auction.placeBid(lotNumber, bid);
                    } 
                    else {
                        System.out.println("Sorry, the auction is currently closed.");
                    }
                    break;
                case 2:
                    auction.closeAuction();
                    break;
                case 3:
                    auction.openAuction();
                    break;
                case 4:
                    running = false;
                    break;
                default:
                    System.out.println("Please enter the correct number of option!");
            }
        }
        scanner.close();
        System.out.println("Thank you for using the Auction Project XII system!");
    }
}
