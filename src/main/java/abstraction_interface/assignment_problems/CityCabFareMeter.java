package abstraction_interface.assignment_problems;

import java.util.*;

public class CityCabFareMeter {

    interface NightService {
    }

    static abstract class Cab {
        double km;

        Cab(double km) {
            this.km = km;
        }

        abstract double rate();

        double fare(boolean night) {
            double amount = Math.max(km * rate(), 100);

            if (night)
                amount *= 1.20;

            return amount;
        }
    }

    static class Mini extends Cab {
        Mini(double km) {
            super(km);
        }

        double rate() {
            return 10;
        }
    }

    static class Sedan extends Cab implements NightService {
        Sedan(double km) {
            super(km);
        }

        double rate() {
            return 14;
        }
    }

    static class SUV extends Cab implements NightService {
        SUV(double km) {
            super(km);
        }

        double rate() {
            return 18;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();

            Cab c;

            switch (type) {
                case "MINI":
                    c = new Mini(km);
                    break;
                case "SEDAN":
                    c = new Sedan(km);
                    break;
                default:
                    c = new SUV(km);
            }

            boolean night = time.equals("NIGHT");

            if (night && !(c instanceof NightService)) {
                System.out.println(type +
                        ": night service not available");
                continue;
            }

            double fare = c.fare(night);
            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, fare);
            total += fare;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}