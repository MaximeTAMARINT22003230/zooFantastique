package Game.Creature.Caracteristic;

import Interactions.Controler;

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

    public boolean isSleeping() {
        if (ordinal() == 0)
            return true;
        return false;
    }
}
