package data_structures.class_problems;

public class PrimeNumberChecker {

    public static void main(String[] args) {
        int[] numbers = {29, 21};

        for (int n : numbers) {
            boolean prime = true;

            for (int i = 2; i <= Math.sqrt(n); i++) {
                if (n % i == 0) {
                    prime = false;
                    break;
                }
            }

            if (prime)
                System.out.println(n + " is prime");
            else
                System.out.println(n + " is not prime");
        }
    }
}