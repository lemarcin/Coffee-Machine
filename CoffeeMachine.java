package machine;

public class CoffeeMachine {
    public static void main(String[] args) {
        System.out.print("Write how many cups of coffee you will need: \n> ");
        int cups = new java.util.Scanner(System.in).nextInt();
        final int water = 200;
        final int milk = 50;
        final int coffee = 15;
        System.out.printf("For %d cups of coffee you will need:%n", cups);
        System.out.printf("%d ml of water\n", cups * water);
        System.out.printf("%d ml of milk\n", cups * milk);
        System.out.printf("%d g of coffee beans\n", cups * coffee);
    }
}