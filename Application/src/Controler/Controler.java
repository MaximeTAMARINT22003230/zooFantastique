package Controler;

import Model.Corral.Aquarium;
import Model.Corral.Aviary;
import Model.Creature.Bestiary.*;
import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Creature.Creature;
import Model.Corral.Corral;
import Model.Zoo;
import Model.ZooMaster;
import View.Interface;

import java.util.Objects;

public class Controler {
    private Interface gui;
    private Zoo zoo;
    private Corral scope;
    public Controler()
    {
        this.gui = new Interface();
        this.zoo = this.createYourZoo();
        this.scope = null;
        this.options();
    }
    public void notification(String notification)
    {
        this.gui.show(notification);
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
        switch (this.gui.input(options))
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
        this.gui.show("Vous déplacez une créature");
        this.options();
    }
    private void zoom()
    {
        this.gui.show("Vous vous approchez d'un enclos");
        this.options();
    }
    private void add()
    {
        if (this.scope == null)
        {
            this.zoo.addCorral(this.createYourCorral());
            this.gui.show("Vous avez inauguré un nouvel enclos");
        }
        else
        {
            this.scope.addCreature(this.createYourCreature());
            this.gui.show("Vous avez ajouté une nouvelle créature");
        }

        this.options();
    }
    private void remove()
    {
        this.gui.show("Vous supprimé une créature");
        this.options();
    }
    private Sex askSex()
    {
        Sex sex = null;
        while (sex == null)
        {
            String inputSex = this.gui.input("Sexe de votre maître de zoo : Male ou Female ?");
            if(Objects.equals(inputSex, "Male"))
            {
                sex = Sex.MALE;
            }
            else if (Objects.equals(inputSex, "Female"))
            {
                sex = Sex.FEMALE;
            }
            else
            {
                this.gui.show("Mauvais input");
            }
        }
        return sex;
    }
    private Age askAge()
    {
        return Age.ADULT;
        //TODO : Faire cette méthode
    }
    private ZooMaster createYourZooMaster()
    {
        return new ZooMaster(gui.input("Nom de votre maître de zoo"),this.askSex(),this.askAge());
    }
    public Zoo createYourZoo()
    {
        return Zoo.opening(gui.input("Nom de votre Zoo"), this.createYourZooMaster());
    }
    public Creature createYourCreature()
    {
        return switch (this.gui.input("Quel créature voulez vous faire naître ? Dragon, Kraken, Lycantropus, " +
                "Megalodon, Mermaid, Nymph, Phenix, Unicorn")) {
            case "Dragon" -> Dragon.newBorn(gui.input("Nom de votre dragon"), this.askSex());
            case "Kraken" -> Kraken.newBorn(gui.input("Nom de votre kraken"), this.askSex());
            case "Lycantropus" -> Lycantropus.newBorn(gui.input("Nom de votre loup garou"), this.askSex());
            case "Megalodon" -> Megalodon.newBorn(gui.input("Nom de votre mégalodon"), this.askSex());
            case "Mermaid" -> Mermaid.newBorn(gui.input("Nom de votre sirène"), this.askSex());
            case "Nymph" -> Nymph.newBorn(gui.input("Nom de votre nymphe"), this.askSex());
            case "Phenix" -> Phenix.newBorn(gui.input("Nom de votre phénix"), this.askSex());
            case "Unicorn" -> Unicorn.newBorn(gui.input("Nom de votre licorne"), this.askSex());
            default -> this.createYourCreature();
        };
    }
    public Corral createYourCorral()
    {
        return switch (this.gui.input("Quel type d'enclos voulez vous faire ? Corral, Aviary, Aquarium")) {
            case "Corral" -> Corral.inaugurate(gui.input("Nom de votre enclos"), "petit");
            case "Aviary" -> Aviary.inaugurate(gui.input("Nom de votre enclos"), "petit");
            case "Aquarium" -> Aquarium.inaugurate(gui.input("Nom de votre enclos"), "petit");
            default -> this.createYourCorral();
        };
    }
}
