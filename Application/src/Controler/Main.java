package Controler;

import Model.Creature.Caracteristic.*;
import Model.Creature.Oviparian.Dragon;
import Model.ZooMaster;

public class Main {
    public static void main(String[] args) {
        ZooMaster myZooMaster = new ZooMaster();
        Zoo myZoo = Zoo.opening("HelloWorld", myZooMaster);
        System.out.println(myZoo);
    }
}