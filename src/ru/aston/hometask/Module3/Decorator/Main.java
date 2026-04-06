package ru.aston.hometask.Module3.Decorator;

public class Main {
    public static void main(String[] args) {
        Pizza pizza1 = new BasePizza();
        System.out.println("1. " + pizza1.getDescription() + " — " + pizza1.getCost() + " руб.");

        Pizza pizza2 = new CheeseTopping(new BasePizza());
        System.out.println("2. " + pizza2.getDescription() + " — " + pizza2.getCost() + " руб.");

        Pizza pizza3 = new HamTopping(new CheeseTopping(new BasePizza()));
        System.out.println("3. " + pizza3.getDescription() + " — " + pizza3.getCost() + " руб.");

        Pizza pizza4 = new MushroomTopping(
                new HamTopping(
                        new CheeseTopping(new BasePizza())));
        System.out.println("4. " + pizza4.getDescription() + " — " + pizza4.getCost() + " руб.");
    }
}
