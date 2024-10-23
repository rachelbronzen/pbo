public class Game {
    private Parser parser;
    private Room currentRoom;

    public Game() {
        createRooms();
        parser = new Parser();
    }

    private void createRooms() {
        Room outside, theater, pub, lab, office;

        outside = new Room("outside the main entrance of the university");
        theater = new Room("in a lecture theater");
        pub = new Room("in the campus pub");
        lab = new Room("in a computing lab");
        office = new Room("in the computing admin office");

        outside.setExits(null, theater, lab, pub);
        theater.setExits(null, null, null, outside);
        pub.setExits(null, outside, null, null);
        lab.setExits(outside, office, null, null);
        office.setExits(null, null, null, lab);

        currentRoom = outside;
    }

    public void play() {
        printWelcome();

        boolean finished = false;
        while (!finished) {
            Command command = parser.getCommand();
            finished = processCommand(command);
        }
        System.out.println("Thank you for playing. Goodbye!");
    }

    private void printWelcome() {
        System.out.println();
        System.out.println("Welcome to the World of Zuul!");
        System.out.println("Embark on a thrilling adventure in the World of Zuul. Explore the sprawling campus of Zuul University!");
        System.out.println("Type 'help' if you need help.");
        System.out.println();
        printLocationInfo();
    }

    private void printLocationInfo() {
        System.out.println("You are " + currentRoom.getDescription());
        System.out.print("\nExits: ");
        if (currentRoom.getExit("north") != null) {
            System.out.print("north ");
        }
        if (currentRoom.getExit("east") != null) {
            System.out.print("east ");
        }
        if (currentRoom.getExit("south") != null) {
            System.out.print("south ");
        }
        if (currentRoom.getExit("west") != null) {
            System.out.print("west ");
        }
        System.out.println();
    }

    private boolean processCommand(Command command) {
        if (command.isUnknown()) {
            System.out.println("What do you mean???");
            return false;
        }

        String commandWord = command.getCommandWord();
        if (commandWord.equals("help")) {
            printHelp();
        } else if (commandWord.equals("go")) {
            goRoom(command);
        } else if (commandWord.equals("quit")) {
            return true;
        }
        return false;
    }

    private void printHelp() {
        System.out.println("You are lost. You are alone. You wander around.");
        System.out.println("Your command words are:");
        parser.showCommands();
    }

    private void goRoom(Command command) {
        if (!command.hasSecondWord()) {
            System.out.println("Go where?");
            return;
        }

        String direction = command.getSecondWord();
        Room nextRoom = currentRoom.getExit(direction);

        if (nextRoom == null) {
            System.out.println("There is no door!");
        } else {
            currentRoom = nextRoom;
            printLocationInfo();
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.play();
    }
}
