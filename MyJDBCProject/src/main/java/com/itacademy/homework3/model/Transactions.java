package com.itacademy.homework3.model;

import java.util.Objects;

public class Transactions {
    private int transactinId;
    private int accountId;
    private int amount;

    public int getTransactinId() {
        return transactinId;
    }

    public void setTransactinId(int transactinId) {
        this.transactinId = transactinId;
    }

    public int getAccountId() {
        return accountId;
    }

    public void setAccountId(int accountId) {
        this.accountId = accountId;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Transactions{" +
                "transactinId=" + transactinId +
                ", accountId=" + accountId +
                ", amount=" + amount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Transactions that = (Transactions) o;
        return transactinId == that.transactinId && accountId == that.accountId && amount == that.amount;
    }

    @Override
    public int hashCode() {
        return Objects.hash(transactinId, accountId, amount);
    }
}

