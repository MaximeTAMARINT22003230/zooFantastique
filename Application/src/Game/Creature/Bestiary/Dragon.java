package Game.Creature.Bestiary;
import Game.Creature.Behavior.Fly;
import Game.Creature.Behavior.Revive;
import Game.Creature.Behavior.Run;
import Game.Creature.Behavior.Swim;
import Game.Creature.Caracteristic.*;
import Game.Creature.Oviparian;
import Interactions.Controler;

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
        while (this.isAlive){

            if (!this.isAlive)
                break;

            if (this.isSleeping) {
                int t = Model.DiceRoll.d4();
                if (t == 1) {
                    Controler.getInstance().notification(this.name + " se reveil (" + this.getClass().getSimpleName() + ") : " +t);
                    isSleeping = false;
                } else {
                    Controler.getInstance().notification(this.name + " dort toujours (" + this.getClass().getSimpleName() + ") : "+t);
                }
            }
            else {
                int randomAction = Model.DiceRoll.d100();

                if (randomAction <= 15)
                    shout();
                if (randomAction <= 30 && randomAction >= 16)
                    age();
                if (randomAction <= 45 && randomAction >= 31)
                    gettingFatigue();
                if (randomAction <= 60 && randomAction >= 46)
                    gettingFatigue();
                if (randomAction <= 75 && randomAction >= 61)
                    gettingFatigue();
                if (randomAction <= 90 && randomAction >= 76)
                    gettingFatigue();
            }

            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
}
