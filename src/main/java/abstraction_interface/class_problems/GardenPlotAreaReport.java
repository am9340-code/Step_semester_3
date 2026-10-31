package abstraction_interface.class_problems;

import java.util.*;

public class GardenPlotAreaReport {

    static abstract class Plot {
        String owner;
        String shape;

        Plot(String owner, String shape) {
            this.owner = owner;
            this.shape = shape;
        }

        abstract double area();
    }

    static class Circle extends Plot {
        double radius;

        Circle(String owner, double radius) {
            super(owner, "CIRCLE");
            this.radius = radius;
        }

        double area() {
            return Math.PI * radius * radius;
        }
    }

    static class Rectangle extends Plot {
        double length, width;

        Rectangle(String owner, double length, double width) {
            super(owner, "RECTANGLE");
            this.length = length;
            this.width = width;
        }

        double area() {
            return length * width;
        }
    }

    static class Triangle extends Plot {
        double base, height;

        Triangle(String owner, double base, double height) {
            super(owner, "TRIANGLE");
            this.base = base;
            this.height = height;
        }

        double area() {
            return 0.5 * base * height;
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        double total = 0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String owner = sc.next();
            Plot p;

            switch (type) {
                case "CIRCLE":
                    p = new Circle(owner, sc.nextDouble());
                    break;
                case "RECTANGLE":
                    p = new Rectangle(owner, sc.nextDouble(),
                            sc.nextDouble());
                    break;
                default:
                    p = new Triangle(owner, sc.nextDouble(),
                            sc.nextDouble());
            }

            double area = p.area();
            System.out.printf(Locale.US, "%s (%s): %.2f%n",
                    p.owner, p.shape, area);
            total += area;
        }

        System.out.printf(Locale.US, "Total Area: %.2f%n", total);
    }
}