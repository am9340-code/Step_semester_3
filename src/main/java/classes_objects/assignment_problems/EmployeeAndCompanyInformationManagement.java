package classes_objects.assignment_problems;

import java.util.Scanner;

public class EmployeeAndCompanyInformationManagement {

    static class Employee {

        String empName;
        double salary;

        static String companyName =
                "Bright Horizon Technologies";

        static int employeeCount = 0;

        Employee(String empName, double salary) {

            this.empName = empName;
            this.salary = salary;

            employeeCount++;
        }

        static void printCompanyInfo() {

            System.out.println(companyName);

            System.out.println(
                    "Employees on record: " +
                            employeeCount
            );
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        for (int i = 0; i < 3; i++) {

            System.out.print("Enter employee name: ");
            String name = sc.nextLine();

            System.out.print("Enter salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();

            new Employee(name, salary);
        }

        Employee.printCompanyInfo();

        sc.close();
    }
}