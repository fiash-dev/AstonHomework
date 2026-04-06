package ru.aston.hometask.Module3.ChainOfResponsibility;

import java.math.BigDecimal;

public class MoneyTransaction {
    private BigDecimal amount;

    public MoneyTransaction(BigDecimal amount) {
        this.amount = amount;
    }

    public BigDecimal getAmount() {
        return amount;
    }
}
