import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Game {

    public static final int PEN_SIZE = 8;
    public static final int INITIAL_SIZE = 4;
    public static final double BREEDING_PADDING = 10;
    public static final double STARTING_MONEY = 500.0;

    private final Scanner input;
    private final Date date;
    private final Bank bank;
    private List<Dog> pen;

    private List<Pair<String, String>> inputOptions;

    private double[] demands;

    private List<Pair<Integer, Integer>> breedingPairs;



    public Game() {
        System.out.println("Loading...");
        input = new Scanner(System.in);
        date = new Date();
        bank = new Bank(STARTING_MONEY);
        pen = new ArrayList<>();
        generateStarters();
        generateInitialDemand();
        System.out.println("Done!");
    }

    private void generateStarters() {
        for (int i = 0; i < INITIAL_SIZE; i++) {
            List<Attribute> starterAttributes = new ArrayList<>(Attribute.attributePresets.size());
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
        System.out.println("Here's your Pen:");
        for (Dog dog : pen){
            StringBuilder dogInfo = new StringBuilder(dog.getName() + "\t" + dog.getAge() + "\t");
            for (Attribute attribute: dog.getAttributes()){
                dogInfo.append(attribute);
            }
            System.out.println(dogInfo);
        }
    }

    private void breedView(){

    }

    private void dogView(){

    }

    private void dogStatus(Dog d){

    }

    private void optionsView(){
        System.out.println(
                "D to examine a Dog\t" +
                        "B to Breed Dogs\t" +
                        "E to End the Day"
        );
    }

    private void nextDay(){
        date.advance();
        updateDemand();
    }

    public void run() {
        introduction();
        while (true) {
            penView();
            optionsView();
            String choice = input.next();
            System.out.println();
            switch (choice.toUpperCase()) {
                case "D":
                    dogView();
                    break;
                case "B":
                    breedView();
                    break;
                case "E":
                    nextDay();
                    break;
                default:
                    System.out.println(choice + "is not an option. Please try again.");
            }
        }
    }

    public static void main(String[] args) {
        Game game = new Game();
        game.run();
    }

}