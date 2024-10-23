public class Room {
    private String description;
    private Room northExit, southExit, eastExit, westExit;

    public Room(String description) {
        this.description = description;
    }

    public void setExits(Room north, Room east, Room south, Room west) {
        northExit = north;
        eastExit = east;
        southExit = south;
        westExit = west;
    }

    public String getDescription() {
        return description;
    }

    public Room getExit(String direction) {
        switch (direction) {
            case "north":
                return northExit;
            case "east":
                return eastExit;
            case "south":
                return southExit;
            case "west":
                return westExit;
            default:
                return null;
        }
    }
}
