package Game.Creature.Behavior;

import Game.Corral.Corral;
import Game.Creature.Creature;
import Game.Creature.Egg;

public class Laying extends BirthBehavior {
    public Egg lay(Creature creature, Corral corral)
    {
        return Egg.lay(creature, corral);
    }
}
