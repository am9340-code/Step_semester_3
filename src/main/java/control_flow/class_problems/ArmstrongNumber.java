package control_flow.class_problems;

import java.util.Scanner;

public class ArmstrongNumber {

    static void checkArmstrong(int number) {

        int origNumber = number;
        int sum = 0;

        while (number != 0) {

            int digit = number % 10;

            sum = sum +
                    digit * digit * digit;

            number = number / 10;
        }

        boolean isArmstrong = sum == origNumber;

        System.out.println(
                "Is the number " + origNumber +
                        " an Armstrong number? " +
                        isArmstrong
        );
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number: ");
        int number = sc.nextInt();

        checkArmstrong(number);

        sc.close();
    }
}