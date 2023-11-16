package Model.Corral;

import Model.Creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Corral {
    private static int MAX = 5;
    protected String name;
    protected String size;
    protected int max;
    private List<Creature> creatures;
    protected String hygiene;
    protected String food;
    protected Corral(String name, String size)
    {
        this.name = name;
        this.size = size;
        this.max = MAX;
        this.creatures = new ArrayList<Creature>();
    }
    public static Corral inaugurate(String name, String size)
    {
        return new Corral(name, size);
    }
    public String toString()
    {
        String returnString = "Enclos " + this.name + "\n";
        for (Creature creature : this.creatures) {
            returnString += creature;
        }
        return returnString;
    }
    public void addCreature(Creature creature)
    {
        this.creatures.add(creature);
    }

    public Creature removeCreature(Creature creature)
    {
        return this.creatures.remove(this.creatures.indexOf(creature));
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
        for(Creature creature : this.creatures)
        {
            if (creature.equals(searched))
            {
                return true;
            }
        }
        return false;
    }
}
