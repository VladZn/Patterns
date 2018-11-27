package ru.vlad.patterns.strategy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.time.LocalDate;

public class Demo {
    private static PaymentStrategy strategy;

    public static void main(String[] args) {
        CreditCard creditCard = new CreditCard("4242 0000 1111 2222", "Vasya Pupkin",
                                            LocalDate.of(2019, 2, 1), 123, 50000);

        System.out.println("Choose a payment method:");
        System.out.println("1 - cash");
        System.out.println("2 - credit card");


        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        try {
            String paymentMethod = reader.readLine();
            if (paymentMethod.equals("1")) {
                strategy = new PayByCash("Заначка", 10000);
            } else {
                strategy = new PayByCreditCard(creditCard);
            }

            Payment payment = new Payment(5000);
            payment.processPayment(strategy);

            strategy.pay(payment.getTotalAmount());

        } catch (IOException e) {
            e.printStackTrace();
        }



    }
}
