package abstraction_interface.class_problems;

import java.util.*;

public class WeeklyStaffPay {

    static abstract class Staff {
        String name;

        Staff(String name) {
            this.name = name;
        }

        abstract double pay();
    }

    static class FullTime extends Staff {
        double salary;

        FullTime(String name, double salary) {
            super(name);
            this.salary = salary;
        }

        double pay() {
            return salary;
        }
    }

    static class Hourly extends Staff {
        int hours;
        double rate;

        Hourly(String name, int hours, double rate) {
            super(name);
            this.hours = hours;
            this.rate = rate;
        }

        double pay() {
            if (hours <= 40)
                return hours * rate;

            return 40 * rate + (hours - 40) * rate * 1.5;
        }
    }

    static class Intern extends Staff {
        double stipend;

        Intern(String name, double stipend) {
            super(name);
            this.stipend = stipend;
        }

        double pay() {
            return stipend;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            Staff s;

            switch (type) {
                case "FULLTIME":
                    s = new FullTime(name, sc.nextDouble());
                    break;
                case "HOURLY":
                    s = new Hourly(name, sc.nextInt(),
                            sc.nextDouble());
                    break;
                default:
                    s = new Intern(name, sc.nextDouble());
            }

            double amount = s.pay();
            System.out.printf(Locale.US, "%s: %.2f%n",
                    s.name, amount);
            total += amount;
        }

        System.out.printf(Locale.US, "Total Payroll: %.2f%n", total);
    }
}