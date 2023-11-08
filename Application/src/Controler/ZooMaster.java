package Controler;

import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Creature.Creature;
import Model.Enclosure.Enclosure;

public class ZooMaster {
    private String name;
    private Sex sex;
    private Age age;
    public ZooMaster(String name, Sex sex, Age age)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
    }
    private String check(Enclosure enclosure)
    {
        return enclosure.toString();
    }
    private void clean(Enclosure enclosure)
    {

    }
    private void feed(Enclosure enclosure)
    {

    }
    private void move(Creature creature, Enclosure enclosure)
    {

    }
}
