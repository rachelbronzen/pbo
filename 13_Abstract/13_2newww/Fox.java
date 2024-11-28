import java.util.List;
public class Fox extends Animal {
    public Fox(Field field, Location location) {
        super(field, location);
    }

    public void act(List<Animal> newAnimals) {
        if (!isAlive()) {
            return;
        }

        // Fox looks for rabbits to eat
        Rabbit rabbit = findRabbit();
        if (rabbit != null) {
            rabbit.setDead();
        } else {
            Location newLocation = findNewLocation();
            if (newLocation != null) {
                field.clear(location);
                location = newLocation;
                field.place(this, location);
            }
        }

        if (Math.random() < 0.1) { // 10% chance to reproduce
            newAnimals.add(new Fox(field, location));
        }
    }

    private Rabbit findRabbit() {
        // Check surrounding locations for rabbits
        for (int rowOffset = -1; rowOffset <= 1; rowOffset++) {
            for (int colOffset = -1; colOffset <= 1; colOffset++) {
                int newRow = location.getRow() + rowOffset;
                int newCol = location.getCol() + colOffset;
                if (newRow >= 0 && newRow < field.getRows() && newCol >= 0 && newCol < field.getCols()) {
                    Object obj = field.getObjectAt(new Location(newRow, newCol));
                    if (obj instanceof Rabbit) {
                        return (Rabbit) obj;
                    }
                }
            }
        }
        return null;
    }

    private Location findNewLocation() {
        int newRow = location.getRow() + (int) (Math.random() * 3) - 1; // Random move
        int newCol = location.getCol() + (int) (Math.random() * 3) - 1;
        if (newRow >= 0 && newRow < field.getRows() && newCol >= 0 && newCol < field.getCols()) {
            return new Location(newRow, newCol);
        }
        return null;
    }
}
