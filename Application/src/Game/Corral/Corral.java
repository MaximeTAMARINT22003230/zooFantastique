package Game.Corral;

import Game.Creature.Behavior.Revive;
import Game.Corral.Caracteristic.Hygiene;
import Game.Creature.Behavior.Run;
import Game.Creature.Bestiary.*;
import Game.Creature.Caracteristic.StorageLevel;
import Game.Creature.Creature;
import Game.Logic.DiceRoll;
import Game.Lycantropus.Lycantropus;
import Player.Interface;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents an enclosure to house creatures with the ability to run.
 */
public class Corral implements Runnable{
    private static final int MAX = 5;
    protected String name;
    protected String size;
    protected int max;
    private List<Run> creatures;
    protected Hygiene hygiene;
    private boolean isDestroyed;
    protected StorageLevel food;

    protected Corral(String name, String size)
    {
        this.name = name;
        this.size = size;
        this.max = MAX;
        this.food = StorageLevel.MANY;
        this.creatures = new ArrayList<Run>();
        this.hygiene = Hygiene.GOOD;
        this.isDestroyed = false;
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

    protected ArrayList<Creature> completeTable() {
        ArrayList<Creature> creatures = new ArrayList<>();
        for (Run creature : this.creatures) {
            creatures.add((Creature) creature);
        }
        return creatures;
    }

    public String toString()
    {
        StringBuilder returnString = new StringBuilder("Enclos " + this.name + "\n");
        ArrayList<Creature> creatures = completeTable();
        for (Creature creature : creatures) {
            returnString.append(creature.getName()).append("\n");
        }
        return returnString.toString();
    }
    public void addCreature(Creature creature)
    {
        if (!(creature instanceof Run))
        {
            throw new IllegalArgumentException("Cette créature ne peut pas courir");
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
    public void clean() {
        this.hygiene = this.hygiene.clean();
        System.out.println("L'enclos a été nettoyé. Niveau de propreté : " + this.hygiene);
    }

    public Hygiene getHygiene() {
        return this.hygiene;

    public void kill(Creature creature)
    {
        if (creature instanceof Revive) {
            String type = creature.getClass().getSimpleName();
            removeCreature(creature);
            switch (type) {
                case "Dragon":
                    creature = Dragon.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Kraken":
                    creature = Kraken.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Lycantropus":
                    creature = Lycantropus.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Megalodon":
                    creature = Megalodon.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Mermaid":
                    creature = Mermaid.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Nymph":
                    creature = Nymph.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Phenix":
                    creature = Phenix.newBorn(creature.getName(),creature.getSex());
                    break;
                case "Unicorn":
                    creature = Unicorn.newBorn(creature.getName(),creature.getSex());
                    break;
            }
            addCreature(creature);
        }
        else
            removeCreature(creature);
    }

    public void clean()
    {
        hygiene= Hygiene.GOOD;
        System.out.println("Le Corral a été nettoyé et est maintenant propre.");
    }
    public int count()
    {
        return 0;
    }
    public void feed()
    {
        this.food = food.fillStorage();
    }
    protected void givesFoodToCreature()
    {
        if (!this.food.isEmpty()) {
            ArrayList<Creature> creatures = completeTable();
            for (Creature creature : creatures) {
                if (creature.getHunger().isHungry()) {
                    creature.eat();
                    if (DiceRoll.d20() == 1)
                        this.food.levelDown();
                }
            }
        }
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
    @Override
    public void run(){
        while (!isDestroyed)
        {
            givesFoodToCreature();
                try
                {
                    Thread.sleep(10000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
         }
    }
    public void destroy()
    {
        this.isDestroyed = true;
    }
    public boolean checkCreature(Creature creature) {
        if (creatures.isEmpty()) {
            return true;
        } else {

            Class<?> newCreatureType = creature.getClass();
            for (Run existingCreature : creatures) {
                Class<?> existingCreatureType = existingCreature.getClass();
                if (!existingCreatureType.equals(newCreatureType)) {

                    return false;
                }
            }

            return true;
        }
    }

}