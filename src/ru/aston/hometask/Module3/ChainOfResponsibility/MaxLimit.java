package ru.aston.hometask.Module3.ChainOfResponsibility;

import java.math.BigDecimal;

public class MaxLimit extends ValidateTransaction {
    @Override
    public void check(MoneyTransaction moneyTransaction) {
        if (moneyTransaction.getAmount().compareTo(new BigDecimal("10000")) >= 0) {
            System.out.println("Превышен максимальный размер транзакции!");
        }
    }
}
