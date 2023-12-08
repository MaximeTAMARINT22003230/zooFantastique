package Game.Creature.Behavior;

import Game.Creature.Creature;
import Player.Controler;
import Game.Logic.Cooldown.Cooldown;
import Game.Logic.Cooldown.CooldownType;
import Game.Logic.Cooldown.Cooldownable;

import java.util.Objects;

/** The Pregnancy behavior, used by Viviparians
 * Allows a creature to make a baby (usually female)
 */
public class Pregnancy extends BirthBehavior implements Cooldownable {
    /** The carried baby
     * Is null until inseminated
     */
    private Creature baby;
    /** The creature carrying the child */
    private Creature parent;
    /** The basic pregnancy time */
    private static final int PREGNANCY_COOLDOWN = 49999;

    /** Inseminate the parent with a new baby
     *
     * @param baby the future newborn
     * @param parent the baby's parent
     */
    public void inseminate(Creature baby, Creature parent)
    {
        this.baby = baby;
        this.parent = parent;
        this.pregnancyCooldown();
    }

    /** Give birth to the handled baby
     * Adds it to the parent's corral
     */
    public void giveBirth()
    {
        Controler.getInstance().addCreature(this.baby, Controler.getInstance().zoo.corralOf(this.parent));
        this.baby = null;
    }

    /** Implementation from the Cooldownable interface
     * Handled cooldowns :
     *     - INCUBATION : Give birth to the carried baby
     * @param cooldown
     */
    @Override
    public void cooldown(Cooldown cooldown) {
        //throw new Exception("Unhandled cooldown");
        if (Objects.requireNonNull(cooldown.getType()) == CooldownType.INCUBATION) {
            this.giveBirth();
        }
    }

    /** Start a pregnancy */
    private void pregnancyCooldown()
    {
        new Cooldown(PREGNANCY_COOLDOWN, this, CooldownType.INCUBATION);
    }
}
