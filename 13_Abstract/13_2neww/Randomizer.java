import java.util.Random;

public class Randomizer {
    private static Random random = new Random(); 

    private Randomizer() {}

    public static Random getInstance() {
        return random;
    }

    public static int nextInt(int max) {
        return random.nextInt(max + 1);
    }
}
