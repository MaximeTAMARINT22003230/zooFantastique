package Game.Lycantropus.Caracteristics;

import Game.Creature.Caracteristic.Age;
import Game.Creature.Caracteristic.Sex;

public enum Level
{
    STRONG, FRAGILE; //TODO : THIS ENUM
    public boolean beat(Level foe)
    {
        return ordinal() > foe.ordinal();
    }
    public Level set(Sex sex, Age age, Strength strength, Rank rank)
    {
        //TODO THIS METHOD;
        return null;
    }
}
