package Model.Creature.Bestiary;
import Controler.Controler;
import Model.Creature.Behavior.Run;
import Model.Creature.Caracteristic.*;
import Model.Creature.Creature;
import Model.Creature.Behavior.*;
import Model.Creature.Caracteristic.*;
import Model.Creature.Viviparian;

public class Unicorn extends Viviparian implements Run {
    private Unicorn(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Unicorn newBorn(String name, Sex sex)
    {
        return new Unicorn(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
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

    @Override
    public void run() {

    }
}
