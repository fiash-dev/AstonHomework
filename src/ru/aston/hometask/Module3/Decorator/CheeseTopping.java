package ru.aston.hometask.Module3.Decorator;

public class CheeseTopping extends ToppingDecorator {

    public CheeseTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", сыр";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 30.0;
    }
}
