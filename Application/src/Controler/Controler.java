package Controler;

import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Zoo;
import Model.ZooMaster;
import View.Interface;

import java.util.Objects;

public class Controler {
    private Interface gui;
    public Controler()
    {
        this.gui = new Interface();
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
}
