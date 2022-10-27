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

    private double[] demands;

    public static final double BREEDING_PADDING = 10;

    public Game() {
        date = new Date();
        bank = new Bank(500);
        pen = new ArrayList<>();
        generateStarters();
        generateInitialDemand();
    }

    private void generateStarters() {
        for (int i = 0; i < 3; i++) {
            List<Attribute> starterAttributes = new ArrayList<>(5);
            for (Attribute attribute : Attribute.attributePresets)
                starterAttributes.add(new Attribute(attribute.name, Math.random() * 40 + 30, attribute.statusEffects));
            pen.add(new Dog("Starter", "Starter Dog", starterAttributes, true));
        }
    }

    private void generateInitialDemand() {
        demands = new double[]{
                Math.random() * 40 + 30,
                Math.random() * 40 + 30,
                Math.random() * 40 + 30,
                Math.random() * 40 + 30,
                Math.random() * 40 + 30
        };
    }

    private void updateDemand() {
        for (int i = 0; i < demands.length; i++) {
            int[] dateSegments = date.getDateSegments();
            double offset = Math.random() * 10 - 5;
            double demand = demands[i] + offset;
            if (dateSegments[1] < 1)
                demands[i] = demand;
            else if (dateSegments[0] < 1)
                demands[i] = Math.pow(demand, 1.5) / Math.pow(100, 1.5);
            else
                demands[i] = Math.pow(demand, 2) / Math.pow(100, 2);
        }
    }

    private void introduction(){

    }

    private void penView(){

    }

    private void dogStatus(Dog d){

    }

    private void nextDay(){
        date.advance();
    }

    public void run() {
        while (true) {

        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }
}