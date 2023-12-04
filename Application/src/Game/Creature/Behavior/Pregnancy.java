package Game.Creature.Behavior;

import Game.Corral.Corral;
import Game.Creature.Creature;
import Interactions.Controler;
import Game.Cooldown.Cooldown;
import Game.Cooldown.CooldownType;
import Game.Cooldown.Cooldownable;

public class Pregnancy extends BirthBehavior implements Cooldownable {
    private Creature baby;
    private Corral corral;
    private static final int PREGNANCY_COOLDOWN = 49999;
    public void inseminate(Creature baby, Corral corral)
    {
        this.baby = baby;
        this.corral = corral;

    }
    public void giveBirth()
    {
        Controler.getInstance().addCreature(this.baby, this.corral);
    }
    @Override
    public void cooldown(Cooldown cooldown) {
        switch (cooldown.getType())
        {
            case  CooldownType.INCUBATION:
                this.giveBirth();
                break;
            default:
                //throw new Exception("Unhandled cooldown");
        }
    }
    private void pregnancyCooldown()
    {
        new Cooldown(PREGNANCY_COOLDOWN, this, CooldownType.INCUBATION);
    }
}
