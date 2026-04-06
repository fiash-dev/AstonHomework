package ru.aston.hometask.Module3.ChainOfResponsibility;

import java.math.BigDecimal;

public class Main {
    public static void main(String[] args) {
        ValidateTransaction firstValidation = new MinLimit();
        ValidateTransaction secondValidation = new MaxLimit();
        firstValidation.setNext(secondValidation);

        firstValidation.check(new MoneyTransaction(new BigDecimal("2000")));
        firstValidation.check(new MoneyTransaction(new BigDecimal("12000")));
    }
}
