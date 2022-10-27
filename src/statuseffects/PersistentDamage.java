package statuseffects;

public class PersistentDamage extends StatusEffect {


    public PersistentDamage(String name, String description, boolean bound) {
        super(name, description, bound);
    }

    @Override
    public double effect(Double status) {
        double severity = severity(status);
        setActive(severity > 0.5);
        return isActive() ? severity * 5 : 0.0;
    }
}
