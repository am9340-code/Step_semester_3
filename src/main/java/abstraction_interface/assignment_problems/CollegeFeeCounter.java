package abstraction_interface.assignment_problems;

import java.util.*;

public class CollegeFeeCounter {

    interface BusUser {
        double TRANSPORT_FEE = 12000;
    }

    static abstract class Student {
        String name;

        Student(String name) {
            this.name = name;
        }

        abstract double tuition();

        double transportFee() {
            return 0;
        }

        double hostelFee() {
            return 0;
        }

        double totalFee() {
            return tuition() + transportFee() + hostelFee();
        }
    }

    static class DayScholar extends Student implements BusUser {
        DayScholar(String name) {
            super(name);
        }

        double tuition() {
            return 40000;
        }

        double transportFee() {
            return TRANSPORT_FEE;
        }
    }

    static class Hosteller extends Student {
        Hosteller(String name) {
            super(name);
        }

        double tuition() {
            return 40000;
        }

        double hostelFee() {
            return 60000;
        }
    }

    static class Scholar extends Student implements BusUser {
        Scholar(String name) {
            super(name);
        }

        double tuition() {
            return 20000;
        }

        double transportFee() {
            return TRANSPORT_FEE;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Student s;

            switch (type) {
                case "DAY_SCHOLAR":
                    s = new DayScholar(name);
                    break;
                case "HOSTELLER":
                    s = new Hosteller(name);
                    break;
                default:
                    s = new Scholar(name);
            }

            double fee = s.totalFee();
            System.out.printf(Locale.US, "%s: %.2f%n",
                    name, fee);
            total += fee;
        }

        System.out.printf(Locale.US, "Total Collected: %.2f%n", total);
    }
}