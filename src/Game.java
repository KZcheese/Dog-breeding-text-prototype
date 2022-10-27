import org.w3c.dom.Attr;
import org.xml.sax.helpers.AttributesImpl;
import statuseffects.PersistentDamage;
import statuseffects.Infection;
import statuseffects.RandomDamage;
import statuseffects.StatusEffect;

import java.util.ArrayList;
import java.util.List;

public class Game {

    private Date date;
    private Bank bank;
    private List<Dog> pen;

    public static final double BREEDING_PADDING = 10;

    public Game() {
        date = new Date();
        bank = new Bank(500);
        pen = new ArrayList<>();
        generateStarters();
    }

    private void generateStarters() {
        for (int i = 0; i < 3; i++) {
            List<Attribute> starterAttributes = new ArrayList<>(5);
            for (Attribute attribute : Attribute.attributePresets)
                starterAttributes.add(new Attribute(attribute.name, Math.random() * 40 + 30, attribute.statusEffects));
            pen.add(new Dog("Starter", "Starter Dog", starterAttributes, true));
        }
    }

    public void run() {
        while (true){

        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}