package Game.Creature.Bestiary;
import Game.Creature.Behavior.Run;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;

public class Lycantropus extends Viviparian implements Run {
    private Lycantropus(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Lycantropus newBorn(String name, Sex sex)
    {
        return new Lycantropus(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }

}
