package Game.Creature.Bestiary;
import Game.Creature.Behavior.Swim;
import Game.Creature.Caracteristic.*;
import Game.Creature.Oviparian;

/**
 * Represents a Kraken
 * Inherits from the Oviparian class and implements the Swim behavior.
 */
public final class Kraken extends Oviparian implements Swim {
    private Kraken(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    /**
     * Creates and returns a newborn Kraken with default attributes.
     *
     * @param name The name of the newborn Kraken.
     * @param sex  The sex of the newborn Kraken.
     * @return A new Kraken instance.
     */
    public static Kraken newBorn(String name, Sex sex)
    {
        return new Kraken(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

}
