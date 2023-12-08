package Game.Corral;

import Game.Creature.Behavior.Fly;
import Game.Creature.Creature;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an aviary
 */
public class Aviary extends Corral {
    private List<Fly> creatures;
    private int height;
    private Aviary(String name, String size) {
        super(name,size);
        this.creatures = new ArrayList<Fly>();
    }

    /**
     * Creates and returns a new instance of Aviary.
     *
     * @param name The name of the aviary.
     * @param size The size of the aviary.
     * @return A new Aviary instance.
     */
    public static Aviary inaugurate(String name, String size) {
        return new Aviary(name, size);
    }

    public String toString()
    {
        StringBuilder returnString = new StringBuilder("Enclos " + this.name + "\n");
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Fly creature : this.creatures) {
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
        if (!(creature instanceof Fly))
        {
            throw new IllegalArgumentException("Cette créature ne peut pas voler");
        }
        assert creature instanceof Fly;
        this.creatures.add((Fly) creature);
        Thread thread = new Thread(creature);
        thread.start();
    }

    @Override
    public Creature removeCreature(Creature creature)
    {
        return (Creature) this.creatures.remove(this.creatures.indexOf((Fly) creature));
    }

}
