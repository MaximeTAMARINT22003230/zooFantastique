package Game.Creature.Caracteristic;

public enum Fatigue {
    SLEEP, EXHAUSTED, SLEEPY, GOOD, EXCITED;

    /**
     * @return to the lower fatigue stage if not already at its lowest
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
     * @return the lowest fatigue stage
     */
    public Fatigue sleep() {
        return values()[values().length-1];
    }

    /**
     * Checks if the current state is sleeping.
     *
     * @return true if the ordinal value is 0 (indicating a sleeping state), otherwise returns false.
     */
    public boolean isSleeping() {
        return ordinal() == 0;
    }
}
