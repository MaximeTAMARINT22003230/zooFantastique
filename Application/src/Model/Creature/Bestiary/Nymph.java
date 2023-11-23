package Model.Creature.Bestiary;
import Controler.Controler;
import Model.Creature.Behavior.Revive;
import Model.Creature.Behavior.Run;
import Model.Creature.Caracteristic.*;
import Model.Creature.Behavior.*;
import Model.Creature.Caracteristic.*;
import Model.Creature.Creature;
import Model.Creature.Viviparian;

public class Nymph extends Viviparian implements Run, Revive {
    private Nymph(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Nymph newBorn(String name, Sex sex)
    {
        return new Nymph(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

    @Override
    public void run() {

    }

}
