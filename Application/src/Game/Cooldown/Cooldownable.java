package Game.Cooldown;

/**
 * The Cooldownable interface, implemented by entities that can undergo cooldown.
 * Specifies a method to handle cooldown behavior.
 */
public interface Cooldownable {
    /**
     * Initiates a cooldown for the implementing entity.
     *
     * @param cooldown The cooldown duration to be applied.
     */
    public void cooldown(Cooldown cooldown);
}