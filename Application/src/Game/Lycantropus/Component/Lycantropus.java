package Game.Lycantropus.Component;
import Game.Creature.Behavior.Run;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;
import Game.Lycantropus.Caracteristics.Domination;
import Game.Lycantropus.Caracteristics.Level;
import Game.Lycantropus.Howl.Howl;
import Game.Lycantropus.Pack;

import java.util.List;

public class Lycantropus extends Viviparian implements Run {
    private int domination;
    private Domination rank;
    private Level level;
    private Pack pack;
    private Howl howl;
    private List<Lycantropus> foes;
    private Lycantropus(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    public static Lycantropus newBorn(String name, Sex sex)
    {
        return new Lycantropus(name, sex, Weight.LIGHT, Height.SMALL, Age.BABY, Hunger.GOOD, Fatigue.GOOD, Health.GOOD);
    }
    private void dominate(Lycantropus target)
    {
        if(this.level.beat(target.level))
        {
            // SUCCESS !
        }
        else
        {
            // FAIL
        }
    }
    private void scream()
    {
        //TODO THIS METHOD
    }
    public void hear(Howl howl)
    {
        //TODO THIS METHOD
    }
    private void humanize()
    {
        //TODO THIS METHOD
    }
    @Override
    public String toString()
    {
        return ""; //TODO : THIS METHOD
    }
    @Override
    public void run() {

    }
}
