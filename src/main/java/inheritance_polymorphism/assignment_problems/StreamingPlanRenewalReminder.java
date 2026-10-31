package inheritance_polymorphism.assignment_problems;

import java.time.LocalDate;
import java.util.*;

public class StreamingPlanRenewalReminder {

    static abstract class Plan {
        String name;
        LocalDate start;

        Plan(String name, LocalDate start) {
            this.name = name;
            this.start = start;
        }

        abstract int days();

        LocalDate renewalDate() {
            return start.plusDays(days());
        }
    }

    static class Basic extends Plan {
        Basic(String n, LocalDate d) {
            super(n, d);
        }

        int days() {
            return 30;
        }
    }

    static class Standard extends Plan {
        Standard(String n, LocalDate d) {
            super(n, d);
        }

        int days() {
            return 90;
        }
    }

    static class Premium extends Plan {
        Premium(String n, LocalDate d) {
            super(n, d);
        }

        int days() {
            return 365;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            Plan p;

            if (type.equals("BASIC"))
                p = new Basic(name, date);
            else if (type.equals("STANDARD"))
                p = new Standard(name, date);
            else
                p = new Premium(name, date);

            System.out.println(name + ": " + p.renewalDate());
        }
    }
}