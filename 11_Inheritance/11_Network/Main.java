import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        NewsFeed newsFeed = new NewsFeed();
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("Welcome!");
        boolean running = true;
        while (running) {
            System.out.println("Choose an option:");
            System.out.println("1. Create a Message Post");
            System.out.println("2. Create a Photo Post");
            System.out.println("3. Display All Posts");
            System.out.println("4. Display Posts by User");
            System.out.println("5. Exit");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter username: ");
                    String messageUser = scanner.nextLine();
                    System.out.print("Enter message: ");
                    String message = scanner.nextLine();

                    MessagePost messagePost = new MessagePost(messageUser, message);
                    newsFeed.addMessagePost(messagePost);
                    System.out.println("Message post created!\n");
                    break;

                case 2:
                    System.out.print("Enter username: ");
                    String photoUser = scanner.nextLine();
                    System.out.print("Enter filename: ");
                    String filename = scanner.nextLine();
                    System.out.print("Enter caption: ");
                    String caption = scanner.nextLine();

                    PhotoPost photoPost = new PhotoPost(photoUser, filename, caption);
                    newsFeed.addPhotoPost(photoPost);
                    System.out.println("Photo post created!\n");
                    break;

                case 3:
                    newsFeed.displayAllPosts();
                    break;

                case 4:
                    System.out.print("Enter username to search: ");
                    String searchUser = scanner.nextLine();
                    newsFeed.displayPostsByUser(searchUser);
                    break;

                case 5:
                    running = false;
                    System.out.println("Thank You! Have a nice day!");
                    break;

                default:
                    System.out.println("Invalid option");
            }
            System.out.println();
        }

        scanner.close();
    }
}
