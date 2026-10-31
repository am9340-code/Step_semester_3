package inheritance_polymorphism.class_problems;

import java.util.*;

public class PaymentSystemFeeCalculation {

    static abstract class Payment {
        double amount;
        Payment(double amount) {
            this.amount = amount;
        }
        abstract double calculate();
    }

    static class Card extends Payment {
        Card(double amount) {
            super(amount);
        }
        double calculate() {
            return amount * 1.02;
        }
    }

    static class Wallet extends Payment {
        Wallet(double amount) {
            super(amount);
        }
        double calculate() {
            return amount * 1.01;
        }
    }

    static class BankTransfer extends Payment {
        BankTransfer(double amount) {
            super(amount);
        }
        double calculate() {
            return amount;
        }
    }

    static Payment create(String type, double amount) {
        if (type.equals("CARD"))
            return new Card(amount);
        if (type.equals("WALLET"))
            return new Wallet(amount);
        return new BankTransfer(amount);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Payment p = create(type, amount);
            double result = p.calculate();

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}