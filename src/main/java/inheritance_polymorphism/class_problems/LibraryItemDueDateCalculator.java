package inheritance_polymorphism.class_problems;

import java.time.LocalDate;
import java.util.*;

public class LibraryItemDueDateCalculator {

    static abstract class LibraryItem {
        String title;

        LibraryItem(String title) {
            this.title = title;
        }

        abstract int days();

        String dueDate() {
            return LocalDate.of(2023, 10, 26)
                    .plusDays(days()).toString();
        }
    }

    static class Book extends LibraryItem {
        Book(String title) {
            super(title);
        }
        int days() {
            return 14;
        }
    }

    static class DVD extends LibraryItem {
        DVD(String title) {
            super(title);
        }
        int days() {
            return 7;
        }
    }

    static class Magazine extends LibraryItem {
        Magazine(String title) {
            super(title);
        }
        int days() {
            return 3;
        }
    }

    static LibraryItem create(String type, String title) {
        if (type.equals("BOOK"))
            return new Book(title);
        if (type.equals("DVD"))
            return new DVD(title);
        return new Magazine(title);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine();
            String[] p = line.split(" ", 2);

            String type = p[0];
            String title = p[1].replace("\"", "");

            LibraryItem item = create(type, title);
            System.out.println(item.title + ": " + item.dueDate());
        }
    }
}