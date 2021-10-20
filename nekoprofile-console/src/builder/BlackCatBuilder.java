package builder;

import data.Cat;
import data.CatColor;
import data.Color;

import java.util.Random;

/**
 * Concrete Builder to produce a Cat object that represents a black cat.
 */
public class BlackCatBuilder extends Builder {

    // random white spot in black fur color
    private boolean randomSpot = false;
    private final Random random = new Random();

    /**
     * Determine the final Cat object that has random white spot in its color attribute
     * @param randomSpot true then the Cat object *may* have random white spot.
     */
    public void hasRandomSpot(boolean randomSpot) {
        this.randomSpot = randomSpot;
    }

    /**
     * @return the color to be used for constructing the color of the Cat.
     */
    private Color randomWhiteSpot() {
        if (randomSpot) {
            return random.nextInt(100) < 50 ? Color.WHITE : Color.BLACK;
        }
        return Color.BLACK;
    }

    private CatColor produceBlackCatColor() {
        // The cat has a chance of getting random white spot
        // in some body parts when the randomSpot flag == true
        return new CatColor(
                Color.BLACK,
                randomWhiteSpot(),
                Color.BLACK,
                randomWhiteSpot(),
                new Color[]{
                        randomWhiteSpot(),
                        randomWhiteSpot(),
                        randomWhiteSpot(),
                        randomWhiteSpot()
                }
        );
    }

    @Override
    public Cat build() {
        return new Cat(name, dateOfBirth, nature, owner, produceBlackCatColor(), gender);
    }
}
