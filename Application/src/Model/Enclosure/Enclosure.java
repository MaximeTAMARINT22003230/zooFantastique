package Model.Enclosure;

import Model.Creature.Creature;

public class Enclosure {
    protected String name;
    protected String size;
    protected int max;
    protected int creaturesNb;
    private Creature creatures[];
    protected String hygiene;
    public String toString()
    {
        return "C'est un enclos";
    }
    protected void addCreature(Creature creature)
    {
        this.creatures[this.freeIndex()] = creature;
    }

    private int freeIndex() {
        return 0;
    }

    protected Creature removeCreature(Creature creature)
    {
        return null;
    }
    protected void clean()
    {

    }
}
