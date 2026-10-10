package classes_objects.assignment_problems;

import java.util.Scanner;

public class PayrollSalaryManagement {

    static class PayrollAccount {

        private double basicSalary;
        private double bonus;

        public PayrollAccount(double openingBasicSalary) {

            if (openingBasicSalary < 0) {
                System.out.println(
                        "Warning: Negative salary. Starting at 0."
                );
                basicSalary = 0;
            } else {
                basicSalary = openingBasicSalary;
            }

            bonus = 0;
        }

        public void creditBonus(double amount) {

            if (amount <= 0) {
                System.out.println(
                        "Bonus rejected: invalid amount"
                );
            } else {
                bonus += amount;

                System.out.println(
                        "Bonus credited: Rs " + amount
                );
            }
        }

        public void deductTax(double percent) {

            if (percent < 0 || percent > 100) {
                System.out.println(
                        "Tax rejected: invalid percentage"
                );
            } else {
                basicSalary =
                        basicSalary -
                                (basicSalary * percent / 100);

                System.out.println(
                        "Tax deducted: " + percent + "%"
                );
            }
        }

        public double getNetSalary() {
            return basicSalary + bonus;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter basic salary: ");
        double basicSalary = sc.nextDouble();

        PayrollAccount account =
                new PayrollAccount(basicSalary);

        System.out.print("Enter bonus: ");
        double bonus = sc.nextDouble();

        account.creditBonus(bonus);

        System.out.print("Enter tax percentage: ");
        double tax = sc.nextDouble();

        account.deductTax(tax);

        System.out.println(
                "Net salary: Rs " +
                        account.getNetSalary()
        );

        sc.close();
    }
}