package Creature;

import Creature.Caracteristic.*;

public abstract class Creature {
    protected String name;
    protected Sex sex;
    protected Weight weight;
    protected Height height;
    protected Age age;
    protected Hunger hunger;
    protected String fatigue;
    protected String health;
    protected abstract void eat();
    protected abstract void shout();
    protected abstract void heal();
    protected abstract void sleep();
    protected abstract void age();
}
