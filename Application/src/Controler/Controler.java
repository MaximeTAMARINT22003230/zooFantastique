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
    public void notification(Notification notification, Creature notificator)
    {
        switch (notification)
        {
            case KILL :
                // kill the animal
                break;
            case DESTROY :
                // destroy a corral
            default:
                // Unknown notification
        }
    }
    public void addCreature(Creature creature, Corral corral)
    {
        Interface.show("Vous avez accueilli une nouvelle créature");
    }
    public void addCorral(Corral corral)
    {
        Interface.show("Vous avez inauguré un nouvel enclos");
    }
}
