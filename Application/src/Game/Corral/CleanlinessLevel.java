package Game.Corral;

import Interactions.Controler;

public enum CleanlinessLevel {
    BAD, CORRECTLY, GOOD;

    public CleanlinessLevel improveCleanliness() {
        if (ordinal() < values().length - 1) {
            Controler.getInstance().notification("L'enclos est plus propre.");
            return values()[ordinal() + 1];
        } else {
            return values()[ordinal()];
        }
    }
}
