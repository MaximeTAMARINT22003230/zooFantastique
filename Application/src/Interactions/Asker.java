package Interactions;

import Game.Corral.Corral;
import Game.Creature.Caracteristic.Age;
import Game.Creature.Caracteristic.Sex;
import Game.Creature.Creature;

import java.util.Objects;

/**
 * One of the app's controler. Used to ask specific input to the user.
 */
public class Asker
{
    public static Sex sex()
    {
        Sex sex = null;
        while (sex == null)
        {
            String inputSex = Interface.input("Sexe : Male ou Female ?");
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
                Interface.show("Mauvais input");
            }
        }
        return sex;
    }
    public static Age age()
    {
        // TODO : This method
        return null;
    }
    public static Creature creature()
    {
        String input = Interface.input("Sélectionner nom de la créature :\n" + Controler.getInstance().zoo.showCreatures());
        for (Creature creature: Controler.getInstance().zoo.getCreatures())
        {
            if(Objects.equals(input, creature.getName()))
            {
                return creature;
            }
        }
        return null;
    }
    public static Creature creature(Corral corral)
    {
        String input = Interface.input("Sélectionner nom de la créature :\n" + corral);
        for (Creature creature: corral.getCreatures())
        {
            if(input.equals(creature.getName()))
            {
                return creature;
            }
        }
        return null;
    }
    public static Corral corral()
    {
        String input = Interface.input("Sélectionner nom de l'enclos :\n" + Controler.getInstance().zoo.corrals());
        for (Corral corral: Controler.getInstance().zoo.getCorrals())
        {
            if(Objects.equals(input, corral.getName()))
            {
                return corral;
            }
        }
        return null;
    }
}