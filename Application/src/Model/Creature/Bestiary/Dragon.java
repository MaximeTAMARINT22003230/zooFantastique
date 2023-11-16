package Model.Creature.Bestiary;
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
    private Dragon(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Dragon newBorn(String name, Sex sex)
    {
        return new Dragon(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }
    @Override
    protected void eat() {
        hunger = hunger.eat();
    }

    // à modifier car ce n'est pas la vue = pas de print
    @Override
    protected void shout() {
        System.out.println("Dragon émet un song");
    }

    @Override
    protected void heal() {
        health = health.heal();
    }

    @Override
    protected void sleep() {
        fatigue = fatigue.sleep();
    }

    @Override
    protected void age() {
        age = age.gettingOder();
    }

    @Override
    public void run() {

    }
}
