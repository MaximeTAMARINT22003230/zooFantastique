package Game.Creature.Bestiary;
import Game.Creature.Behavior.Fly;
import Game.Creature.Behavior.Revive;
import Game.Creature.Behavior.Run;
import Game.Creature.Behavior.Swim;
import Game.Creature.Caracteristic.*;
import Game.Creature.Oviparian;

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
            int randomAction = Model.DiceRoll.d100();

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
