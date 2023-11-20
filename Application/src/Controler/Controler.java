package Controler;

import Model.Corral.*;
import Model.Creature.Creature;
import View.Interface;

/**
 * The main controler of the app.
 * Listening to anything happening in the zoo.
 */
public class Controler{
    public Zoo zoo;
    public static Controler instance = new Controler();
    public Controler()
    {
        this.zoo = Creator.createYourZoo();
    }
    public void notification(String notification)
    {
        Interface.show(notification);
    }
    public void addCreature(Creature creature, Corral corral)
    {
        this.zoo.addCreature(corral, creature);
        Interface.show("Vous avez accueilli une nouvelle créature");
    }
    public void addCorral(Corral corral)
    {
        this.zoo.addCorral(corral);
        Interface.show("Vous avez inauguré un nouvel enclos");
    }
    public void removeCreature(Creature creature)
    {
        this.zoo.removeCreature(creature);
        Interface.show("Vous avez tué une créature...");
    }
    public void removeCorral(Corral corral)
    {
        this.zoo.removeCorral(corral);
        Interface.show("Vous avez explosé un enclos...");
    }
}