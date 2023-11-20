package Model.Corral;

import Model.Creature.Behavior.*;
import Model.Creature.Creature;
import Model.Corral.Caracteristic.*;
import Model.Creature.Creature.*

import java.util.ArrayList;
import java.util.List;

public class Corral {
    private static final int MAX = 5;
    protected String name;
    protected String size;
    protected int max;
    protected int number;
    private List<Run> creatures;
    protected Hygiene hygiene;
    protected String food;

    protected Corral(String name, String size)
    {
        this.name = name;
        this.size = size;
        this.number = number;
        this.max = MAX;
        this.creatures = new ArrayList<Run>();
    }

    public static Corral inaugurate(String name, String size)
    {
        return new Corral(name, size);
    }
    public String toString() {
        StringBuilder returnString = new StringBuilder("Enclos " + this.name + "\n");
        for (Run creature : this.creatures) {
            returnString.append(creature);
        }
        return returnString.toString();


        System.out.println("Corral : " + name);
        System.out.println("Superficie : " + size);
        System.out.println("Nombre maximum de créatures : " + max);
        System.out.println("Nombre de créatures présentes : " + number);
        System.out.println("Propreté : " + hygiene);
        System.out.println("Créatures présentes :");
        for (Run creature : creatures) {
            System.out.println("- " + creature.getClass().getSimpleName());

        }
    }
    public void addCreature(Creature creature)
    {
        if (creatures instanceof Run)
        {
            this.creatures.add((Run) creature);
        }
        if (number < max) {
            number.addCreature(creature);
            number++;
            System.out.println(creatures + " a été ajouté au Corral.");
        } else {
            System.out.println("Le Corral est plein, impossible d'ajouter " + creatures + ".");
        }
    }

    public Creature removeCreature(Creature creature)
    {
        return (Creature) this.creatures.remove(this.creatures.indexOf((Run) creature));
        if (creatures.remove(creatures)) {
            number--;
            System.out.println(creatures.getEspece() + " a été enlevé de l'enclos.");
        } else {
            System.out.println(creatures.getNomEspece() + " n'est pas dans cet enclos.");
        }
    }
    public void clean()
    {
        hygiene= Hygiene.GOOD;
        System.out.println("Le Corral a été nettoyé et est maintenant propre.");
    }
    public int count()
    {
        return 0;
    }
    public void feed()
    {
        for (Run creature : creatures) {
            creature.feed();
        }
        System.out.println("Les créatures du corral ont été nourries.");
    }
    public boolean hasFreeSpace()
    {
        return true;
    }
    public boolean contains(Creature searched)
    {
        for(Run creature : this.creatures)
        {
            if (creature.equals(searched))
            {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return name;
    }
}