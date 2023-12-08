package Game.Creature.Caracteristic;

/**
 * Enumeration representing the food storage levels of a creature.
 */
public enum StorageLevel {
    EMPTY, LITTLE,AVERAGE,MANY;

    /**
     * Gives the lower food storage level, if it exists.
     * @return the lower storage level, otherwise the same level.
     */
    public StorageLevel levelDown() {
        if (ordinal() > 0) {
            return values()[ordinal() - 1];
        } else {
            return values()[ordinal()];
        }
    }

    /**
     * Fills the food storage to the highest level.
     * @return the highest storage level.
     */
    public StorageLevel fillStorage() {
        return values()[values().length - 1];
    }

    /**
     * Checks if the food storage is empty.
     * @return true if the level is empty, otherwise false.
     */
    public boolean isEmpty() {
        return ordinal() == 0;
    }
}
