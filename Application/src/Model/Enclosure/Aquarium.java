package Model.Enclosure;

import Model.Creature.Behavior.Swim;

public class Aquarium extends Corral {
    private Swim creatures[];

    public Aquarium(String name, String size) {
        super(name, size);
    }
}
