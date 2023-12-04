package Model.Creature.Caracteristic;

public enum Health {
    SUFFERING, ILL, SKATE, GOOD, VIGOROUS;

    /**
     * @return le stade de soin supérieur si il n'est pas déjà au plus haut
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
     *
     * @return le stade de soin inférieur si il n'est pas déjà au plus bas
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
