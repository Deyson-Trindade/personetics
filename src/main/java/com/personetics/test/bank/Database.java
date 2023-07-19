package com.personetics.test.bank;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.stream.Collectors;

public class Database {
    private long count;
    private BigDecimal totalAmount = BigDecimal.ZERO;
    private final Map<String, Map<Integer, Map<String, Transaction>>> monthTransactions = new LinkedHashMap<>();
    private static Database instance = null;
    private Collection<Transaction> transactions = null;
    private Transaction latestTransaction;


    private Database() {

    }


    public static Database getInstance() {
        if (Objects.isNull(instance)) {
            instance = new Database();
        }
        return instance;
    }


    public BigDecimal getAvg() {
        return totalAmount.divide(BigDecimal.valueOf(count), RoundingMode.HALF_UP);
    }


    public void insert(final Transaction transaction) {
        this.monthTransactions
                .computeIfAbsent(transaction.getAccountId(), k -> new LinkedHashMap<>())
                .computeIfAbsent(transaction.getDate().getMonthValue(), k -> new TreeMap<>())
                .put(transaction.getId(), transaction);

        settingControlProperties(transaction);
    }


    private void settingControlProperties(Transaction transaction) {
        count++;
        totalAmount = totalAmount.add(transaction.getAmount());
        latestTransaction = transaction;
        transactions = null;
    }


    public Collection<Transaction> getTransactions() {
        if(Objects.nonNull(transactions)) return transactions;

        transactions = monthTransactions.values()
                .stream()
                .flatMap(monthMap -> monthMap.values().stream())
                .flatMap(transactionMap -> transactionMap.values().stream())
                .collect(Collectors.toUnmodifiableList());
        return transactions;
    }


    public Collection<Transaction> getTransactionsOfMonthForAccount(final int month, final String accountId) {
        return this.monthTransactions.get(accountId).get(month).values();
    }


    public Transaction getLatestTransaction() {
        return latestTransaction;
    }

}
