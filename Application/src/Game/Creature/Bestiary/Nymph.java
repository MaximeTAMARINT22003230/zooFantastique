package Game.Creature.Bestiary;
import Game.Creature.Behavior.Revive;
import Game.Creature.Behavior.Run;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;

/**
 * Represents a Nymph
 * Inherits from the Viviparian class and implements Run and Revive behaviors.
 */
public final class Nymph extends Viviparian implements Run, Revive {
    private Nymph(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }

    /**
     * Creates and returns a newborn Nymph with default attributes.
     *
     * @param name The name of the newborn Nymph.
     * @param sex  The sex of the newborn Nymph.
     * @return A new Nymph instance.
     */
    public static Nymph newBorn(String name, Sex sex) {
        return new Nymph(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }
}
