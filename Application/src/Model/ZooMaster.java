package Model;

import Controler.Zoo;
import Model.Cooldown.Cooldown;
import Model.Cooldown.CooldownType;
import Model.Cooldown.Cooldownable;
import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Creature.Creature;
import Model.Corral.Corral;

/**
 * The ZooMaster class.
 * Represents the player as a ZooMaster which can interact with their zoo.
 */
public class ZooMaster implements Runnable, Cooldownable {
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
        if(zoo.contains(creature) && corral.hasFreeSpace())
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
    public void run() {
        if(this.actions < this.maxActions)
        {
            // allows the user to do an action
        }
    }
    @Override
    public void cooldown(Cooldown cooldown) {
        switch (cooldown.getType())
        {
            case REFRESH :
                this.actions = 0;
                break;
            default:
                // unknown cooldown type
        }
    }
}
