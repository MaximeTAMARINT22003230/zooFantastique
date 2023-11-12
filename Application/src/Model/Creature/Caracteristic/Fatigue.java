package Model.Creature.Caracteristic;

public enum Fatigue {
    SLEEP, EXHAUSTED, SLEEPY, GOOD, EXCITED;

    /**
     * @return renvoie le stade de fatigue suivant
     */
    public Fatigue gettingFatigue() {
        if (ordinal() > 0) {
            return values()[ordinal()-1];
        }
        else {
            return values()[ordinal()];
        }
    }

    /**
     * @return renvoie le stade de fatigue le moin haut
     */
    public Fatigue sleep() {
        return values()[values().length-1];
    }
}
