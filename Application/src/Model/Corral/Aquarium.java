package Model.Corral;

import Model.Creature.Behavior.Swim;

public class Aquarium extends Corral {
    private Swim creatures[];

    private Aquarium(String name, String size) {
        super(name, size);
    }
}
