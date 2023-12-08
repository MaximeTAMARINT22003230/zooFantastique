package Game.Creature.Bestiary;

import Game.Creature.Behavior.Swim;
import Game.Creature.Caracteristic.*;
import Game.Creature.Oviparian;

/**
 * Represents a Megalodon
 * Inherits from the Oviparian class and implements the Swim behavior.
 */
public class Megalodon extends Oviparian implements Swim {
    private Megalodon(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }

    /**
     * Creates and returns a newborn Megalodon with default attributes.
     *
     * @param name The name of the newborn Megalodon.
     * @param sex  The sex of the newborn Megalodon.
     * @return A new Megalodon instance.
     */
    public static Megalodon newBorn(String name, Sex sex) {
        return new Megalodon(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

}
