package machine;

import java.util.Scanner;

public class CoffeeMachine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Machine machine = new Machine();
        do {
            machine.master(scanner.nextLine());
        }while (machine.exit);
    }
}

class Machine {

    enum Status { MENU, BUY, FILL, TAKE, FILL_WATER, FILL_MILK, FILL_COFFEE, FILL_CUPS
    }

    private final int waterEspresso = 250;
    private final int coffeeEspresso = 16;
    private final int espressoPrice = 4;
    private final int waterLatte = 350;
    private final int milkLatte = 75;
    private final int coffeeLatte = 20;
    private final int lattePrice = 7;
    private final int waterCappuccino = 200;
    private final int milkCappuccino = 100;
    private final int coffeeCappuccino = 12;
    private final int cappuccinoPrice = 6;
    private int money = 550;
    private int waterLevel = 400;
    private int milkLevel = 540;
    private int coffeeLevel = 120;
    private int cups = 9;
    private Status status = Status.MENU;
    protected Boolean exit = true;

    public Machine() {
        state();
        actionMenu();
    }

    protected void master(String command) {
        switch (status) {
            case MENU:
                switch (command) {
                    case "buy":
                        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino: ");
                        status = Status.BUY;
                        break;
                    case "fill":
                        System.out.println("Write how many ml of water you want to add: ");
                        status = Status.FILL_WATER;
                        break;
                    case "take":
                        take();
                        state();
                        exit = false;
                        status = Status.MENU;
                        break;
                }
                break;
            case BUY:
                buy(command);
                break;
            case FILL_WATER:
                waterLevel += Integer.parseInt(command);
                System.out.println("Write how many ml of milk you want to add: ");
                status = Status.FILL_MILK;
                break;
            case FILL_MILK:
                milkLevel += Integer.parseInt(command);
                System.out.println("Write how many grams of coffee beans you want to add: ");
                status = Status.FILL_COFFEE;
                break;
            case FILL_COFFEE:
                coffeeLevel += Integer.parseInt(command);
                System.out.println("Write how many disposable cups of coffee you want to add: ");
                status = Status.FILL_CUPS;
                break;
            case FILL_CUPS:
                cups += Integer.parseInt(command);
                status = Status.MENU;
                state();
                exit = false;
                break;
        }
    }

    private void actionMenu() {
        System.out.println("Write action (buy, fill, take):");
    }

    private void buy(String action) {
        switch (action) {
            case "1":
                if (waterLevel > waterEspresso && coffeeLevel > coffeeEspresso && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    coffeeLevel -= coffeeEspresso;
                    waterLevel -= waterEspresso;
                    money += espressoPrice;
                    cups--;
                } else {
                    System.out.println("Sorry, not enough" +
                            (waterLevel < waterEspresso ? " water" : "") +
                            (coffeeLevel < coffeeEspresso ? " coffee" : "") +
                            (cups == 0 ? " cups" : "") + "!");
                }
                break;
            case "2":
                if (waterLevel > waterLatte && milkLevel > milkLatte && coffeeLevel > coffeeLatte && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    coffeeLevel -= coffeeLatte;
                    milkLevel -= milkLatte;
                    waterLevel -= waterLatte;
                    money += lattePrice;
                    cups--;
                } else {
                    System.out.println("Sorry, not enough" +
                            (waterLevel < waterLatte ? " water" : "") +
                            (milkLevel < milkLatte ? " milk" : "") +
                            (coffeeLevel < coffeeLatte ? " coffee" : "") +
                            (cups == 0 ? " cups" : "") + "!");
                }
                break;
            case "3":
                if (waterLevel > waterCappuccino && milkLevel > milkCappuccino && coffeeLevel > coffeeCappuccino && cups > 0) {
                    System.out.println("I have enough resources, making you a coffee!\n");
                    coffeeLevel -= coffeeCappuccino;
                    milkLevel -= milkCappuccino;
                    waterLevel -= waterCappuccino;
                    money += cappuccinoPrice;
                    cups--;
                } else {
                    System.out.println("Sorry, not enough" +
                            (waterLevel < waterCappuccino ? " water" : "") +
                            (milkLevel < milkCappuccino ? " milk" : "") +
                            (coffeeLevel < coffeeCappuccino ? " coffee" : "") +
                            (cups == 0 ? " cups" : "") + "!");
                }
                break;
        }
        state();
        exit = false;
    }

    private void state() {
        System.out.println("The coffee machine has:");
        System.out.println(waterLevel + " ml of water");
        System.out.println(milkLevel + " ml of milk");
        System.out.println(coffeeLevel + " g of coffee beans");
        System.out.println(cups + " disposable cups");
        System.out.println("$" + money + " of money\n");
    }

    private void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }
}