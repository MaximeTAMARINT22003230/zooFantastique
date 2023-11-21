package Controler;

import Model.Creature.Creature;
import Model.Corral.Corral;
import Model.ZooMaster;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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
        Controler.start();
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
                "    " + this.showCreatures();
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
        if(this.countCorrals() > maxCorral)
        {
            this.corrals.add(corral);
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
        this.corralOf(creature).removeCreature(creature);
    }
}
