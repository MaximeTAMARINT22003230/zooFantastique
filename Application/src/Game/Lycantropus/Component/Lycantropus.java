package Game.Lycantropus.Component;
import Game.Creature.Behavior.Run;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;
import Game.Lycantropus.Caracteristics.Rank;
import Game.Lycantropus.Caracteristics.Level;
import Game.Lycantropus.Caracteristics.Strength;
import Game.Lycantropus.Howl;
import Game.Lycantropus.Pack;
import Player.Controler;

import java.util.List;
import java.util.Objects;

public class Lycantropus extends Viviparian implements Run {
    private Strength strength;
    private int domination;
    private Rank rank;
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
    private void howl(Howl howl)
    {
        Controler.getInstance().notification(howl);
        Controler.getInstance().zoo.spread(howl);
    }
    public void hear(Howl howl)
    {
        switch (howl)
        {
            case BELONGING ->
            {
                if(!Objects.equals(howl.getHowler(), this)) this.howl(Howl.ANSWER);
                break;
            }
            case DOMINATION ->
            {
                //HE IS AGGRESSED
            }
            case ANSWER ->
            {
                //HE IS AGGRESSED
            }
            case AGGRESSIVE ->
            {
                //HE IS AGGRESSED
            }
            case SUBMISSION ->
            {
                //HE IS AGGRESSED
            }
            default ->
            {
                // Unhandled howl
            }
        }
    }
    @Override
    public boolean equals(Object o)
    {
        return true;
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
    public Level getLevel()
    {
        return this.level;
    }
}
