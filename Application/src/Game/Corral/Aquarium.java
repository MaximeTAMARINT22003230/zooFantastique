package Game.Corral;

import Game.Creature.Behavior.Fly;
import Game.Creature.Behavior.Swim;
import Game.Creature.Creature;

import java.util.ArrayList;
import java.util.List;

public class Aquarium extends Corral {
    private List<Swim> creatures;
    private int depth;
    private Aquarium(String name, String size) {
        super(name, size);
        this.creatures = new ArrayList<Swim>();
    }
    public static Aquarium inaugurate(String name, String size)
    {
        return new Aquarium(name, size);
    }

    public String toString()
    {
        StringBuilder returnString = new StringBuilder("Enclos " + this.name + "\n");
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Swim creature : this.creatures) {
            creatures.add((Creature) creature);
        }
        for (Creature creature : creatures) {
            returnString.append(creature.getName()).append("\n");
        }
        return returnString.toString();
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
