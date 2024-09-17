import java.util.Scanner;
public class TicketMachine {

    int money;
    int income;

    public TicketMachine() {

        this.money=0;
        this.income=0;
    }

    public void ticket() {
        if(money >= 30000) {
            money -= 30000;
            income += 30000;
            System.out.println("Ticket purchased!");
        }
        else System.out.println("Your money is not enough!");
    }

    public int nowmoney() {
        return money;
    }
    public int nowincome() {
        return income;
    }

    public static void main(String[] args) {

        Scanner userInput = new Scanner (System.in);
        TicketMachine machine = new TicketMachine();

        System.out.println("Welcome!");
        System.out.println("Playing Now: ");
        System.out.println(" Power Puff Girls (100 chairs available)");
        System.out.println("    price: 30k/chair\n");
        System.out.println("Input Money: ");
        int tempmoney = userInput.nextInt();
        machine.money += tempmoney;

        machine.ticket();

        System.out.println("Thank you for using the ticket machine.");
        System.out.println(" Remaining money: " + machine.nowmoney());
        System.out.println(" Ticket machine income: " + machine.nowincome());


    }
}
