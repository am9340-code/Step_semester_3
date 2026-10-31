package abstraction_interface.assignment_problems;

import java.util.*;

public class MovieTicketCounter {

    static abstract class Ticket {
        int count;
        static final double CONVENIENCE_FEE = 20;

        Ticket(int count) {
            this.count = count;
        }

        abstract double price();

        double amount() {
            return count * (price() + CONVENIENCE_FEE);
        }
    }

    static class Regular extends Ticket {
        Regular(int count) {
            super(count);
        }

        double price() {
            return 150;
        }
    }

    static class Premium extends Ticket {
        Premium(int count) {
            super(count);
        }

        double price() {
            return 250;
        }
    }

    static class Recliner extends Ticket {
        Recliner(int count) {
            super(count);
        }

        double price() {
            return 400;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String seat = sc.next();
            int count = sc.nextInt();
            Ticket t;

            switch (seat) {
                case "REGULAR":
                    t = new Regular(count);
                    break;
                case "PREMIUM":
                    t = new Premium(count);
                    break;
                default:
                    t = new Recliner(count);
            }

            double amount = t.amount();
            System.out.printf(Locale.US, "%s: %.2f%n",
                    seat, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}