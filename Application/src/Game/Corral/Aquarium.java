package Game.Corral;

import Game.Creature.Behavior.Swim;

/**
 * Represents an aquarium
 */
public class Aquarium extends Corral {
    private Swim[] creatures;

    private Aquarium(String name, String size) {
        super(name, size);
    }

    /**
     * Creates and returns a new instance of Aquarium.
     *
     * @param name The name of the aquarium.
     * @param size The size of the aquarium.
     * @return A new Aquarium instance.
     */
    public static Aquarium inaugurate(String name, String size) {
        return new Aquarium(name, size);
    }
}