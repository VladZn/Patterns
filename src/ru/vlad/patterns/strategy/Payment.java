package ru.vlad.patterns.strategy;

public class Payment {
    private int totalAmount;
    private boolean isPaid;

    public Payment(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public void processPayment(PaymentStrategy strategy){
        strategy.collectPaymentDetails();
    }
    public int getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(int totalAmount) {
        this.totalAmount = totalAmount;
    }

    public boolean isPaid() {
        return isPaid;
    }

    public void setPayed() {
        isPaid = true;
    }
}
