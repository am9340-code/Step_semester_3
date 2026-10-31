package abstraction_interface.assignment_problems;

import java.util.*;

public class ParcelShippingDesk {

    interface Insurable {
        double insurance();
    }

    static abstract class Parcel {
        double weight, declaredValue;

        Parcel(double weight, double value) {
            this.weight = weight;
            this.declaredValue = value;
        }

        abstract double charge();
    }

    static class Standard extends Parcel {
        Standard(double w, double v) {
            super(w, v);
        }

        double charge() {
            return 40 + 10 * weight;
        }
    }

    static class Express extends Parcel implements Insurable {
        Express(double w, double v) {
            super(w, v);
        }

        double charge() {
            return 80 + 15 * weight;
        }

        public double insurance() {
            return declaredValue * 0.02;
        }
    }

    static class Fragile extends Parcel implements Insurable {
        Fragile(double w, double v) {
            super(w, v);
        }

        double charge() {
            return 40 + 10 * weight + 50;
        }

        public double insurance() {
            return declaredValue * 0.02;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double grandTotal = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();
            Parcel p;

            switch (type) {
                case "STANDARD":
                    p = new Standard(weight, value);
                    break;
                case "EXPRESS":
                    p = new Express(weight, value);
                    break;
                default:
                    p = new Fragile(weight, value);
            }

            double charge = p.charge();
            double insurance = 0;

            if (p instanceof Insurable)
                insurance = ((Insurable) p).insurance();

            double total = charge + insurance;

            System.out.printf(Locale.US,
                    "%s: Charge=%.2f Insurance=%.2f Total=%.2f%n",
                    type, charge, insurance, total);

            grandTotal += total;
        }

        System.out.printf(Locale.US, "Grand Total: %.2f%n", grandTotal);
    }
}