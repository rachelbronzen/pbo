public class Rabbit extends Animal {
    public Rabbit(Location location) {
        super(location);
    }

    @Override
    public void act(Field field) {
        // Example: Rabbits don't eat but move randomly.
        Location newLocation = field.freeAdjacentLocation(location);
        if (newLocation != null) {
            field.place(null, location);  // Remove from current location
            location = newLocation;
            field.place(this, location); // Place in the new location
        }
    }
}
