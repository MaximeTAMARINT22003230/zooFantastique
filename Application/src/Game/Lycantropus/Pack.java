package Game.Lycantropus;

import java.util.List;

public class Pack {
    private Couple alpha;
    private List<Lycantropus> lycans;
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
    private List<Lycantropus> rank()
    {
        return null; //TODO THIS METHOD
    }
    private Couple couple()
    {
        //trouver la meilleure femelle et meilleur male
        //créer un couple avec eux
        // c'est le couple alpha
        return null;
    }
    private void reproduce()
    {

    }
    private void unrank()
    {

    }
    private Lycantropus omega()
    {
        return null;
        //TODO THIS METHOD
    }
    private void addLycan(Lycantropus lycan)
    {

    }
    private void removeLycan(Lycantropus lycan)
    {

    }
    public void spread(Howl howl)
    {
        if(howl == Howl.BELONGING)
        {
            for (Lycantropus lycan : this.lycans)
            {
                ((Lycantropus) lycan).hear(howl);
            }
        }
        else if (howl.getTarget() != null)
        {
            for (Lycantropus lycan : this.lycans) {
                if(howl.getTarget() == lycan)
                {
                    ((Lycantropus) lycan).hear(howl);
                }
            }
        }
    }
    public boolean contains(Lycantropus lycan)
    {
        return true; //TODO THIS METHOD
    }
    public int dominationOf(Lycantropus lycan)
    {
        //TODO THIS METHOD
        // return the domination of the Lycan depending on who he dominates and who he does not
        // +1 for each domination
        // -1 for each dominated
        return 0;
    }
}
