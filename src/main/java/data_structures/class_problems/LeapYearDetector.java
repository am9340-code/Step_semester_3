package data_structures.class_problems;

public class LeapYearDetector {

    public static void main(String[] args) {
        int[] years = {2024, 1900, 2000};

        for (int year : years) {
            if (year % 400 == 0 ||
                    (year % 4 == 0 && year % 100 != 0))
                System.out.println("Leap year");
            else
                System.out.println("Not a leap year");
        }
    }
}