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
}
