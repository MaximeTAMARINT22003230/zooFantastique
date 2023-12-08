package Game.Creature.Behavior;

import Game.Creature.Creature;

/** Abstract class used to give a comon type (and in the future, common properties) to the birthing behaviors
 */
public abstract class BirthBehavior
{
    public abstract void makeBaby(Creature baby, Creature parent);
}
