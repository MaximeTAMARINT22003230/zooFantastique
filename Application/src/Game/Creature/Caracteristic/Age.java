package Game.Creature.Caracteristic;

import Player.Controler;

public enum Age {
    BABY, CHILD, TEEN, ADULT, ELDER;

    /**
     * @return renvoie le stade de l'age suivant de l'entité. Si déjà au dernier stade il meurt.
     */
    public Age gettingOder() {
        if (ordinal() < values().length-1) {
            Controler.getInstance().notification("prend de l'age");
            return values()[ordinal()+1];
        }
        else {
            return values()[ordinal()];
        }
    }
}
