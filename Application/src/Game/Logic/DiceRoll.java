package Game.Logic;

public class DiceRoll {
    public static int d4(){
        return (int)(Math.random() * (4))+1;
    }
    public static int d6(){
        return (int)(Math.random() * (6))+1;
    }
    public static int d8(){
        return (int)(Math.random() * (8))+1;
    }
    public static int d12(){
        return (int)(Math.random() * (12))+1;
    }
    public static int d20(){
        return (int)(Math.random() * (20))+1;
    }
    public static int d100(){
        return (int)(Math.random() * (100))+1;
    }
}
