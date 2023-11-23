package Model.Creature;

import Controler.Controler;
import Model.Creature.Caracteristic.*;

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
    }
    protected void eat(){
        hunger = hunger.eat();
    }
    // notification pour dire je cris ?
    protected void shout(){
        System.out.println(this.name+" émet un son ("+this.getClass()+")");
    }
    protected void heal(){
        health = health.heal();
    }
    protected void sleep(){
        fatigue = fatigue.sleep();
    }
    protected void age() {
        age = age.gettingOder();
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
}
