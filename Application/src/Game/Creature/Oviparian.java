package Game.Creature;

import Game.Creature.Behavior.Laying;
import Game.Creature.Caracteristic.*;

public abstract class Oviparian extends Creature{
    public Oviparian(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
        if(sex == Sex.FEMALE)
        {
            this.birthingBehavior = new Laying();
        }
    }
}
