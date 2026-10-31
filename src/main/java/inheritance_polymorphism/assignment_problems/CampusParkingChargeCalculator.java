package inheritance_polymorphism.assignment_problems;

import java.util.*;

public class CampusParkingChargeCalculator {

    static abstract class Vehicle {
        int hours;

        Vehicle(int hours) {
            this.hours = hours;
        }

        abstract double charge();
    }

    static class Bike extends Vehicle {
        Bike(int h) {
            super(h);
        }

        double charge() {
            return hours * 10;
        }
    }

    static class Car extends Vehicle {
        Car(int h) {
            super(h);
        }

        double charge() {
            return 30 + (hours - 1) * 20;
        }
    }

    static class Truck extends Vehicle {
        Truck(int h) {
            super(h);
        }

        double charge() {
            return Math.max(hours * 50, 100);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();

            Vehicle v;

            if (type.equals("BIKE"))
                v = new Bike(hours);
            else if (type.equals("CAR"))
                v = new Car(hours);
            else
                v = new Truck(hours);

            double charge = v.charge();

            System.out.printf("%s: %.2f%n", type, charge);
            total += charge;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}