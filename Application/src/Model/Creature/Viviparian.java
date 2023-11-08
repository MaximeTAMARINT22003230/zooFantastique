package Model.Creature;

import Model.Creature.Caracteristic.*;

public abstract class Viviparian extends Creature{
    public Viviparian(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
}
