import java.util.ArrayList;
import java.util.List;

public class Dog {
    private String name;
    private String bio;
    private int age;

    private float value;
    private final List<Attribute> attributes;

    public Dog(String name, String bio) {
        this.name = name;
        this.bio = bio;
        age = 0;
        attributes = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            attributes.add(new Attribute("", 50.0, new ArrayList<>()));
        }
    }

    public double evaluateDog(List<Double> demand) {
        double value = 0.0;
        for (int i = 0; i < attributes.size(); i++){
            Double attribute = attributes.get(i).status;
            Double target = demand.get(i);
            value += Math.abs(attribute - target);
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

    public int ageUp(){
        return ageUp(1);
    }

    public int ageUp(int days) {
        age += days;
        return age;
    }

    public double getValue(){

    }

    public List<Attribute> getAttributes() {
        return attributes;
    }

}
