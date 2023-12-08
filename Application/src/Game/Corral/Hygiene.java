package Game.Corral;

import Interactions.Controler;

public enum Hygiene {
    BAD, CORRECTLY, GOOD;

    public Hygiene clean() {
        if (ordinal() < values().length - 1) {
            Controler.getInstance().notification("L'enclos est plus propre.");
            return values()[ordinal() + 1];
        } else {
            return values()[ordinal()];
        }
    }
}
