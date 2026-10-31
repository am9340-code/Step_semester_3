package abstraction_interface.assignment_problems;

import java.util.*;

public class HomeApplianceEnergyReport {

    interface SaverMode {
        default double reduceUnits(double units) {
            return units * 0.75;
        }
    }

    static abstract class Appliance {
        double power;

        Appliance(double power) {
            this.power = power;
        }

        double units(double hours) {
            return power * hours / 1000;
        }
    }

    static class Fridge extends Appliance {
        Fridge() {
            super(150);
        }
    }

    static class AC extends Appliance implements SaverMode {
        AC() {
            super(1500);
        }
    }

    static class TV extends Appliance {
        TV() {
            super(100);
        }
    }

    static class Washer extends Appliance implements SaverMode {
        Washer() {
            super(500);
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = sc.nextLine().trim().split("\\s+");

            String type = p[0];
            double hours = Double.parseDouble(p[1]);
            boolean saver = p.length == 3 &&
                    p[2].equals("SAVER");

            Appliance a;

            switch (type) {
                case "FRIDGE":
                    a = new Fridge();
                    break;
                case "AC":
                    a = new AC();
                    break;
                case "TV":
                    a = new TV();
                    break;
                default:
                    a = new Washer();
            }

            if (saver && !(a instanceof SaverMode)) {
                System.out.println(type +
                        ": saver mode not supported");
                continue;
            }

            double units = a.units(hours);

            if (saver)
                units = ((SaverMode) a).reduceUnits(units);

            double cost = units * 8;

            System.out.printf(Locale.US,
                    "%s: Units=%.2f Cost=%.2f%n",
                    type, units, cost);

            total += cost;
        }

        System.out.printf(Locale.US, "Total Cost: %.2f%n", total);
    }
}