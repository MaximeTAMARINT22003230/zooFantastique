package Player;

import java.util.Scanner;

/**
 * Provides basic interaction methods for input and output.
 */
public class Interface {
    /**
     * Displays the provided string.
     * @param string The string to display.
     */
    public static void show(String string)
    {
        System.out.print(string + "\n");
    }
    /**
     * Takes user input after displaying the provided string.
     * @param string The string prompt for user input.
     * @return The user input as a string.
     */
    public static String input(String string)
    {
        Interface.show(string);
        Scanner scanner = new Scanner(System.in);
        return scanner.next();
    }
}
