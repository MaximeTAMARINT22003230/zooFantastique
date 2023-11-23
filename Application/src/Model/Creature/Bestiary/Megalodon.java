package Model.Creature.Bestiary;
import Controler.Controler;
import Model.Creature.Behavior.Swim;
import Model.Creature.Caracteristic.*;
import Model.Creature.Oviparian;

public class Megalodon extends Oviparian implements Swim {
    private Megalodon(Controler controler, String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(controler, name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Megalodon newBorn(Controler controler, String name, Sex sex)
    {
        return new Megalodon(controler, name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

    @Override
    public void run() {

    }

}
