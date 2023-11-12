package Controler;

import Model.Creature.Bestiary.Dragon;
import Model.Creature.Caracteristic.*;
import Model.Zoo;

public class Main {
    public static void main(String[] args) {
        ZooMaster myZooMaster = new ZooMaster("Lucie", Sex.FEMALE, Age.TEEN);
        Zoo myZoo = Zoo.opening("HelloWorld", myZooMaster);
        System.out.println(myZoo);
    }
}