package Game.Creature;

import Interactions.Controler;
import Game.Corral.Corral;

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
    static public Egg lay(Creature creature, Corral corral)
    {
        return new Egg(creature, corral, 15000);
    }
    public void hatch()
    {
        Controler.getInstance().addCreature(this.creature, this.corral);
        Controler.getInstance().notification("Une oeuf a éclot !");
    }
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
