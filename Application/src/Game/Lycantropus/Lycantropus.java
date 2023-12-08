package Game.Lycantropus;
import Game.Creature.Behavior.Run;
import Game.Creature.Caracteristic.*;
import Game.Creature.Viviparian;
import Game.Lycantropus.Caracteristics.Rank;
import Game.Lycantropus.Caracteristics.Level;
import Game.Lycantropus.Caracteristics.Strength;
import Player.Controler;

import java.util.List;
import java.util.Objects;

public final class Lycantropus extends Viviparian implements Run, Runnable {
    /**
     * The actual strength of the lycan
     */
    private Strength strength;
    /**
     * Its rank in the pack
     */
    private Rank rank;
    /**
     * A sort of quality criteria
     */
    private Level level;
    /**
     * Its pack. Null if its a lone wolf
     */
    private Pack pack;
    /**
     * A float between 0 and 1 wich represent its probabilty to resist a domination
     */
    private float impetuosity;
    private Lycantropus(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health) {
        super(name, sex, weight, height, age, hunger, fatigue, health);
    }
    public int getDomination()
    {
        return pack.dominationOf(this);
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
                if(!Objects.equals(howl.getHowler(), this)) {
                    this.howl(Howl.ANSWER);
                }
                break;
            }
            case DOMINATION ->
            {
                //HE IS AGGRESSED
            }
            case ANSWER ->
            {
                break;
            }
            case AGGRESSIVE ->
            {
                //HE IS AGGRESSED
            }
            case SUBMISSION ->
            {
                //HE WON
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

    /**
     * Escape from its pack and become a lone wolf
     */
    private void escape()
    {
        this.pack = null;
    }
}
