package Interactions;

import Game.Corral.*;
import Game.Creature.Creature;
import Player.Zoo;

/**
 * The main controler of the app. <br>
 * Is a Singleton that contain the Zoo
 * and a bunch of usefull static methods.
 */
public class Controler
{
    /** The zoo */
    public Zoo zoo;
    /** Contain the Contoler's instance. <br>
     * Is static to allow the use of the Singleton design pattern
     */
    private static Controler instance;
    /** True while the game is running, become False when the players ends it.
     */
    public static boolean game;

    /** Create a new Controler <br>
     * Can only be used by its inner properties
     */
    private Controler()
    {
        this.zoo = Creator.createYourZoo();
    }

    /** Give the instance of the Controler or create one if needed
     * @return The instance of the Controler
     */
    public static Controler getInstance()
    {
        if(instance == null)
        {
            game = true;
            instance = new Controler();
        }
        return instance;
    }

    /** Send a notification to the user (usually used when a Crature has something to say) <br>
     * Allows a separation between the Model and the Interface
     * @param notification What it has to say
     */
    public void notification(String notification)
    {
        Interface.show(notification);
    }
    /** Send a notification to the user (usually used when a Crature has something to say) <br>
     * Allows a separation between the Model and the Interface
     * @param notification What it has to say
     */
    public void notification(Object notification)
    {
        Interface.show(notification.toString());
    }

    /** Add a new creature to the Zoo
     * @param creature The creature to add
     * @param corral The targeted corral
     */
    public void addCreature(Creature creature, Corral corral)
    {
        this.zoo.addCreature(corral, creature);
        Interface.show("Vous avez accueilli une nouvelle créature");
    }

    /** Add a new Corral to the Zoo
     * @param corral The corral to be added
     */
    public void addCorral(Corral corral)
    {
        this.zoo.addCorral(corral);
        Interface.show("Vous avez inauguré un nouvel enclos");
    }
    /** Remove a creature from the zoo
     * @param creature The creature to remove
     */
    public void removeCreature(Creature creature)
    {
        this.zoo.removeCreature(creature);
        Interface.show("Vous avez tué une créature...");
    }

    /** Remove a Corral from the Zoo
     * @param corral The corral to remove
     */
    public void removeCorral(Corral corral)
    {
        this.zoo.removeCorral(corral);
        Interface.show("Vous avez explosé un enclos...");
    }
}