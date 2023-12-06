package Game.Lycantropus;

import Game.Lycantropus.Component.Lycantropus;

import java.util.HashMap;
import java.util.List;

public class Pack {
    private Couple alpha;
    private List<Lycan> lycans;
    public String toString()
    {
        return "A IMPLEMENTER";
    }
    private String packCaracteristics()
    {
        return "A IMPLEMENTER";
    }
    private String lycansCaracteristics()
    {
        return "A IMPLEMENTER";
    }
    private List<Lycan> rank()
    {
        return null; //TODO THIS METHOD
    }
    private Couple couple()
    {
        //TODO THIS METHOD
        return null;
    }
    private void reproduce()
    {

    }
    private void unrank()
    {

    }
    private Lycan omega()
    {
        return null;
        //TODO THIS METHOD
    }
    private void addLycan(Lycan lycan)
    {

    }
    private void removeLycan(Lycan lycan)
    {

    }
    public void spread(Howl howl)
    {
        if(howl == Howl.BELONGING)
        {
            for (Lycan lycan : this.lycans)
            {
                ((Lycantropus) lycan).hear(howl);
            }
        }
        else if (howl.getTarget() != null)
        {
            for (Lycan lycan : this.lycans) {
                if(howl.getTarget() == lycan)
                {
                    ((Lycantropus) lycan).hear(howl);
                }
            }
        }
    }
    public boolean contains(Lycan lycan)
    {
        return true; //TODO THIS METHOD
    }
}
