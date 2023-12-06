package Game.Corral;

import Game.Creature.Behavior.Run;
import Game.Creature.Creature;
import Interactions.Interface;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an enclosure to house creatures with the ability to run.
 */
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

    /**
     * Creates and returns a new instance of Corral.
     *
     * @param name The name of the corral.
     * @param size The size of the corral.
     * @return A new Corral instance.
     */
    public static Corral inaugurate(String name, String size)
    {
        return new Corral(name, size);
    }
    public String toString()
    {
        StringBuilder returnString = new StringBuilder("Enclos " + this.name + "\n");
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Run run : this.creatures) {
            creatures.add((Creature) run);
        }
        for (Creature creature : creatures) {
            returnString.append(creature.getName()).append("\n");
        }
        return returnString.toString();
    }
    public void addCreature(Creature creature)
    {
        if (!(creature instanceof Run))
        {
            // TODO : THROW ERROR
        }
        assert creature instanceof Run;
        this.creatures.add((Run) creature);
        Thread thread = new Thread(creature);
        thread.start();
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
        //TODO : this method
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
    public boolean empty()
    {
        return this.creatures.isEmpty();
    }

    /**
     * Retrieves the name of the corral.
     *
     * @return The name of the corral.
     */
    public String getName() {
        return name;
    }
    /**
     * Retrieves a list of creatures in the corral.
     *
     * @return A list of creatures.
     */
    public List<Creature> getCreatures()
    {
        List<Creature> creatures = new ArrayList<>();
        for (Run creature : this.creatures) {
            creatures.add((Creature) creature);
        }
        Interface.show(creatures.toString());
        return creatures;
    }
}