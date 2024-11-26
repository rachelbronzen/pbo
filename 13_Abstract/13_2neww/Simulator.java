import java.util.ArrayList;
import java.util.List;

public class Simulator {
    private Field field;
    private List<Animal> animals;

    public Simulator(int rows, int cols) {
        field = new Field(rows, cols);
        animals = new ArrayList<>();
        populate();
    }

    private void populate() {
    for (int row = 0; row < field.getHeight(); row++) {
        for (int col = 0; col < field.getWidth(); col++) {
            int chance = Randomizer.nextInt(100);
            if (chance < 15) { 
                Rabbit rabbit = new Rabbit(new Location(row, col));
                animals.add(rabbit);
                field.place(rabbit, new Location(row, col));
            } else if (chance < 20) { 
                Fox fox = new Fox(new Location(row, col));
                animals.add(fox);
                field.place(fox, new Location(row, col));
            }
        }
    }
    }


    public void simulate(int steps) {
        for (int step = 1; step <= steps; step++) {
            System.out.println("Step: " + step);
            animals.forEach(animal -> animal.act(field));
            field.printField();
            countAnimals();
        }
    }
    
    
    private void countAnimals() {
    int rabbitCount = 0;
    int foxCount = 0;

    for (Object animal : animals) {
        if (animal instanceof Rabbit) {
            rabbitCount++;
        } else if (animal instanceof Fox) {
            foxCount++;
        }
    }

    System.out.println("Foxes: " + foxCount + " Rabbits: " + rabbitCount +"\n");
    }

    public static void main(String[] args) {
        System.out.println("Welcome to the RABBIT AND FOXES! Let's count together!");
        Simulator sim = new Simulator(5, 10);
        sim.simulate(5);
    }
}
