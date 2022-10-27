import java.util.List;

public class Attribute {
    String name;
    Double status;
    List<StatusEffect> statusEffects;

    public Attribute(String name, Double status, List<StatusEffect> statusEffects) {
        this.name = name;
        this.status = status;
        this.statusEffects = statusEffects;
    }

    public String getName() {
        return name;
    }

    public Double getStatus() {
        return status;
    }

    public List<StatusEffect> getStatusEffects() {
        return statusEffects;
    }

    public double attributeEffects() {
        Double totalEffect = 0.0;
        for (StatusEffect statusEffect : statusEffects)
            totalEffect += statusEffect.effect(status);
        return totalEffect;
    }
}
