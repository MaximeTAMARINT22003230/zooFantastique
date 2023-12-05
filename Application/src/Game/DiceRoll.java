package Model;

public class DiceRoll {
    public static int d4(){
        return (int)(Math.random() * (5));
    }
    public static int d6(){
        return (int)(Math.random() * (7));
    }
    public static int d8(){
        return (int)(Math.random() * (9));
    }
    public static int d12(){
        return (int)(Math.random() * (13));
    }
    public static int d20(){
        return (int)(Math.random() * (21));
    }
    public static int d100(){
        return (int)(Math.random() * (101));
    }
}
