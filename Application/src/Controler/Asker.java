package Controler;

import Model.Corral.Corral;
import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Creature.Creature;
import View.Interface;

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
            String inputSex = Interface.input("Sexe de votre maître de zoo : Male ou Female ?");
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
        // TODO : This method
        return null;
    }
    public static Corral corral()
    {
        // TODO : This method
        return null;
    }
}
