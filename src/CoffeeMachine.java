import java.util.Scanner;

public class CoffeeMachine {

    public static final Scanner scanner = new Scanner(System.in);

    static int water = 1200;
    static int milk = 540;
    static int coffeeBeans = 120;
    static int dispCups = 9;
    static int money = 550;

    public static void main(String[] args) {

        printState();
        run();
//        while(scanner.hasNextLine()){
//            useMachine();
//            printState();
//        }
//        if(true){
//            useMachine();
//            printState();
//        }
//        else if(scanner.hasNextLine()) {
//            scanner.hasNextLine();
//            useMachine();
//            printState();
//        }
    }

    public static void useMachine() {
        System.out.println();
        String use = scanner.nextLine();
        switch (use) {
            case "buy":
                buyCoffee();
                break;
            case "fill":
                fillMachine();
                break;
            case "take":
                takeMoney();
                break;
            default:
                System.out.println();
        }
    }

    public static void printState() {
        if(!verify()){
            System.out.println("The coffee machine has:\n" +
                    water + " of water\n" +
                    milk + " of milk\n" +
                    coffeeBeans + " of coffee beans\n" +
                    dispCups + " of disposable cups\n" +
                    money + " of money");
            System.out.println("Write action (buy, fill, take): ");}
        else {
            System.out.println("Machine needs filling!");
            fillMachine();
        }
    }

    public static void fillMachine(){
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add: ");
        coffeeBeans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        dispCups += scanner.nextInt();
        System.out.println();

    }
    public static void takeMoney() {
        System.out.println("I gave you "+money);
        money = 0;
        System.out.println();
    }

    public static void buyCoffee() {
        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
        int coffee = scanner.nextInt();
        switch (coffee) {
            case 1:
                makeEspresso();
                break;
            case 2:
                makeLatte();
                break;
            case 3:
                makeCappucino();
                break;
            default:
                System.out.println("There is no this kind of coffee");
        }
    }

    public static void makeEspresso() {
        water -= 250;
        coffeeBeans -= 16;
        money += 4;
        dispCups -= 1;
    }

    public static void makeLatte() {
        water -= 350;
        milk -= 75;
        coffeeBeans -= 20;
        money += 7;
        dispCups -= 1;
    }

    public static void makeCappucino() {
        water -= 200;
        milk -= 100;
        coffeeBeans -= 12;
        money += 7;
        dispCups -= 1;
    }

    public static boolean verify(){
        int waterLevel = water;       //-350
        int milkLevel = milk;   //-100
        int coffeeBeansLevel = coffeeBeans;  //-20
        int dispCupsLevel = dispCups;  // - 1;
        boolean resources =(waterLevel<0)||(milkLevel<0)||(coffeeBeansLevel<0)||(dispCupsLevel<0);
        if(((waterLevel<0)||(milkLevel<0)||(coffeeBeansLevel<0)||(dispCupsLevel<0))){
            System.out.println("Machine out of service");
        }return resources;
    }

    public static void run() {
        if(scanner.hasNextLine()) {
            useMachine();
            printState();
            run();
        }
    }

}