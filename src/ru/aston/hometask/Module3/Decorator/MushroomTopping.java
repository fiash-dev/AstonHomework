package ru.aston.hometask.Module3.Decorator;

public class MushroomTopping extends ToppingDecorator {

    public MushroomTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", грибы";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 40.0;
    }
}
