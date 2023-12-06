package Game.Creature.Bestiary;

import Game.Creature.Behavior.Run;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;

/**
 * Represents a Lycantropus
 * Inherits from the Viviparian class and implements the Run behavior.
 */
public class Lycantropus extends Viviparian implements Run {
    private Lycantropus(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }

    /**
     * Creates and returns a newborn Lycantropus with default attributes.
     *
     * @param name The name of the newborn Lycantropus.
     * @param sex  The sex of the newborn Lycantropus.
     * @return A new Lycantropus instance.
     */
    public static Lycantropus newBorn(String name, Sex sex) {
        return new Lycantropus(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

    /**
     * Implements the running behavior of a Lycantropus.
     */
    @Override
    public void run() {
    }
}