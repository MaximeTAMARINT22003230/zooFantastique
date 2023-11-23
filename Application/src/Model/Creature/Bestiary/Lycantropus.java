package Model.Creature.Bestiary;
import Controler.Controler;
import Model.Creature.Behavior.Run;
import Model.Creature.Caracteristic.*;
import Model.Creature.Behavior.*;
import Model.Creature.Caracteristic.*;
import Model.Creature.Creature;
import Model.Creature.Viviparian;

public class Lycantropus extends Viviparian implements Run {
    private Lycantropus(Controler controler, String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(controler, name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Lycantropus newBorn(Controler controler, String name, Sex sex)
    {
        return new Lycantropus(controler, name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

    @Override
    public void run() {

    }
}
