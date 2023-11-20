package Controler;

import Model.Corral.*;
import Model.Creature.Creature;
import View.Interface;

/**
 * The main controler of the app.
 * Listening to anything happening in the zoo.
 */
public class Controler{
    private Zoo zoo;
    private Corral scope;
    public static Controler instance = new Controler();
    public Controler()
    {
        super();
        this.zoo = Creator.createYourZoo();
        this.scope = null;
    }
    private Corral options()
    {
        if(this.scope == null)
        {
            // Vue générale
        }
        else
        {
            // Vue sur un enclos spécifique
        }
        String options = "Que voulez vous faire ? \n Move, Add, Remove, Zoom";
        switch (Interface.input(options))
        {
            case "Zoom" :
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
        return null;
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
        switch (Interface.input("Où voulez-vous aller ? " + this.zoo.corrals()))
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
            this.zoo.addCorral(Creator.createYourCorral());
            Interface.show("Vous avez inauguré un nouvel enclos");
        }
        else
        {
            this.scope.addCreature(Creator.createYourCreature());
            Interface.show("Vous avez ajouté une nouvelle créature");
        }

        this.options();
    }
    private void remove()
    {
        // SELECTIONNER LA CREATURE OU L'ENCLOS
        Interface.show("Vous supprimé une créature");
        this.options();
    }
    public void notification(Notification notification, Creature notificator)
    {
        switch (notification)
        {
            case KILL :
                // kill the animal
                break;
            case DESTROY :
                // destroy a corral
            default:
                // Unknown notification
        }
    }
}
