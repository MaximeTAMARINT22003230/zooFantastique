package Game.Creature.Bestiary;

import Game.Creature.Behavior.Fly;
import Game.Creature.Behavior.Revive;
import Game.Creature.Caracteristic.*;
import Game.Creature.Oviparian;

/**
 * Represents a Phoenix
 * Inherits from the Oviparian class and implements Fly and Revive behaviors.
 */
public class Phenix extends Oviparian implements Fly, Revive {
    private Phenix(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }

    /**
     * Creates and returns a newborn Phoenix with default attributes.
     *
     * @param name The name of the newborn Phoenix.
     * @param sex  The sex of the newborn Phoenix.
     * @return A new Phoenix instance.
     */
    public static Phenix newBorn(String name, Sex sex) {
        return new Phenix(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

    /**
     * Implements the behavior of a Phoenix.
     */
    @Override
    public void run() {
    }
}