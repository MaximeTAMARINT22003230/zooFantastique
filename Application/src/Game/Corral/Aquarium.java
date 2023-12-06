package Game.Corral;

import Game.Creature.Behavior.Swim;

public class Aquarium extends Corral {
    private Swim creatures[];
    private Aquarium(String name, String size) {
        super(name, size);
    }
    public static Aquarium inaugurate(String name, String size)
    {
        return new Aquarium(name, size);
    }
}
