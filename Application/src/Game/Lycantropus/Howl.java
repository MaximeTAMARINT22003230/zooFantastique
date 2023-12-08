package Game.Lycantropus;

public enum Howl
{
    AGGRESSIVE, BELONGING, SUBMISSION, DOMINATION, ANSWER;
    private Lycantropus howler;
    public Howl setHowler(Lycantropus howler)
    {
        this.howler = howler;
        return this;
    }
    public Lycantropus getHowler()
    {
        return this.howler;
    }
    private Lycantropus target;
    public Howl setTarget(Lycantropus target)
    {
        this.target = target;
        return this;
    }
    public Lycantropus getTarget()
    {
        return this.target;
    }
    @Override
    public String toString()
    {
        return "A IMPLEMENTER";
    }
}
