package Game.Creature.Caracteristic;

public enum Height {
    SMALL, AVERAGE, BIG, HUMONGOUS;

    /**
     * @return to the highest stage if not already at the top
     */
    public Height growUp() {
        if (ordinal() < values().length-1) {
            return values()[ordinal()+1];
        }
        else {
            return values()[ordinal()];
        }
    }
}
