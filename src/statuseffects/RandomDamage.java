package statuseffects;

public class RandomDamage extends StatusEffect {

    public RandomDamage(String name, String description, boolean bound) {
        super(name, description, bound);
    }

    @Override
    public double effect(Double status) {
        double random = Math.random();
        double severity = severity(status);

        setActive(severity > 0.25);
        return severity > random && isActive() ? random * 15 : 0.0;
    }
}
