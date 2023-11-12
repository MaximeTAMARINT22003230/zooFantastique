package Model.Creature.Caracteristic;

public enum Health {
    SUFFERING, ILL, SKATE, GOOD, VIGOROUS;

    /**
     * @return le stade de soin supérieur
     */
    public Health heal() {
        if (ordinal() < values().length-1) {
            return values()[ordinal()+1];
        }
        else {
            return values()[ordinal()];
        }
    }
}
