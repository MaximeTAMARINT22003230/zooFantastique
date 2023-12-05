package Game.Creature.Caracteristic;

public enum Weight {
    LIGHT, AVERAGE, HEAVY, MASSIVE;

    /**
     * @return to the next width level if not already at the top
     */
    public Weight toSwell() {
        if (ordinal() < values().length-1) {
            return values()[ordinal()+1];
        }
        else {
            return values()[ordinal()];
        }
    }

    /**
     * @return to the previous width level if it is not already at its lowest
     */
    public Weight toLoseWeight() {
        if (ordinal() > 0) {
            return values()[ordinal()-1];
        }
        else {
            return values()[ordinal()];
        }
    }
}
