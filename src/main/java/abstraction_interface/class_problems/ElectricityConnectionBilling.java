package abstraction_interface.class_problems;

import java.util.*;

public class ElectricityConnectionBilling {

    static abstract class Connection {
        int units;

        Connection(int units) {
            this.units = units;
        }

        abstract double bill();
    }

    static class Home extends Connection {
        Home(int units) {
            super(units);
        }

        double bill() {
            if (units <= 100)
                return units * 5.0;

            return 100 * 5.0 + (units - 100) * 7.0;
        }
    }

    static class Shop extends Connection {
        Shop(int units) {
            super(units);
        }

        double bill() {
            return units * 8.0 + 100;
        }
    }

    static class Factory extends Connection {
        Factory(int units) {
            super(units);
        }

        double bill() {
            return Math.max(units * 6.0, 1000);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            Connection c;

            switch (type) {
                case "HOME":
                    c = new Home(units);
                    break;
                case "SHOP":
                    c = new Shop(units);
                    break;
                default:
                    c = new Factory(units);
            }

            double amount = c.bill();
            System.out.printf(Locale.US, "%s: %.2f%n",
                    type, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total: %.2f%n", total);
    }
}