package Model.Creature.Caracteristic;

public enum Age {
    BABY, CHILD, TEEN, ADULT, ELDER;

    /**
     * @return renvoie le stade de l'age suivant de l'entité. Si déjà au dernier stade il meurt.
     */
    public Age gettingOder() {
        if (ordinal() < values().length-1) {
            return values()[ordinal()+1];
        }
        else {
            return values()[ordinal()];
        }
    }
}
