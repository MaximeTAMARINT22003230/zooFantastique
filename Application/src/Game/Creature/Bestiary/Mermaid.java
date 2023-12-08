package Game.Creature.Bestiary;
import Game.Creature.Behavior.Swim;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;

/**
 * Represents a Mermaid
 * Inherits from the Viviparian class and implements the Swim behavior.
 */
public final class Mermaid extends Viviparian implements Swim {
    private Mermaid(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }

    /**
     * Creates and returns a newborn Mermaid with default attributes.
     *
     * @param name The name of the newborn Mermaid.
     * @param sex  The sex of the newborn Mermaid.
     * @return A new Mermaid instance.
     */
    public static Mermaid newBorn(String name, Sex sex) {
        return new Mermaid(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

    @Override
    public void run() {

    }

}
