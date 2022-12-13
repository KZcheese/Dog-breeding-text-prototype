import statuseffects.Infection;
import statuseffects.PersistentDamage;
import statuseffects.RandomDamage;
import statuseffects.StatusEffect;

import java.util.ArrayList;
import java.util.List;

public class Attribute {
    String name;
    Double status;
    List<StatusEffect> statusEffects;

    public static List<Attribute> attributePresets = generateAttributes();


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

    public void setStatus(double status){
        this.status = status;
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

    public String toString(){
        StringBuilder output = new StringBuilder(name + ": " + status);
        for (StatusEffect statusEffect : statusEffects){
            if (statusEffect.isActive()){
                output.append(" (" + statusEffect.getName() + ")");
            }
        }
        return output.toString();
    }

    private static List<Attribute> generateAttributes() {
        List<Attribute> attributes = new ArrayList<>(5);

        List<StatusEffect> eyeEffects = new ArrayList<>();
        eyeEffects.add(new RandomDamage("Blindness", "Has trouble Seeing.", true));
        eyeEffects.add(new Infection("Cherry Eye", "Risk of Eye Infection", true));
        eyeEffects.add(new RandomDamage("Ulceration of Cornea", "Has trouble Seeing.", false));
        eyeEffects.add(new Infection("Dry Eyes", "Risk of Conjunctivitis Infection", false));
        Attribute eyeSize = new Attribute("Eye Size", 50.0, eyeEffects);
        attributes.add(eyeSize);

        List<StatusEffect> noseEffects = new ArrayList<>();
        noseEffects.add(new Infection("Skin Infection", "Many skin folds cause risk of Infection.", true));
        noseEffects.add(new PersistentDamage("Dental Crowding", "Crowder and Misalignment cause tooth pain", true));
        noseEffects.add(new RandomDamage("Nasal Mites", "", false));
        noseEffects.add(new Infection("Fungal Infections", "Risk of Nose Infection", false));
        Attribute noseShape = new Attribute("Nose Shape", 50.0, noseEffects);
        attributes.add(noseShape);

        List<StatusEffect> muscleEffects = new ArrayList<>();
        muscleEffects.add(new RandomDamage("Difficulty Eating", "Pain the gums and teeth cause gums to bleed.", true));
        muscleEffects.add(new PersistentDamage("Thyroid Disease", "", true));
        muscleEffects.add(new PersistentDamage("Limited Mobility", "Hip Dysplasia.", false));
        Attribute muscleMass = new Attribute("Muscle Mass", 50.0, muscleEffects);
        attributes.add(muscleMass);

        List<StatusEffect> legEffects = new ArrayList<>();
        legEffects.add(new Infection("Foot Infection", "Many skin folds cause risk of Infection", true));
        legEffects.add(new PersistentDamage("Back Pain", "Crippling back pain. Sometimes leads to paralysis.", true));
        legEffects.add(new PersistentDamage("Arthritis", "", false));
        legEffects.add(new RandomDamage("Brittle Legs", "Long skinny legs break easily.", false));
        Attribute legLength = new Attribute("Leg Length", 50.0, legEffects);
        attributes.add(legLength);

        List<StatusEffect> earEffects = new ArrayList<>();
        earEffects.add(new RandomDamage("Difficulty Hearing", "Super tight ears have trouble hearing.", true));
        earEffects.add(new Infection("Risk of Ear Infection", "", true));
        earEffects.add(new RandomDamage("Trouble Seeing", "Long floppy ears obscure vision", false));
        earEffects.add(new RandomDamage("Tripping Hazard", "Long floppy ears can get caught on things", false));
        Attribute earShape = new Attribute("Ear Shape", 50.0, earEffects);
        attributes.add(earShape);

        return attributes;
    }
}
