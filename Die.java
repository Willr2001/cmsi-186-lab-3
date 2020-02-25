import java.util.Random;

/**
 * A simple class for representing die objects. A die has a given number of
 * sides (at least) four, set when the die is constructed and which can never
 * be changed. The die's value can be changed, but only by calling its roll()
 * method.
 */
public class Die {
    private static Random random = new Random();

    // TODO: Add fields
    public static final String SIX_SIDED_DIE_EMOJI = "D";

    private int value;
    private final int sides;

    /**
     * Constructs a die with the given number of sides and starting value.
     * @throws IllegalArgumentException if the number of sides is less than 4 or
     * if the starting value is not consistent with the number of sides.
     */
    public Die(int sides, int value) {
      if (sides < 4) {
        throw new IllegalArgumentException("At least four sides required");
      }
      if (value < 1 || value > sides) {
        throw new IllegalArgumentException("Die value not legal for die shape");
      }
      this.sides = sides;
      this.value = value;


    }


    public int roll() {
      value = random.nextInt(sides) + 1;
        return value;
    }


    public int getSides() {
      return sides;

    }


    public int getValue() {
      return value;

    }


    @Override public String toString() {
        return "["+value+"]"; 
    }
}
