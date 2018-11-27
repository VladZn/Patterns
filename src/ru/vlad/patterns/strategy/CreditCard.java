package ru.vlad.patterns.strategy;

import java.time.LocalDate;

public class CreditCard {
    private final String cardNum;
    private final String cardHolderName;
    private LocalDate expDate;
    private final int cvv;
    private int balance;

    public CreditCard(String cardNum, String cardHolderName, LocalDate expDate, int cvv, int balance) {
        this.cardNum = cardNum;
        this.cardHolderName = cardHolderName;
        this.expDate = expDate;
        this.cvv = cvv;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    public LocalDate getExpDate() {
        return expDate;
    }

    public boolean isExpired() {
        return getExpDate().isBefore(LocalDate.now());
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "cardNum='" + cardNum + '\'' +
                ", cardHolderName='" + cardHolderName + '\'' +
                ", expDate=" + expDate +
                ", cvv=" + cvv +
                '}';
    }
}
