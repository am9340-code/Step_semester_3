package inheritance_polymorphism.assignment_problems;

import java.util.*;

public class HostelElectricityBill {

    static abstract class Room {
        int units;

        Room(int units) {
            this.units = units;
        }

        abstract double bill();
    }

    static class Single extends Room {
        Single(int u) {
            super(u);
        }

        double bill() {
            return units * 8;
        }
    }

    static class Shared extends Room {
        int occupants;

        Shared(int u, int o) {
            super(u);
            occupants = o;
        }

        double bill() {
            return units * 6.0 / occupants;
        }
    }

    static class AC extends Room {
        AC(int u) {
            super(u);
        }

        double bill() {
            return units * 10 + 200;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();

            Room r;

            if (type.equals("SINGLE"))
                r = new Single(units);
            else if (type.equals("SHARED"))
                r = new Shared(units, sc.nextInt());
            else
                r = new AC(units);

            double bill = r.bill();

            System.out.printf("%s: %.2f%n", type, bill);
            total += bill;
        }

        System.out.printf("Total: %.2f%n", total);
    }
}