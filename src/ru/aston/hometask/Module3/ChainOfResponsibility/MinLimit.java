package ru.aston.hometask.Module3.ChainOfResponsibility;

import java.math.BigDecimal;

public class MinLimit extends ValidateTransaction {
    @Override
    public void check(MoneyTransaction moneyTransaction) {
        if (moneyTransaction.getAmount().compareTo(new BigDecimal ("1000")) >= 0) {
            System.out.println("Необходимо ввести пин-код");
        }

        checkNext(moneyTransaction);
    }
}
