package Game.Creature.Behavior;

import Game.Creature.Creature;
import Game.Creature.Egg;
import Player.Controler;

/** The Laying behavior, used by Oviparrian
 * Allows a creature to lay eggs
 */
public class Laying extends BirthBehavior {
    /**
     * Lay a new egg in a given corral
     * @param creature The creature laying an egg
     * @return the new egg
     */
    public Egg lay(Creature creature)
    {
        return Egg.lay(creature, Controler.getInstance().zoo.corralOf(creature));
    }
}
