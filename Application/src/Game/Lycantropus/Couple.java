package Game.Lycantropus;

import Game.Creature.Caracteristic.Sex;

import java.util.List;

public class Couple {
    private Lycantropus female;
    private Lycantropus male;
    public Couple(Lycantropus female, Lycantropus male)
    {
        this.female = female;
        this.male = male;
    }
    public void reproduce()
    {
        female.birthingBehavior.makeBaby(Lycantropus.newBorn("LilLycan", Sex.FEMALE), this.female); //TODO Make it random
    }
    public String toString()
    {
        return "A IMPLEMENTEr";
    }
}
