package Controler;

import View.Interface;

/**
 * The main class and entrance point of the application.
 * Instantiate all needed classes and launch the game.
 */
public class Main {
    public static void main(String[] args) {
        Controler controler = new Controler();
        controler.createYourZoo();
    }
}