package machine;

public class CoffeeMachine {
    public static void main(String[] args) {
        final int waterForCup = 200;
        final int milkForCup = 50;
        final int coffeeForCup = 15;
        
        int cupsPossible = 0;
        
        System.out.println("Write how many ml of water the coffee machine has:");
        int waterLevel = new java.util.Scanner(System.in).nextInt();
        System.out.println("Write how many ml of milk the coffee machine has:");
        final int milkLevel = new java.util.Scanner(System.in).nextInt();
        System.out.println("Write how many grams of coffee beans the coffee machine has:");
        final int coffeeLevel = new java.util.Scanner(System.in).nextInt();
        System.out.println("Write how many cups of coffee you will need:");
        int cupsOrdered = new java.util.Scanner(System.in).nextInt();
        
        cupsPossible = Math.min(Math.min(waterLevel / waterForCup, milkLevel / milkForCup), coffeeLevel / coffeeForCup);
        
        if (cupsPossible == cupsOrdered) {
            System.out.print("Yes, I can make that amount of coffee");
        } else if (cupsPossible > cupsOrdered) {
            System.out.printf("Yes, I can make that amount of coffee (and even %d more than that)", cupsPossible - cupsOrdered);
        } else if (cupsPossible < cupsOrdered) {
            System.out.printf("No, I can make only %d cup(s) of coffee", cupsPossible);
        }
    }
}