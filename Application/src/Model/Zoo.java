package Model;

import Controler.ZooMaster;
import Model.Creature.Creature;
import Model.Enclosure.Corral;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private final int MAX = 5;
    private String name;
    private ZooMaster zooMaster;
    private int maxEnclosures;
    private List<Corral> corrals;
    private Zoo(String name, ZooMaster zooMaster)
    {
        this.name = name;
        this.zooMaster = zooMaster;
        this.maxEnclosures = MAX;
        this.corrals = new ArrayList<Corral>();
    }
    public static Zoo opening(String name, ZooMaster zooMaster)
    {
        System.out.println("Vous avez inauguré votre propre Zoo !");
        return new Zoo(name, zooMaster);
    }
    public String showCreatures()
    {
        StringBuilder creatures = new StringBuilder("Créatures du Zoo " + this.name);
        for (Corral corral : this.corrals) {
            creatures.append(corral);
        }
        return creatures.toString();
    }
    public int numberOfCreatures()
    {
        int count = 0;
        for (Corral corral : this.corrals) {
            count += corral.count();
        }
        return count;
    }
    public String toString()
    {
        return this.name + "\n" +
                "    Propriétaire du Zoo : " + this.zooMaster + "\n" +
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
}
