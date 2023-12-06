package Game.Lycantropus;

public enum Howl
{
    AGGRESSIVE, BELONGING, SUBMISSION, DOMINATION, ANSWER;
    private Lycan howler;
    public Howl setHowler(Lycan howler)
    {
        this.howler = howler;
        return this;
    }
    public Lycan getHowler()
    {
        return this.howler;
    }
    private Lycan target;
    public Howl setTarget(Lycan target)
    {
        this.target = target;
        return this;
    }
    public Lycan getTarget()
    {
        return this.target;
    }
    @Override
    public String toString()
    {
        return "A IMPLEMENTER";
    }
}
