package Model.Corral;

import Model.Creature.Behavior.Run;
import Model.Creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Corral {
    private static final int MAX = 5;
    protected String name;
    protected String size;
    protected int max;
    private List<Run> creatures;
    protected String hygiene;
    protected String food;
    protected Corral(String name, String size)
    {
        this.name = name;
        this.size = size;
        this.max = MAX;
        this.creatures = new ArrayList<Run>();
    }
    public static Corral inaugurate(String name, String size)
    {
        return new Corral(name, size);
    }
    public String toString()
    {
        StringBuilder returnString = new StringBuilder("Enclos " + this.name + "\n");
        for (Run creature : this.creatures) {
            returnString.append(creature);
        }
        return returnString.toString();
    }
    public void addCreature(Creature creature)
    {
        if (creature instanceof Run)
        {
            this.creatures.add((Run) creature);
        }
    }

    public Creature removeCreature(Creature creature)
    {
        return (Creature) this.creatures.remove(this.creatures.indexOf((Run) creature));
    }
    public void clean()
    {

    }
    public int count()
    {
        return 0;
    }
    public void feed()
    {

    }
    public boolean hasFreeSpace()
    {
        return true;
    }
    public boolean contains(Creature searched)
    {
        for(Run creature : this.creatures)
        {
            if (creature.equals(searched))
            {
                return true;
            }
        }
        return false;
    }
}
