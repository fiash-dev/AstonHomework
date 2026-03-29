package ru.aston.hometask.Module3.ChainOfResponsibility;

public class MoneyTransaction {
    private double amount;

    public MoneyTransaction(double amount) {
        this.amount = amount;
    }

    public double getAmount() {
        return amount;
    }
}
