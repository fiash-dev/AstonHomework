package ru.aston.hometask.Module3.ChainOfResponsibility;

public class MaxLimit extends ValidateTransaction {
    @Override
    public void check(MoneyTransaction moneyTransaction) {
        if (moneyTransaction.getAmount() > 10000) {
            System.out.println("Превышен максимальный размер транзакции!");
        }
    }
}
