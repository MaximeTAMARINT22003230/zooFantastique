package Interactions;

import Game.Corral.Aquarium;
import Game.Corral.Aviary;
import Game.Corral.Corral;
import Game.Creature.Bestiary.*;
import Game.Creature.Creature;
import Game.Lycantropus.Lycantropus;
import Player.*;

import java.util.Objects;

/**
 * The Creator interact with the player to create anything. <br>
 * Has only a bunch of usefulle static methods.
 */
public class Creator{
    /** Create a Zoo Master <br>
     * Ask to input a name, a sex and an age
     * @return The new Zoo Master
     */
    private static ZooMaster createYourZooMaster()
    {
        return new ZooMaster(Interface.input("Nom de votre maître de zoo"),Asker.sex(),Asker.age());
    }
    public static Zoo createYourZoo()
    {
        return Zoo.opening(Interface.input("Nom de votre Zoo"), createYourZooMaster());
    }
    public static Creature createYourCreature(Corral corral)
    {
        String type = corral.getClass().getSimpleName();
        String builder = "Quelle créature voulez-vous faire naître ? Dragon, ";
        if(type.equals("Corral"))
        {
            builder += "Lycantropus, Nymph, Unicorn";
        }
        else if (type.equals("Aquarium"))
        {
            builder += "Kraken, Megalodon, Mermaid";
        }
        else
        {
            builder += "Phenix";
        }
        String choice = Interface.input(builder);
        if (Objects.equals(choice, "Dragon"))
        {
            return Dragon.newBorn(Interface.input("Nom de votre dragon"), Asker.sex());
        }
        else if (Objects.equals(choice, "Kraken") && type.equals("Aquarium"))
        {
            return Kraken.newBorn(Interface.input("Nom de votre kraken"), Asker.sex());
        }
        else if (Objects.equals(choice, "Lycantropus") && type.equals("Corral"))
        {
            return Lycantropus.newBorn(Interface.input("Nom de votre loup garou"), Asker.sex());
        }
        else if (Objects.equals(choice, "Megalodon") && type.equals("Aquarium"))
        {
            return Megalodon.newBorn(Interface.input("Nom de votre mégalodon"), Asker.sex());
        }
        else if (Objects.equals(choice, "Mermaid") && type.equals("Aquarium"))
        {
            return Mermaid.newBorn(Interface.input("Nom de votre sirène"), Asker.sex());
        }
        else if (Objects.equals(choice, "Nymph") && type.equals("Corral"))
        {
            return Nymph.newBorn(Interface.input("Nom de votre nymphe"), Asker.sex());
        }
        else if (Objects.equals(choice, "Phenix") && type.equals("Aviary"))
        {
            return Phenix.newBorn(Interface.input("Nom de votre phénix"), Asker.sex());
        }
        else if (Objects.equals(choice, "Unicorn") && type.equals("Corral"))
        {
            return Unicorn.newBorn(Interface.input("Nom de votre licorne"), Asker.sex());
        }
        else
        {
            return createYourCreature(corral);
        }
    }
    public static Corral createYourCorral()
    {
        return switch (Interface.input("Quel type d'enclos voulez vous faire ? Corral, Aviary, Aquarium")) {
            case "Corral" -> Corral.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            case "Aviary" -> Aviary.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            case "Aquarium" -> Aquarium.inaugurate(Interface.input("Nom de votre enclos"), "petit");
            default -> createYourCorral();
        };
    }
}
