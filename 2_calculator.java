import java.util.Scanner;
public class calculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the calculator");
        int tmp=0;
        while (tmp == 0) {
            System.out.println("Basic operation you can choose");
            System.out.println("1. +");
            System.out.println("2. -");
            System.out.println("3. x");
            System.out.println("4. :");
            System.out.println("Choose the operation number= ");
            int num = scanner.nextInt();
            System.out.println("First number:");
            int fn = scanner.nextInt();
            System.out.println("Second number:");
            int sn = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.println("The total is " + (fn+sn));
                    break;
                case 2:
                    System.out.println("The total is " + (fn-sn));
                    break;
                case 3:
                    System.out.println("The total is " + (fn*sn));
                    break;
                case 4:
                    System.out.println("The total is " + (fn/sn));
                    break;
            }
            System.out.println("\nType 0 if you still want to use the calculator");
            System.out.println("Type 1 if you want to exit!");
            tmp = scanner.nextInt();
        }
        System.out.println("Thank you for using the calculator!");


    }
}
