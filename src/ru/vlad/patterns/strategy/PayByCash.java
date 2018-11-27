package ru.vlad.patterns.strategy;

public class PayByCash implements PaymentStrategy {
    private String walletName;
    private int balance;

    public PayByCash(String walletName, int balance) {
        this.walletName = walletName;
        this.balance = balance;
    }

    public int getBalance() {
        return balance;
    }

    public void setBalance(int balance) {
        this.balance = balance;
    }

    @Override
    public boolean pay(int sum) {
        if (getBalance() - sum < 0){
            System.out.println("Not enough cash in your wallet");
            return false;
        } else {
            setBalance(getBalance() - sum);
            System.out.println("Payment processed");
            return true;
        }
    }

    @Override
    public void collectPaymentDetails() {
        System.out.printf("Wallet: %s", walletName+"\n");
    }
}
