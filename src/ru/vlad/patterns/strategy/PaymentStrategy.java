package ru.vlad.patterns.strategy;

public interface PaymentStrategy {
    boolean pay(int sum);

    void collectPaymentDetails();
}
