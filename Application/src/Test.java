import Model.Creature.Caracteristic.Age;
import Model.Creature.Caracteristic.Sex;
import Model.Zoo;
import Model.ZooMaster;

/**
 * The test class of the application.
 * Entrance point when the developers need to do some tests.
 */
public class Test {
    public static void main(String[] args) {
        ZooMaster myZooMaster = new ZooMaster("Lucie", Sex.FEMALE, Age.TEEN);
        Zoo myZoo = Zoo.opening("HelloWorld", myZooMaster);
        System.out.println(myZoo);
    }
}
