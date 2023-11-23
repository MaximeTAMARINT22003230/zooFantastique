package Model;


import Model.Cooldown.Cooldown;
import Model.Cooldown.CooldownType;
import Model.Cooldown.Cooldownable;
import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Creature.Creature;
import Model.Corral.Corral;
import View.Interface;
import Controler.*;

import javax.naming.ldap.Control;

/**
 * The ZooMaster class.
 * Represents the player as a ZooMaster which can interact with their zoo.
 */
public class ZooMaster implements Cooldownable {
    private final static int REFRESH_COOLDOWN = 5000;
    private final static int MAX = 5;
    private String name;
    private Sex sex;
    private Age age;
    private int actions;
    private int maxActions;
    private Corral scope;
    public ZooMaster(String name, Sex sex, Age age)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.actions = 0;
        this.maxActions = MAX;
        this.scope = null;
        this.refreshCooldown();
    }
    private void refreshCooldown()
    {
        new Thread (new Cooldown(REFRESH_COOLDOWN, this, CooldownType.REFRESH));
    }
    private void check()
    {
        if(this.scope == null)
        {
            Controler.instance.notification(Controler.instance.zoo.toString());
        }
        else
        {
            Controler.instance.notification(this.scope.toString());
        }
    }
    private void clean()
    {
        this.scope.clean();
    }
    private void feed()
    {
        this.scope.feed();
    }
    @Override
    public String toString()
    {
        return "C'est vous !" + "\n" +
                "        Nom : " + this.name +  "\n" +
                "        Sexe : " + this.sex + "\n" +
                "        Age : " + this.age;
    }
    @Override
    public void cooldown(Cooldown cooldown) {
        switch (cooldown.getType())
        {
            case REFRESH :
                this.actions = 0;
                this.refreshCooldown();
                Controler.instance.notification("Actions rafraichies");
                break;
            default:
                // unknown cooldown type
        }
    }
    public void options()
    {
        if(this.actions >= this.maxActions)
        {
            return;
        }
        if(this.scope == null)
        {
            String options = "Que voulez vous faire ? \n Move, Add, Remove, Zoom Out, Feed, Clean";
            switch (Interface.input(options))
            {
                case "Zoom Out" :
                    this.scope = null;
                    break;
                case "Add" :
                    this.add();
                    break;
                case "Remove" :
                    this.remove();
                    break;
                case "Move" :
                    this.move();
                    break;
                case "Feed" :
                    this.feed();
                    break;
                case "Clean" :
                    this.clean();
                    break;
                default :
                    this.options();
                    return;
            }
        }
        else
        {
            String options = "Que voulez vous faire ? \n Zoom, Check";
            switch (Interface.input(options))
            {
                case "Zoom" :
                    this.zoom();
                    break;
                case "Check" :
                    this.check();
                    break;
                default :
                    this.options();
                    return;
            }
        }
        this.actions += 1;
        this.options();
    }
    private void move()
    {
        Creature creature = Asker.creature();
        Corral corral = Asker.corral();
        if(corral.hasFreeSpace())
        {
            Controler.instance.removeCreature(creature);
            Controler.instance.addCreature(creature, corral);
        }
        else
        {
            Controler.instance.notification("Cet enclos est plein");
        }
    }
    private void zoom()
    {
        this.scope = Asker.corral();
    }
    private void add()
    {
        if (this.scope == null)
        {
            Controler.instance.addCorral(Creator.createYourCorral());
        }
        else
        {
            Controler.instance.addCreature(Creator.createYourCreature(), this.scope);
        }
    }
    private void remove()
    {
        if(this.scope == null)
        {
            Corral corral = Asker.corral();
            if(corral.empty())
            {
                Controler.instance.removeCorral(corral);
            }
            else
            {
                Controler.instance.notification("Cet enclos n'est pas vide");
            }
        }
        else
        {
            Creature creature = Asker.creature();
            Controler.instance.removeCreature(creature);
        }
    }
}