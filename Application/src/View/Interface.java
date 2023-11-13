package View;

import Controler.*;
import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Creature.Creature;
import Model.Enclosure.Corral;
import Model.Zoo;

public class Interface {
    public void show(String string)
    {
        System.out.println(string);
    }
    private ZooMaster createYourZooMaster()
    {
        String name = "Gabriel";
        Sex sex = Sex.MALE;
        Age age = Age.ADULT;
        return new ZooMaster(name,sex,age);
    }
    public Zoo createYourZoo()
    {
        ZooMaster zooMaster = this.createYourZooMaster();
        String name = "Mon zoo";
        return Zoo.opening(name, zooMaster);
    }
    public Corral createACorral()
    {
    }
    public Creature createACreature()
    {
    }
}
