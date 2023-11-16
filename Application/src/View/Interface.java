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
    public String input(String string)
    {
        this.show(string);
        return System.console().readLine();
    }
}
