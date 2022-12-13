package statuseffects;

import org.w3c.dom.Attr;

public abstract class StatusEffect {


    private String name;
    private String description;

    private boolean lowerBound;

    private boolean active;

    public StatusEffect(String name, String description, boolean lowerBound) {
        this.name = name;
        this.description = description;
        this.lowerBound = lowerBound;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    protected double severity(Double status) {
//        How close status is to 0 or 100, scaled exponentially
//        ex. 50 is 0%, 0 or 100 is 100%, 25 or 75 is 25%
        if (lowerBound && status > 50 || !lowerBound && status < 50) return 0.0;
        double severity = status;
        severity = (severity - 50);
        return severity * severity / 2500;
    }

    public abstract double effect(Double status);

    public boolean isActive() {
        return active;
    }

    protected void setActive(boolean active) {
        this.active = active;
    }

}

