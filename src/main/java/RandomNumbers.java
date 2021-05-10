
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

public class RandomNumbers {

    private static Random generator = new Random();

    public static int nextIntFromRange(int min, int max) {
        return generator.nextInt((max - min) + 1) + min;
    }

    public static int nextEvenIntFromRange(int min, int max) {
        min = min % 2 == 1 ? min + 1 : min; // ensure even
        max = max % 2 == 1 ? max - 1 : max; // ensure even

        return min + generator.nextInt((max - min)/2) *2;
    }

    public static BigDecimal randomElement(ArrayList<BigDecimal> list) {
        return list.get(generator.nextInt(list.size()));
    }
}
