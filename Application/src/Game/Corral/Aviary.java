package Game.Corral;

import Game.Creature.Behavior.Fly;

/**
 * Represents an aviary
 */
public class Aviary extends Corral {
    private Fly[] creatures;
    private int height;

    private Aviary(String name, String size) {
        super(name, size);
    }

    /**
     * Creates and returns a new instance of Aviary.
     *
     * @param name The name of the aviary.
     * @param size The size of the aviary.
     * @return A new Aviary instance.
     */
    public static Aviary inaugurate(String name, String size) {
        return new Aviary(name, size);
    }

    @Override
    public void clean() {
        super.clean();
    }
}