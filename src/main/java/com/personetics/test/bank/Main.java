package com.personetics.test.bank;

import java.math.BigDecimal;
import java.time.LocalDate;

public class Main {
    public static void main(String[] args) {
        final var transaction = new Transaction();
        transaction.setAccountId("1");
        transaction.setAmount(BigDecimal.valueOf(321.11));
        transaction.setId("1");
        transaction.setDate(LocalDate.now().minusMonths(4));

        final var transaction2 = new Transaction();
        transaction2.setAccountId("1");
        transaction2.setAmount(BigDecimal.valueOf(777.77));
        transaction2.setId("2");
        transaction2.setDate(LocalDate.now().minusMonths(3).minusDays(7));

        final var transaction3 = new Transaction();
        transaction3.setAccountId("1");
        transaction3.setAmount(BigDecimal.valueOf(200));
        transaction3.setId("3");
        transaction3.setDate(LocalDate.now().minusMonths(3).minusDays(3));

        final var transaction4 = new Transaction();
        transaction4.setAccountId("1");
        transaction4.setAmount(BigDecimal.valueOf(343.56));
        transaction4.setId("4");
        transaction4.setDate(LocalDate.now());

        Database.getInstance().insert(transaction);
        Database.getInstance().insert(transaction2);
        Database.getInstance().insert(transaction3);
        Database.getInstance().insert(transaction4);

        final var aprilTransactions = Database.getInstance().getTransactionsOfMonthForAccount(4, "1");
        final var latestTransaction = Database.getInstance().getLatestTransaction();

        System.out.println("the average value is: " + Database.getInstance().getAvg());
        System.out.println("latest transaction: " + latestTransaction);
        System.out.println("april transactions are: " + aprilTransactions);
    }
}
