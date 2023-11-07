package Controler;

import Model.Enclosure.Enclosure;
import Model.ZooMaster;

public class Zoo {
    private final int MAX = 5;
    private String name;
    private ZooMaster zooMaster;
    private int maxEnclosures;
    private Enclosure enclosures[];
    private Zoo(String name, ZooMaster zooMaster)
    {
        this.name = name;
        this.zooMaster = zooMaster;
        this.maxEnclosures = MAX;
    }
    public static Zoo opening(String name, ZooMaster zooMaster)
    {
        System.out.println("Vous avez inauguré votre propre Zoo !");
        return new Zoo(name, zooMaster);
    }
}
