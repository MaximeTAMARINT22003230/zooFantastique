package Model.Creature.Bestiary;
import Controler.Controler;
import Model.Creature.Behavior.Fly;
import Model.Creature.Behavior.Revive;
import Model.Creature.Behavior.Run;
import Model.Creature.Behavior.Swim;
import Model.Creature.Caracteristic.*;
import Model.Creature.Oviparian;
import Model.DiceRoll;

public class Dragon extends Oviparian implements Fly, Run, Swim, Revive {
    private Dragon(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Dragon newBorn(String name, Sex sex)
    {
        return new Dragon(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

    @Override
    public void run() {
        while (true){
            int randomAction = DiceRoll.d100();

            if (randomAction <= 20)
                shout();
            if (randomAction <= 60 && randomAction >= 15)
                age();
            if (randomAction <= 70 && randomAction >= 35)
                age();
            if (randomAction <= 80 && randomAction >= 55)
                age();
            if (randomAction <= 90 && randomAction >= 75)
                age();
            if (randomAction <= 100 && randomAction >= 85)
                age();

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
