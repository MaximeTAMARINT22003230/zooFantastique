package Model.Creature.Viviparian;
import Model.Creature.Behavior.Revive;
import Model.Creature.Behavior.Run;
import Model.Creature.Caracteristic.*;
import Model.Creature.Creature.Behavior.*;
import Model.Creature.Creature.Caracteristic.*;
import Model.Creature.Creature;

public class Nymph extends Creature implements Run, Revive {
    public Nymph(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
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