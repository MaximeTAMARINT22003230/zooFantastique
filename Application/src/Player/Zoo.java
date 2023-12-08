package Player;

import Game.Creature.Behavior.Revive;
import Interactions.Controler;
import Game.Creature.Creature;
import Game.Corral.Corral;
import Interactions.Interface;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
/**
 * Represents a Zoo that manages various corrals and creatures.
 */
public class Zoo {
    private final int MAX = 5;
    private String name;
    public ZooMaster zooMaster;
    private int maxCorral;
    private List<Corral> corrals;
    private Zoo(String name, ZooMaster zooMaster)
    {
        this.name = name;
        this.zooMaster = zooMaster;
        this.maxCorral = MAX;
        this.corrals = new ArrayList<Corral>();
    }
    public static void main(String[] args) {
        Controler.getInstance();
        while(Controler.game)
        {
            Controler.getInstance().zoo.zooMaster.options();
        }
    }
    public static Zoo opening(String name, ZooMaster zooMaster)
    {
        return new Zoo(name, zooMaster);
    }
    public String showCreatures()
    {
        StringBuilder creatures = new StringBuilder("Créatures du Zoo " + this.name + "\n");
        for (Corral corral : this.corrals) {
            creatures.append(corral);
        }
        return creatures.toString();
    }
    public int countCreatures()
    {
        int count = 0;
        for (Corral corral : this.corrals) {
            count += corral.count();
        }
        return count;
    }
    public int countCorrals()
    {
        return this.corrals.size();
    }
    public String toString()
    {
        return this.name + "\n" +
                "    Propriétaire du Zoo : " + "\n" +
                "    " + this.zooMaster + "\n" +
                "    " + this.showOnlyCorrals();
    }
    private String showOnlyCorrals()
    {
        StringBuilder builder = new StringBuilder();
        for (Corral corral: this.corrals) {
            builder.append(corral.getClass().getSimpleName()).append(corral.getName()).append("\n");
        }
        return String.valueOf(builder);
    }
    private String showCorrals()
    {
        StringBuilder builder = new StringBuilder();
        for (Corral corral: this.corrals) {
            builder.append(corral.toString()).append("\n");
        }
        return String.valueOf(builder);
    }
    public boolean exists(Creature creature)
    {
        for (Corral corral : this.corrals) {
            if (corral.contains(creature))
            {
                return true;
            }
        }
        return false;
    }
    public Corral corralOf(Creature creature)
    {
        for (Corral corral : this.corrals) {
            if (corral.contains(creature))
            {
                return corral;
            }
        }
        return null;
    }
    public void addCorral(Corral corral)
    {
        if(this.countCorrals() < maxCorral)
        {
            this.corrals.add(corral);
            Thread thread = new Thread(corral);
            thread.start();
        }
    }
    public String corrals()
    {
        StringBuilder corralsBuilder = new StringBuilder();
        for (Corral corral : this.corrals) {
            corralsBuilder.append(corral.getName()).append("\n");
        }
        return String.valueOf(corralsBuilder);
    }
    public Corral corral(String string)
    {
        for (Corral corral : this.corrals) {
            if(Objects.equals(corral.getName(), string))
            {
                return corral;
            }
        }
        return null;
    }
    public void removeCorral(Corral corral)
    {
        this.corrals.remove(corral);
        corral.isDestroyed();
    }
    public void extend(int size)
    {
        this.maxCorral += size;
    }
    private boolean exists(Corral check)
    {
        for (Corral corral:this.corrals) {
            if(corral.equals(check))
            {
                return true;
            }
        }
        return false;
    }
    public void addCreature(Corral corral, Creature creature)
    {
        if (!this.exists(corral))
        {
            // Throw error
        }
        corral.addCreature(creature);
    }
    public void removeCreature(Creature creature)
    {
        if(exists(creature))
        {
            this.corralOf(creature).removeCreature(creature);
        }
        else
        {
            Interface.show("La créature n'existe pas");
        }
    }

    public void kill(Creature creature)
    {
        if(exists(creature))
        {
            this.corralOf(creature).kill(creature);
        }
        else
        {
            Interface.show("La créature n'existe pas");
        }
    }

    public void reviveCreature(Creature creature)
    {
        if(exists(creature))
        {
            this.corralOf(creature).removeCreature(creature);
        }
        else
        {
            Interface.show("La créature n'existe pas");
        }
    }

    public List<Corral> getCorrals()
    {
        return this.corrals;
    }
    public List<Creature> getCreatures()
    {
        List<Creature> creatures = new ArrayList<>();
        for (Corral corral: this.corrals)
        {
            for (Creature creature : corral.getCreatures())
            {
                creatures.add(creature);
            }
        }
        return creatures;
    }
}
