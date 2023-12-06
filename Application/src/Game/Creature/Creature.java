package Game.Creature;

import Game.Creature.Behavior.BirthBehavior;
import Game.Creature.Caracteristic.*;
import Interactions.Controler;

/**
 * The creature abstract class. Contain anything common to all creatures.
 * Notify the controler when any change occures.
 */
public abstract class Creature implements Runnable{
    protected String name;
    protected Sex sex;
    protected Weight weight;
    protected Height height;
    protected Age age;
    protected Hunger hunger;
    protected Fatigue fatigue;
    protected Health health;
    protected boolean isAlive;
    protected boolean isSleeping;
    protected BirthBehavior birthingBehavior;
    protected Creature(String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health)
    {
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.hunger = hunger;
        this.fatigue = fatigue;
        this.health = health;
        this.isAlive = true;
        this.isSleeping = false;
    }
    protected void eat(){
        hunger = hunger.eat();
    }
    // notification pour dire je cris ?
    protected void toBeHungry() {
        if (this.hunger == Hunger.values()[0])
            loseHealth();
        this.hunger = hunger.toBeHungry();
    }
    protected void shout(){
        Controler.getInstance().notification(this.name+" émet un son ("+this.getClass().getSimpleName()+")");
    }
    protected  void loseHealth() {
        if (this.health == Health.values()[0]) {
            this.isAlive = false;
            Controler.getInstance().removeCreature(this);
        }
        this.health = health.loseHealth();
    }
    protected void heal(){
        health = health.heal();
    }
    protected void gettingFatigue() {
        if (this.fatigue == Fatigue.values()[0]) {
            sleep();
        }
        else {
            this.fatigue = fatigue.gettingFatigue();
            Controler.getInstance().notification(this.name+" getting fatigue ("+this.getClass().getSimpleName()+")");
        }
    }
    protected void sleep(){
        isSleeping = true;
        Controler.getInstance().notification(this.name+" is sleeping ("+this.getClass().getSimpleName()+")");
        fatigue = fatigue.sleep();
    }
    protected void age() {
        if (this.age == Age.values()[Age.values().length-1]) {
            this.isAlive = false;
            Controler.getInstance().removeCreature(this);
        }
        age = age.gettingOder();
    }
    protected void growUp() {
        this.height = height.growUp();
    }
    protected void toSwell() {
        //this.weight == Weight.values()[0]
        if (this.weight == Weight.values()[Weight.values().length-1])
            loseHealth();
        this.weight = weight.toSwell();
    }
    protected void toLoseWeight() {
        if (this.weight == Weight.values()[0])
            loseHealth();
        this.weight = weight.toLoseWeight();
    }
    public String getName()
    {
        return this.name;
    }
    @Override
    public String toString()
    {
        return this.name + " le " + this.getClass().getSimpleName() + "\n" +
                "Caractéristiques : " + "\n" +
                "    Sexe : " + this.sex + "\n" +
                "    Poids : " + this.weight + "\n" +
                "    Taille : " + this.height + "\n" +
                "    Age : " + this.age + "\n" +
                "    Faim : " + this.hunger + "\n" +
                "    Fatigue : " + this.fatigue + "\n" +
                "    Santé : " + this.health;
    }
    @Override
    public boolean equals(Object o)
    {
        // Creature is compared to itself
        if (o == this) {
            return true;
        }

        // Check if the object is a creature
        if (!(o instanceof Creature)) {
            return false;
        }

        // Cast to Creature type
        Creature c = (Creature) o;

        // TODO : Complete the comparison
        if(this.name.equals(c.getName()))
        {
            return true;
        }
        return false;
    }
}
