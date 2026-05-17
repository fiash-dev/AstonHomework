package ru.aston.hometask.Module3.Decorator;

public class BasePizza implements Pizza {

    @Override
    public String getDescription() {
        return "Базовая пицца";
    }

    @Override
    public double getCost() {
        return 200.0;
    }
}

