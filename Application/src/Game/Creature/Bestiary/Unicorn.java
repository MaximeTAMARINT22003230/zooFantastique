package Game.Creature.Bestiary;
import Game.Creature.Behavior.Run;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;
/**
 * Represents a Unicorn
 * Inherits from the Viviparian class and implements the Run behavior.
 */

public final class Unicorn extends Viviparian implements Run {
    private Unicorn(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    /**
     * Creates and returns a newborn Unicorn with default attributes.
     *
     * @param name The name of the newborn Unicorn.
     * @param sex  The sex of the newborn Unicorn.
     * @return A new unicorn instance.
     */
    public static Unicorn newBorn(String name, Sex sex)
    {
        return new Unicorn(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }
}
