package Model;

import Controler.ZooMaster;
import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Enclosure.Enclosure;

import java.util.ArrayList;
import java.util.List;

public class Zoo {
    private final int MAX = 5;
    private String name;
    private ZooMaster zooMaster;
    private int maxEnclosures;
    private List<Enclosure> enclosures;
    private Zoo(String name, ZooMaster zooMaster)
    {
        this.name = name;
        this.zooMaster = zooMaster;
        this.maxEnclosures = MAX;
        this.enclosures = new ArrayList<Enclosure>();
    }
    public static Zoo opening(String name, ZooMaster zooMaster)
    {
        System.out.println("Vous avez inauguré votre propre Zoo !");
        return new Zoo(name, zooMaster);
    }
    public String showCreatures()
    {
        StringBuilder creatures = new StringBuilder("Créatures du Zoo " + this.name);
        for (Enclosure enclosure : this.enclosures) {
            creatures.append(enclosure);
        }
        return creatures.toString();
    }
    public int numberOfCreatures()
    {
        int count = 0;
        for (Enclosure enclosure : this.enclosures) {
            count += enclosure.count();
        }
        return count;
    }
    public String toString()
    {
        return this.name + "\n" +
                "    Propriétaire du Zoo : " + this.zooMaster + "\n" +
                "    " + this.showCreatures();
    }
}
