package abstraction_interface.class_problems;

import java.util.*;

public class LibraryLateFineCounter {

    static abstract class LibraryItem {
        String title;
        int daysLate;

        LibraryItem(String title, int daysLate) {
            this.title = title;
            this.daysLate = daysLate;
        }

        abstract double fine();
    }

    static class Book extends LibraryItem {
        Book(String title, int days) {
            super(title, days);
        }

        double fine() {
            return daysLate * 2.0;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title, int days) {
            super(title, days);
        }

        double fine() {
            return Math.min(daysLate * 5.0, 50.0);
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title, int days) {
            super(title, days);
        }

        double fine() {
            return daysLate;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();
            LibraryItem item;

            switch (type) {
                case "BOOK":
                    item = new Book(title, days);
                    break;
                case "DVD":
                    item = new DVD(title, days);
                    break;
                default:
                    item = new Magazine(title, days);
            }

            double amount = item.fine();
            System.out.printf(Locale.US, "%s: %.2f%n",
                    item.title, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total Fines: %.2f%n", total);
    }
}