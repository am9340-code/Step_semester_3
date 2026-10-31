package data_structures.class_problems;

public class FactorialCalculation {

    public static void main(String[] args) {
        int[] numbers = {5, 0};

        for (int n : numbers) {
            long fact = 1;

            for (int i = 1; i <= n; i++)
                fact *= i;

            System.out.println(fact);
        }
    }
}