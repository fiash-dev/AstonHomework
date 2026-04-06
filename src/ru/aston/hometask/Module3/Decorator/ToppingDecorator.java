package ru.aston.hometask.Module3.Decorator;

import java.util.Objects;

public abstract class ToppingDecorator implements Pizza {
    protected Pizza pizza;

    public ToppingDecorator(Pizza pizza) {
        this.pizza = Objects.requireNonNull(pizza);
    }
}
