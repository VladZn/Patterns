package ru.vlad.patterns.strategy;

public class PayByCreditCard implements PaymentStrategy {
    private CreditCard creditCard;

    public PayByCreditCard(CreditCard creditCard) {
        this.creditCard = creditCard;
    }

    @Override
    public boolean pay(int sum) {
        if (creditCard.isExpired()){
            System.out.println("Credit card is expired");
            return false;
        } else if (creditCard.getBalance() - sum >= 0){
            creditCard.setBalance(creditCard.getBalance() - sum);
            System.out.println("Payment processed");
            return true;
        } else {
            System.out.println("Insufficient funds");
            return false;
        }
    }

    @Override
    public void collectPaymentDetails() {
        System.out.println("Payment details:");
        System.out.println(creditCard);
    }
}
