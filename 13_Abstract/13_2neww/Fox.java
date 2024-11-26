public class Fox extends Animal {
    public Fox(Location location) {
        super(location);
    }

    @Override
    public void act(Field field) {
        // Example: Foxes eat rabbits if adjacent, otherwise move randomly
        Location newLocation = field.findPrey(location);
        if (newLocation != null) {
            field.remove(newLocation);  // Eat rabbit
        } else {
            newLocation = field.freeAdjacentLocation(location);
        }
        if (newLocation != null) {
            field.place(null, location);  // Remove from current location
            location = newLocation;
            field.place(this, location); // Place in the new location
        }
    }
}
