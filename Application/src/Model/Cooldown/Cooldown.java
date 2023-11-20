package Model.Cooldown;

public class Cooldown implements Runnable{
    private int cooldown;
    private Cooldownable caller;
    private CooldownType type;
    public Cooldown(int cooldown, Cooldownable caller, CooldownType type)
    {
        this.cooldown = cooldown;
        this.caller = caller;
    }
    @Override
    public void run() {
        try {
            Thread.sleep(this.cooldown);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.caller.cooldown(this);
    }

    public CooldownType getType() {
        return type;
    }
}
