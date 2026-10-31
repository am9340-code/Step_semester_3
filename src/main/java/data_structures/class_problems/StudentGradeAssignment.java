package data_structures.class_problems;

public class StudentGradeAssignment {

    public static void main(String[] args) {
        int[] marks = {72, 95, 35};

        for (int m : marks) {
            if (m >= 90)
                System.out.println("Grade A");
            else if (m >= 75)
                System.out.println("Grade B");
            else if (m >= 60)
                System.out.println("Grade C");
            else if (m >= 40)
                System.out.println("Grade D");
            else
                System.out.println("Grade F");
        }
    }
}