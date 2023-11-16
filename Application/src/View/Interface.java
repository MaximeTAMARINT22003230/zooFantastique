package View;

import java.util.Scanner;

public class Interface {
    public void show(String string)
    {
        System.out.println(string);
    }
    public String input(String string)
    {
        this.show(string);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
