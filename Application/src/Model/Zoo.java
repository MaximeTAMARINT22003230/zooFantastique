package Model;

import Model.Creature.Creature;
import Model.Corral.Corral;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Zoo {
    private final int MAX = 5;
    private String name;
    private ZooMaster zooMaster;
    private int maxCorral;
    private List<Corral> corrals;
    private Zoo(String name, ZooMaster zooMaster)
    {
        this.name = name;
        this.zooMaster = zooMaster;
        this.maxCorral = MAX;
        this.corrals = new ArrayList<Corral>();
    }
    public static Zoo opening(String name, ZooMaster zooMaster)
    {
        System.out.println("Vous avez inauguré votre propre Zoo !");
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
    public boolean contains(Creature creature)
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
}
