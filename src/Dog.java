import java.util.ArrayList;
import java.util.List;

public class Dog {
    private final String name;
    private final String bio;
    private int age;

    private final List<Attribute> attributes;

    public Dog(String name, String bio, List<Attribute> attributes, boolean adult) {
        this.name = name;
        this.bio = bio;
        age = adult ? 5 : 0;
        this.attributes = attributes;
    }

    public void adjustValue(int index, double value) {
        attributes.get(index).setStatus(value);
    }

    public double getValue(List<Double> demand) {
        double value = 0.0;
        for (int i = 0; i < attributes.size(); i++) {
            Double attribute = attributes.get(i).status;
            Double target = demand.get(i);
            value += Math.abs(attribute - target);
            value = (value * value) / 250;
        }
        return value;
    }

    public String getName() {
        return name;
    }

    public String getBio() {
        return bio;
    }

    public int getAge() {
        return age;
    }

    public int ageUp() {
        return ageUp(1);
    }

    public int ageUp(int days) {
        age += days;
        return age;
    }

    public boolean isAdult() {
        return age > 5;
    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

    public static Dog breed(Dog a, Dog b){
        List<Attribute> aAttributes = a.getAttributes();
        List<Attribute> bAttributes = b.getAttributes();

        List<Attribute> newAttributes = new ArrayList<>();

        for (int i = 0; i < a.getAttributes().size(); i++){
            Attribute aAt = aAttributes.get(i);
            Attribute bAt = bAttributes.get(i);

            double offset = Math.min(aAt.getStatus(), bAt.getStatus()) - Game.BREEDING_PADDING;
            double multiplier = Math.max(aAt.getStatus(), bAt.getStatus()) - offset + Game.BREEDING_PADDING;

            double newStat = Math.random() * multiplier + offset;
            if (newStat < 0) newStat = 0;
            else if (newStat > 100) newStat = 100;

            newAttributes.add(new Attribute(aAt.getName(), newStat, aAt.getStatusEffects()));
        }

        return new Dog("Starter", "Starter Dog", newAttributes, false);
    }

}
