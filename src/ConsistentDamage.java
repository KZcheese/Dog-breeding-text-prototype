public class ConsistentDamage extends StatusEffect {

    public ConsistentDamage(String name, String description) {
        super(name, description);
    }

    @Override
    public double effect(Double status) {
        double severity = severity(status);
        setActive(severity > 50);
        return isActive() ? severity * 5 : 0.0;
    }
}
