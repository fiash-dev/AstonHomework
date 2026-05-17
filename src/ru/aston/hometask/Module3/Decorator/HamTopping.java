package ru.aston.hometask.Module3.Decorator;

public class HamTopping extends ToppingDecorator {

    public HamTopping(Pizza pizza) {
        super(pizza);
    }

    @Override
    public String getDescription() {
        return pizza.getDescription() + ", ветчина";
    }

    @Override
    public double getCost() {
        return pizza.getCost() + 50.0;
    }
}
