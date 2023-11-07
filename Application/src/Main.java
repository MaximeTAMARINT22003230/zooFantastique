import Creature.*;
import Creature.Caracteristic.*;

public class Main {
    public static void main(String[] args) {
        Dragon dragon = new Dragon(
                "Jules",
                Sex.MALE,
                Weight.AVERAGE,
                Height.SMALL,
                Age.TEEN,
                Hunger.GOOD,
                Fatigue.GOOD,
                Health.VIGOROUS
        );
        System.out.println(dragon);
    }
}