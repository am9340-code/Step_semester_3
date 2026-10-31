package inheritance_polymorphism.assignment_problems;

import java.util.*;

public class CanteenBillingCounter {

    static abstract class Customer {
        double amount;

        Customer(double amount) {
            this.amount = amount;
        }

        abstract double finalAmount();
    }

    static class Student extends Customer {
        Student(double a) {
            super(a);
        }

        double finalAmount() {
            return amount * 0.90;
        }
    }

    static class Staff extends Customer {
        Staff(double a) {
            super(a);
        }

        double finalAmount() {
            return amount * 0.95;
        }
    }

    static class Guest extends Customer {
        Guest(double a) {
            super(a);
        }

        double finalAmount() {
            return amount + 10;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();

            Customer c;

            if (type.equals("STUDENT"))
                c = new Student(amount);
            else if (type.equals("STAFF"))
                c = new Staff(amount);
            else
                c = new Guest(amount);

            double result = c.finalAmount();

            System.out.printf("%s: %.2f%n", type, result);
            total += result;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}