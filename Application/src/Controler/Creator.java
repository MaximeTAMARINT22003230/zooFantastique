package Controler;

import Model.Corral.Aquarium;
import Model.Corral.Aviary;
import Model.Corral.Corral;
import Model.Creature.Bestiary.*;
import Model.Creature.Creature;
import Model.ZooMaster;
import View.Interface;

public class Creator{
    private Asker asker;
    public Creator ()
    {
        this.asker = new Asker();
    }
    private ZooMaster createYourZooMaster()
    {
        return new ZooMaster(Interface.input("Nom de votre maître de zoo"),this.asker.askSex(),this.asker.askAge());
    }
    public Zoo createYourZoo()
    {
        return Zoo.opening(Interface.input("Nom de votre Zoo"), this.createYourZooMaster());
    }
    public Creature createYourCreature()
    {
        return switch (Interface.input("Quel créature voulez vous faire naître ? Dragon, Kraken, Lycantropus, " +
                "Megalodon, Mermaid, Nymph, Phenix, Unicorn")) {
            case "Dragon" -> Dragon.newBorn(Interface.input("Nom de votre dragon"), this.asker.askSex());
            case "Kraken" -> Kraken.newBorn(Interface.input("Nom de votre kraken"), this.asker.askSex());
            case "Lycantropus" -> Lycantropus.newBorn(Interface.input("Nom de votre loup garou"), this.asker.askSex());
            case "Megalodon" -> Megalodon.newBorn(Interface.input("Nom de votre mégalodon"), this.asker.askSex());
            case "Mermaid" -> Mermaid.newBorn(Interface.input("Nom de votre sirène"), this.asker.askSex());
            case "Nymph" -> Nymph.newBorn(Interface.input("Nom de votre nymphe"), this.asker.askSex());
            case "Phenix" -> Phenix.newBorn(Interface.input("Nom de votre phénix"), this.asker.askSex());
            case "Unicorn" -> Unicorn.newBorn(Interface.input("Nom de votre licorne"), this.asker.askSex());
            default -> this.createYourCreature();
        };
    }
    public Corral createYourCorral()
    {
        return switch (Interface.input("Quel type d'enclos voulez vous faire ? Corral, Aviary, Aquarium")) {
            case "Corral" -> Corral.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            case "Aviary" -> Aviary.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            case "Aquarium" -> Aquarium.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            default -> this.createYourCorral();
        };
    }
}