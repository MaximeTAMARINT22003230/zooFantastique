package Player;

import java.util.Scanner;

public class Interface {
    public static void show(String string)
    {
        System.out.print(string + "\n");
    }
    public static String input(String string)
    {
        Interface.show(string);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
