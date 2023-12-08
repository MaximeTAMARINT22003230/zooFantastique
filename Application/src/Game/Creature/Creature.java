package Game.Creature;

import Game.Creature.Behavior.BirthBehavior;
import Game.Creature.Behavior.Fly;
import Game.Creature.Behavior.Run;
import Game.Creature.Behavior.Swim;
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
    }

    @Override
    public void run() {
        while (this.isAlive){

            if (fatigue.isSleeping()) {
                int t = Model.DiceRoll.d4();
                if (t == 1) {
                    Controler.getInstance().notification(this.name + " se reveil (" + this.getClass().getSimpleName() + ") : " +t);
                    sleep();
                } else {
                    Controler.getInstance().notification(this.name + " dort toujours (" + this.getClass().getSimpleName() + ") : "+t);
                }
            }
            else {
                int randomAction = Model.DiceRoll.d12();

                switch (randomAction) {
                    case 1:
                        shout();
                        break;
                    case 2:
                        age();
                        break;
                    case 3:
                        gettingFatigue();
                        break;
                    case 4:
                        toBeHungry();
                        break;
                    case 5:
                        toLoseWeight();
                        break;
                    case 6:
                        growUp();
                        break;
                    case 7:
                        if(this instanceof Fly)
                            toFly();
                        break;
                    case 8:
                        if(this instanceof Run)
                            toRun();
                        break;
                    case 9:
                        if (this instanceof Swim)
                            toSwim();
                        break;
                }
            }

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
    }
    /// Behavior
    protected void toFly() {
        Controler.getInstance().notification(this.name+" flies ("+this.getClass().getSimpleName()+")");
    }
    protected void toRun() {
        Controler.getInstance().notification(this.name+" runs ("+this.getClass().getSimpleName()+")");
    }
    protected void toSwim() {
        Controler.getInstance().notification(this.name+" swims ("+this.getClass().getSimpleName()+")");
    }

    /////
    protected void eat(){
        hunger = hunger.eat();
    }
    // notification pour dire je cris ?
    protected void toBeHungry() {
        if (this.hunger == Hunger.values()[0])
            loseHealth();
        else
            this.hunger = hunger.toBeHungry();
    }
    protected void shout(){
        Controler.getInstance().notification(this.name+" émet un son ("+this.getClass().getSimpleName()+")");
    }
    protected  void loseHealth() {
        if (this.health == Health.values()[0]) {
            this.isAlive = false;
            Controler.getInstance().kill(this);
        }
        else
            this.health = health.loseHealth();
    }
    protected void heal(){
        health = health.heal();
    }
    protected void gettingFatigue() {
        if (this.fatigue != Fatigue.values()[0]) {
            this.fatigue = fatigue.gettingFatigue();
            Controler.getInstance().notification(this.name + " getting fatigue (" + this.getClass().getSimpleName() + ")");
        }
        else
            Controler.getInstance().notification(this.name + " is sleeping (" + this.getClass().getSimpleName() + ")");
    }
    protected void sleep(){
        fatigue = fatigue.sleep();
    }
    protected void age() {
        if (this.age == Age.values()[Age.values().length-1]) {
            this.isAlive = false;
            loseHealth();
        }
        else
            age = age.gettingOder();
    }
    protected void growUp() {
        this.height = height.growUp();
    }
    protected void toSwell() {
        if (this.weight == Weight.values()[Weight.values().length-1])
            loseHealth();
        else
            this.weight = weight.toSwell();
    }
    protected void toLoseWeight() {
        if (this.weight == Weight.values()[0])
            loseHealth();
        else
            this.weight = weight.toLoseWeight();
    }
    public String getName()
    {
        return this.name;
    }

    public Sex getSex(){
        return this.sex;
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
