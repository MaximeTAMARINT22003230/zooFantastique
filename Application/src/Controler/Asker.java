package Controler;

import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import View.Interface;

import java.util.Objects;

/**
 * One of the app's controler. Used to ask specific input to the user.
 */
public class Asker
{
    public Sex askSex()
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
    public Age askAge()
    {
        return Age.ADULT;
        //TODO : Faire cette méthode
    }
}
