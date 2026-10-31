package data_structures.class_problems;

public class WordReverserPalindromeChecker {

    public static void main(String[] args) {
        String[] words = {"level", "java"};

        for (String word : words) {
            StringBuilder sb = new StringBuilder(word);
            String reverse = sb.reverse().toString();

            if (word.equals(reverse))
                System.out.println(reverse + " - palindrome");
            else
                System.out.println(reverse + " - not a palindrome");
        }
    }
}