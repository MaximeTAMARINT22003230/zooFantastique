package Game.Corral;

import Game.Creature.Behavior.Swim;
import Game.Creature.Creature;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an aquarium
 */
public class Aquarium extends Corral {
    private List<Swim> creatures;
    private int depth;
    private Aquarium(String name, String size) {
        super(name, size);
        this.creatures = new ArrayList<Swim>();
    }

    /**
     * Creates and returns a new instance of Aquarium.
     *
     * @param name The name of the aquarium.
     * @param size The size of the aquarium.
     * @return A new Aquarium instance.
     */
    public static Aquarium inaugurate(String name, String size) {
        return new Aquarium(name, size);
    }

    @Override
    protected ArrayList<Creature> completeTable() {
       ArrayList<Creature> creatures = new ArrayList<>();
       for (Swim creature : this.creatures) {
           creatures.add((Creature) creature);
       }
       return creatures;
   }
    @Override
    public void addCreature(Creature creature)
    {
        if (!(creature instanceof Swim))
        {
            throw new IllegalArgumentException("Cette créature ne peut pas nager");
        }
        assert creature instanceof Swim;
        this.creatures.add((Swim) creature);
        Thread thread = new Thread(creature);
        thread.start();
    }

    @Override
    public Creature removeCreature(Creature creature)
    {
        return (Creature) this.creatures.remove(this.creatures.indexOf((Swim) creature));
    }
}
