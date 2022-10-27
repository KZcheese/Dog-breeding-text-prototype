package statuseffects;

public class Infection extends StatusEffect {


    public Infection(String name, String description, boolean bound) {
        super(name, description, bound);
    }

    @Override
    public double effect(Double status) {
        double random = Math.random();
        double severity = severity(status);

        if (isActive())
            setActive(!(random > severity));
        else
            setActive(random < severity / 2);

        return isActive() ? 10 : 0;
    }
}
