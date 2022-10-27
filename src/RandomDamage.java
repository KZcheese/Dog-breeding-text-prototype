public class RandomDamage extends StatusEffect {
    public RandomDamage(String name, String description) {
        super(name, description);
    }

    @Override
    public double effect(Double status) {
        double random = Math.random();
        double severity = severity(status);

        setActive(severity > 0.5);
        return severity > random ? random * 15 : 0.0;
    }
}
