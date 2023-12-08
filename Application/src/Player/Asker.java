package Player;

import Game.Corral.Corral;
import Game.Creature.Caracteristic.Age;
import Game.Creature.Caracteristic.Sex;
import Game.Creature.Creature;

import java.util.Objects;

/** The Askes is used to ask specific input to the player
 * Contains only static methods
 */
public class Asker
{
    /** Ask the player to input a sex either MALE or FEMALE
     * @return The input Sex
     */
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

    /** Ask the player to input a correct Age
     *
     * @return The Age input
     */
    public static Age age()
    {
        // TODO : This method
        return null;
    }

    /** Ask the player to choose a creature with an input
     * @return The chosen creature
     */
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

    /** Ask the player to chose a creature with an input
     * @param corral A specific corral for the choice to be made
     * @return The chosen creature
     */
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

    /** Ask the player to chose a corral
     * depending on the existing ones
     * @return The chosen corral
     */
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
