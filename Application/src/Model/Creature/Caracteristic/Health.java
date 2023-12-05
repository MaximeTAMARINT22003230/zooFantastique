package Model.Creature.Caracteristic;

public enum Health {
    SUFFERING, ILL, SKATE, GOOD, VIGOROUS;

    /**
     * @return to the next level of care if not already at the top
     */
    public Health heal() {
        if (ordinal() < values().length-1) {
            return values()[ordinal()+1];
        }
        else {
            return values()[ordinal()];
        }
    }

    /**
     * @return to the lower care stage if not already at the lowest level
     */
    public Health loseHealth() {
        if (ordinal() > 0) {
            return values()[ordinal()-1];
        }
        else {
            return values()[ordinal()];
        }
    }
}
