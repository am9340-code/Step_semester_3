package arrays_methods.class_problems;

import java.util.Arrays;
import java.util.Scanner;

public class PlacementDriveShortlistingRankingEngine {

    static class Candidate implements Comparable<Candidate> {

        private String name;
        private double cgpa;
        private int codingScore;

        public Candidate(String name, double cgpa, int codingScore) {
            this.name = name;
            this.cgpa = cgpa;
            this.codingScore = codingScore;
        }

        public double getCompositeScore() {
            return cgpa * 10 + codingScore * 0.5;
        }

        public String getName() {
            return name;
        }

        public static boolean isEligible(double cgpa) {
            return cgpa >= 7.5;
        }

        public static boolean isEligible(
                double cgpa,
                int codingScore) {

            return cgpa >= 6.5 && codingScore >= 60;
        }

        @Override
        public int compareTo(Candidate other) {

            return Double.compare(
                    other.getCompositeScore(),
                    this.getCompositeScore()
            );
        }
    }

    static String shortlistAndRank(Candidate[] candidates) {

        Candidate[] shortlisted =
                new Candidate[candidates.length];

        int count = 0;

        for (Candidate candidate : candidates) {

            boolean eligible =
                    Candidate.isEligible(candidate.cgpa)
                            ||
                            Candidate.isEligible(
                                    candidate.cgpa,
                                    candidate.codingScore
                            );

            if (eligible) {
                shortlisted[count] = candidate;
                count++;
            }
        }

        Candidate[] finalList =
                Arrays.copyOf(shortlisted, count);

        Arrays.sort(finalList);

        StringBuilder result = new StringBuilder();

        for (int i = 0; i < finalList.length; i++) {

            result.append(i + 1)
                    .append(". ")
                    .append(finalList[i].getName())
                    .append(" (")
                    .append(finalList[i].getCompositeScore())
                    .append(")");

            if (i < finalList.length - 1) {
                result.append(" | ");
            }
        }

        return result.toString();
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of candidates: ");
        int n = sc.nextInt();
        sc.nextLine();

        Candidate[] candidates = new Candidate[n];

        for (int i = 0; i < n; i++) {

            System.out.println(
                    "Enter details for candidate " + (i + 1)
            );

            System.out.print("Name: ");
            String name = sc.nextLine();

            System.out.print("CGPA: ");
            double cgpa = sc.nextDouble();

            System.out.print("Coding score: ");
            int codingScore = sc.nextInt();
            sc.nextLine();

            candidates[i] =
                    new Candidate(name, cgpa, codingScore);
        }

        System.out.println(
                shortlistAndRank(candidates)
        );

        sc.close();
    }
}