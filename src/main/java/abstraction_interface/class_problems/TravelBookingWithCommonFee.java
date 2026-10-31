package abstraction_interface.class_problems;

import java.util.*;

public class TravelBookingWithCommonFee {

    static abstract class Booking {
        double distance;
        static final double BOOKING_FEE = 50;

        Booking(double distance) {
            this.distance = distance;
        }

        abstract double baseFare();

        double totalFare() {
            return baseFare() + BOOKING_FEE;
        }
    }

    static class Bus extends Booking {
        Bus(double d) {
            super(d);
        }

        double baseFare() {
            return distance * 2;
        }
    }

    static class Train extends Booking {
        Train(double d) {
            super(d);
        }

        double baseFare() {
            return distance * 1.5;
        }
    }

    static class Flight extends Booking {
        Flight(double d) {
            super(d);
        }

        double baseFare() {
            return 2500 + distance * 4;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();
            Booking b;

            switch (mode) {
                case "BUS":
                    b = new Bus(distance);
                    break;
                case "TRAIN":
                    b = new Train(distance);
                    break;
                default:
                    b = new Flight(distance);
            }

            System.out.printf(Locale.US, "%s: %.2f%n",
                    mode, b.totalFare());
        }
    }
}