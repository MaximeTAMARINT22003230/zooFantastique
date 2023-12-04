package Player;

import Game.Cooldown.Cooldown;
import Game.Cooldown.CooldownType;
import Game.Cooldown.Cooldownable;
import Interactions.Asker;
import Interactions.Controler;
import Interactions.Creator;
import Game.Creature.Caracteristic.Age;
import Game.Creature.Caracteristic.Sex;
import Game.Creature.Creature;
import Game.Corral.Corral;
import Interactions.Interface;

public class ZooMaster implements Cooldownable {
    private final static int REFRESH_COOLDOWN = 9999;
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
        new Cooldown(REFRESH_COOLDOWN, this, CooldownType.REFRESH);
    }
    private void check()
    {
        if(this.scope == null)
        {
            // Show the zoo and the corrals
            Controler.getInstance().notification(Controler.getInstance().zoo.toString());
        }
        else
        {
            // Show the corral and the creatures
            Controler.getInstance().notification(this.scope.toString());
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
                break;
            default:
                // unknown cooldown type
        }
    }
    public void options()
    {
        if(this.actions >= this.maxActions)
        {
            Interface.show("Vous êtes fatigué, attendez un peu...");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            return;
        }
        Interface.show("\n ------------------------------------------- \n " +
                "Actions restantes : " + (this.maxActions - this.actions));
        if(this.scope != null)
        {
            String options = "Que voulez vous faire ? \n Move, Add, Remove, Zoomout, Feed, Clean, Check";
            switch (Interface.input(options))
            {
                case "Zoomout" :
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
                case "Check" :
                    this.check();
                    break;
                default :
                    return;
            }
        }
        else
        {
            String options = "Que voulez vous faire ? \n Zoom, Check, Add, Remove";
            switch (Interface.input(options))
            {
                case "Zoom" :
                    this.zoom();
                    break;
                case "Check" :
                    this.check();
                    break;
                case "Add" :
                    this.add();
                    break;
                case "Remove" :
                    this.remove();
                    break;
                default :
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
            Controler.getInstance().removeCreature(creature);
            Controler.getInstance().addCreature(creature, corral);
        }
        else
        {
            Controler.getInstance().notification("Cet enclos est plein");
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
            Controler.getInstance().addCorral(Creator.createYourCorral());
        }
        else
        {
            if(!this.scope.hasFreeSpace())
            {
                return;
            }
            Controler.getInstance().addCreature(Creator.createYourCreature(this.scope), this.scope);
        }
    }
    private void remove()
    {
        if(this.scope == null)
        {
            Corral corral = Asker.corral();
            if(corral.empty())
            {
                Controler.getInstance().removeCorral(corral);
            }
            else
            {
                Controler.getInstance().notification("Cet enclos n'est pas vide");
            }
        }
        else
        {
            Creature creature = Asker.creature(this.scope);
            Controler.getInstance().removeCreature(creature);
        }
    }
}