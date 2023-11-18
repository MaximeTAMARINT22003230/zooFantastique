package Controler;

import View.Interface;

public class Notification extends Controler{
    public void notify(String string)
    {
        Interface.show(string);
    }
}
