package Game.Creature;

import Player.Controler;
import Game.Corral.Corral;
/**
 * Represents an egg that can hatch into a creature.
 */
public class Egg implements Runnable{
    private Creature creature;
    private int hatchTime;
    private Corral corral;
    private Egg(Creature creature, Corral corral, int hatchTime)
    {
        this.creature = creature;
        this.corral = corral;
        this.hatchTime = hatchTime;
    }

    /**
     * Creates and returns a new Egg laid by a creature in a specific corral.
     *
     * @param creature The creature laying the egg.
     * @param corral   The corral where the egg is laid.
     * @return A new Egg instance.
     */
    static public Egg lay(Creature creature, Corral corral)
    {
        return new Egg(creature, corral, 15000);
    }

    /**
     * Hatches the egg, adding the creature to the corral after the hatching time.
     */
    public void hatch()
    {
        Controler.getInstance().addCreature(this.creature, this.corral);
        Controler.getInstance().notification("Une oeuf a éclot !");
    }

    /**
     * Runs a thread to simulate the hatching process after the specified hatch time.
     */
    @Override
    public void run() {
        try {
            Thread.sleep(this.hatchTime);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.hatch();
    }
}
