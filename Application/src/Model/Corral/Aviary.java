package Model.Corral;

import Model.Creature.Behavior.Fly;

public class Aviary extends Corral {
    private Fly creatures[];
    private int Height;
    private Aviary(String name, String size) {
        super(name, size);
    }
    @Override
    public void clean() {
        super.clean();
    }
}
