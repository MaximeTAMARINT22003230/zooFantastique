package Model.Creature.Bestiary;
import Controler.Controler;
import Model.Creature.Behavior.Fly;
import Model.Creature.Behavior.Revive;
import Model.Creature.Behavior.Run;
import Model.Creature.Behavior.Swim;
import Model.Creature.Caracteristic.*;
import Model.Creature.Behavior.*;
import Model.Creature.Caracteristic.*;
import Model.Creature.Creature;
import Model.Creature.Oviparian;

public class Dragon extends Oviparian implements Fly, Run, Swim, Revive {
    private Dragon(Controler controler, String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(controler, name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Dragon newBorn(Controler controler, String name, Sex sex)
    {
        return new Dragon(controler, name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
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
