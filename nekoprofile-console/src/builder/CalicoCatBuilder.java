package builder;

import data.Cat;
import data.CatColor;
import data.Color;
import data.Gender;

import java.util.*;

/**
 * Concrete Builder to produce a Cat object that represents a calico cat.
 * The produced object will have 3 colors: Color.WHITE, Color.Black, Color.ORANGE,
 * and its gender will be mostly Gender.FEMALE
 */
public class CalicoCatBuilder extends Builder {
    // initial body color
    private Color bodyColor = Color.BLACK;
    // colors other than bodyColor
    private List<Color> otherColors = Arrays.asList(
            Color.WHITE,
            Color.ORANGE
    );
    private final Random random = new Random();
    private static final List<Color> calicoColors = Arrays.asList(Color.BLACK, Color.WHITE, Color.ORANGE);

    private static boolean isCalicoColor(Color color) {
        return calicoColors.contains(color);
    }

    public CalicoCatBuilder() {
        // initialize the gender of production object
        getGender();
    }

    // methods to generate a random & valid color for a calico cat object.
    private Color randomCalicoColors() {
        int index = random.nextInt(calicoColors.size() - 1);
        return calicoColors.get(index);
    }

    private Color pickCalicoColorExceptBodyColor() {
        int index = random.nextInt(calicoColors.size() - 1);
        return otherColors.get(index);
    }

    private CatColor produceCalicoColors() {
        return new CatColor(
                randomCalicoColors(),
                pickCalicoColorExceptBodyColor(),
                bodyColor,
                pickCalicoColorExceptBodyColor(),
                new Color[]{
                        randomCalicoColors(),
                        randomCalicoColors(),
                        randomCalicoColors()
                }
        );
    }

    /**
     * Specify the body color of the calico cat needed to be produced.
     * @param color color to be the body color of the cat.
     *              Invalid color will be ignored.
     */
    public void addBodyColor(Color color) {
        // ignore invalid colors
        if (isCalicoColor(color)) {
            this.bodyColor = color;

            List<Color> otherColors = new ArrayList<>(calicoColors);
            otherColors.remove(color);
            Collections.shuffle(otherColors);
            this.otherColors = otherColors;
        }
    }

    /**
     * Get the gender of the produced object
     * The Cat will have a chance to be Gender.MALE about 1 per 3000 cats.
     */
    private void getGender() {
        this.gender = random.nextInt(3000 - 1) == 1 ? Gender.MALE : Gender.FEMALE;
    }

    @Override
    // override the default implementation since calico cats are mostly female
    public void addGender(Gender gender) {
        getGender();
    }

    @Override
    public Cat build() {
        return new Cat(name, dateOfBirth, nature, owner, produceCalicoColors(), gender);
    }
}

