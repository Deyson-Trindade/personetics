package com.personetics.test.bank;

/* Design a data structure that gets as input a collection of Transaction objects from the last 6 months and supports the following methods in runtime complexity of O(1):
    insert(Transaction transaction)
    Double getAvg() – Returns the average amount of all transactions.
            List<Transaction> getTransactionsOfMonthForAccount(int month, String accountId) – Returns the list of transactions for the account with ‘accountId’ on the month of ‘month’ (assume class Date has method int getMonth()).
    Transaction getLatestTransaction() – Returns the latest transaction.
*/

import java.math.BigDecimal;
import java.time.LocalDate;

public class Transaction {
    private String id;
    private String accountId;
    private BigDecimal amount;
    private LocalDate date;


    public String getId() {
        return id;
    }


    public void setId(String id) {
        this.id = id;
    }


    public String getAccountId() {
        return accountId;
    }


    public void setAccountId(String accountId) {
        this.accountId = accountId;
    }


    public BigDecimal getAmount() {
        return amount;
    }


    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }


    public LocalDate getDate() {
        return date;
    }


    public void setDate(LocalDate date) {
        this.date = date;
    }


    @Override
    public String toString() {
        return "Transaction{" +
                "id='" + id + '\'' +
                ", accountId='" + accountId + '\'' +
                ", amount=" + amount +
                ", date=" + date +
                '}';
    }

}
