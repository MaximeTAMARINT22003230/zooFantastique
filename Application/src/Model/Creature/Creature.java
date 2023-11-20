package Model.Creature;

import Controler.Controler;
import Model.Creature.Caracteristic.*;
import Controler.Notification;

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
    private Controler controler;
    protected Creature(Controler controler, String name, Sex sex, Weight weight, Height height, Age age, Hunger hunger, Fatigue fatigue, Health health)
    {
        this.controler = controler;
        this.name = name;
        this.sex = sex;
        this.weight = weight;
        this.height = height;
        this.age = age;
        this.hunger = hunger;
        this.fatigue = fatigue;
        this.health = health;
    }
    protected abstract void eat();
    protected abstract void shout();
    protected abstract void heal();
    protected abstract void sleep();
    protected abstract void age();
    protected void notification(Notification notification)
    {
        this.controler.notification(notification, this);
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
