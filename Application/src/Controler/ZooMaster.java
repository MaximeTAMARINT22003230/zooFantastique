package Controler;

import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Creature.Creature;
import Model.Enclosure.Corral;
import Model.Zoo;

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
    private String check(Corral corral)
    {
        return corral.toString();
    }
    private void clean(Corral corral)
    {
        corral.clean();
    }
    private void feed(Corral corral)
    {
        corral.feed();
    }
    private void move(Creature creature, Corral corral, Zoo zoo)
    {
        if(zoo.contains(creature) && corral.hasFreeSpace())
        {
            corral.addCreature(zoo.corralOf(creature).removeCreature(creature));
        }
    }
}
