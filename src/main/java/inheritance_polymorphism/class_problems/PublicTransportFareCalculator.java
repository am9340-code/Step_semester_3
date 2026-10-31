package inheritance_polymorphism.class_problems;

import java.util.*;

public class PublicTransportFareCalculator {

    static abstract class Transport {
        double distance;

        Transport(double distance) {
            this.distance = distance;
        }

        abstract double calculate();
    }

    static class Bus extends Transport {
        Bus(double d) {
            super(d);
        }

        double calculate() {
            return Math.min(2 + 0.1 * distance, 10);
        }
    }

    static class Train extends Transport {
        Train(double d) {
            super(d);
        }

        double calculate() {
            return 3 + 0.15 * distance;
        }
    }

    static class Metro extends Transport {
        double factor;

        Metro(double d, double factor) {
            super(d);
            this.factor = factor;
        }

        double calculate() {
            return (1.5 + 0.2 * distance) * factor;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();

            Transport t;

            if (type.equals("BUS"))
                t = new Bus(distance);
            else if (type.equals("TRAIN"))
                t = new Train(distance);
            else
                t = new Metro(distance, sc.nextDouble());

            double fare = t.calculate();

            System.out.printf("%s: %.2f%n", type, fare);
            total += fare;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}