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
import Controler.Notification;

/**
 * The ZooMaster class.
 * Represents the player as a ZooMaster which can interact with their zoo.
 */
public class ZooMaster implements Cooldownable {
    private final static int REFRESH_COOLDOWN = 5000;
    private final static int MAX = 5;
    /**
     * The name of the zoo master.
     */
    private String name;
    /**
     * The sex of the zoo master.
     */
    private Sex sex;
    /**
     * The age of the zoo master.
     */
    private Age age;
    private int actions;
    private int maxActions;
    private Corral scope;
    /**
     * The class constructor
     *
     * @param  name  Your name
     * @param  sex   Your sex
     * @param  age   Your age
     */
    public ZooMaster(String name, Sex sex, Age age)
    {
        this.name = name;
        this.sex = sex;
        this.age = age;
        this.actions = 0;
        this.maxActions = MAX;
        this.refreshCooldown();
    }
    private void refreshCooldown()
    {
        new Thread (new Cooldown(REFRESH_COOLDOWN, this, CooldownType.REFRESH));
    }
    /**
     * Allows you to get information about a given corral
     *
     * @param  corral  The corral you want to check
     * @return         The corral's information
     */
    private String check(Corral corral)
    {
        return corral.toString();
    }
    /**
     * Clean a corral.
     *
     * @param  corral  The corral you want to clean
     */
    private void clean(Corral corral)
    {
        corral.clean();
    }
    /**
     * Refill the food supplies of a corral.
     *
     * @param  corral  The corral you want to refill
     */
    private void feed(Corral corral)
    {
        corral.feed();
    }
    /**
     * Move a creature to a new corral
     *
     * @param  creature     The creature to move
     * @param  corral       The creature's new home
     * @param  zoo          Your current zoo
     */
    private void move(Creature creature, Corral corral, Zoo zoo)
    {
        if(zoo.exists(creature) && corral.hasFreeSpace())
        {
            corral.addCreature(zoo.corralOf(creature).removeCreature(creature));
        }
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
                break;
            default:
                // unknown cooldown type
        }
    }
    private void options()
    {
        if(this.scope == null)
        {
            String options = "Que voulez vous faire ? \n Move, Add, Remove, Zoom Out";
            switch (Interface.input(options))
            {
                case "Zoom Out" :
                    this.zoom();
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
                default :
                    this.options();
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
                    this.remove();
                    break;
                default :
                    this.options();
            }
        }
    }
    private void move()
    {
        // UN : Sélectionner une créature
        // DEUX : Sélectionner son nouvel enclos
        Interface.show("Vous déplacez une créature");
        this.options();
    }
    private void zoom()
    {
        switch (Interface.input("Où voulez-vous aller ? " + Controler.instance.zoo.corrals()))
        {
            case "quelque part" :
                // Set this.scope à l'enclos en question
                Interface.show("Vous vous approchez d'un enclos");
                break;
            default :
                Interface.show("Vous retournez à l'entrée du zoo");
                this.scope = null;
        }
        this.options();
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
        this.options();
    }
    private void remove()
    {
        // SELECTIONNER LA CREATURE OU L'ENCLOS
        Interface.show("Vous supprimé une créature");
        this.options();
    }
}
