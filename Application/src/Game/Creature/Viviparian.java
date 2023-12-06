package Game.Creature;

import Game.Creature.Behavior.Pregnancy;
import Game.Creature.Caracteristic.*;

/**
 * Represents an Viviparian
 * Extends the Creature class.
 */
public abstract class Viviparian extends Creature{
    public Viviparian(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
        if(sex == Sex.FEMALE)
        {
            this.birthingBehavior = new Pregnancy();
        }
    }
}
