package Model.Creature.Caracteristic;

public enum Hunger {
    STARVING, HUNGRY, GOOD, MEALS;

    /**
     * @return renvoie le stade de faim inférieur
     */
    public Hunger eat() {
        if (ordinal() < values().length-1) {
            return values()[ordinal()+1];
        }
        else {
            return values()[ordinal()];
        }
    }
}
