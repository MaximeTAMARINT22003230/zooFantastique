package Model.Enclosure;

import Model.Creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Enclosure {
    private static int MAX = 5;
    protected String name;
    protected String size;
    protected int max;
    private List<Creature> creatures;
    protected String hygiene;
    public Enclosure(String name, String size)
    {
        this.name = name;
        this.size = size;
        this.max = MAX;
        this.creatures = new ArrayList<Creature>();
    }
    public String toString()
    {
        String returnString = "Enclos " + this.name + "\n";
        for (Creature creature : this.creatures) {
            returnString += creature;
        }
        return returnString;
    }
    protected void addCreature(Creature creature)
    {
        this.creatures.add(creature);
    }

    protected Creature removeCreature(Creature creature)
    {
        return this.creatures.remove(this.creatures.indexOf(creature));
    }
    protected void clean()
    {

    }
    public int count()
    {
        return 0;
    }
}
