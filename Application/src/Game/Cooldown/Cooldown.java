package Game.Cooldown;

/**
 * Represents a cooldown that triggers an action after a specified duration.
 */
public class Cooldown implements Runnable {
    private int cooldown;
    private Cooldownable caller;
    private CooldownType type;

    /**
     * Initializes a Cooldown object.
     *
     * @param cooldown The duration of the cooldown.
     * @param caller   The Cooldownable entity associated with this cooldown.
     * @param type     The type of cooldown.
     */
    public Cooldown(int cooldown, Cooldownable caller, CooldownType type) {
        this.cooldown = cooldown;
        this.caller = caller;
        this.type = type;
        new Thread(this).start();
    }

    /**
     * Initiates the cooldown process.
     */
    @Override
    public void run() {
        try {
            Thread.sleep(this.cooldown);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
        this.caller.cooldown(this);
    }

    /**
     * Retrieves the type of cooldown.
     *
     * @return The type of cooldown.
     */
    public CooldownType getType() {
        return type;
    }
}