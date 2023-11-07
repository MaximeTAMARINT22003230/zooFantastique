package Model.Creature.Viviparian;
import Model.Creature.Behavior.Run;
import Model.Creature.Caracteristic.*;
import Model.Creature.Behavior.*;
import Model.Creature.Caracteristic.*;
import Model.Creature.Creature;

public class Lycantropus extends Creature implements Run {
    public Lycantropus(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }

    @Override
    protected void eat() {

    }

    @Override
    protected void shout() {

    }

    @Override
    protected void heal() {

    }

    @Override
    protected void sleep() {

    }

    @Override
    protected void age() {

    }
}
