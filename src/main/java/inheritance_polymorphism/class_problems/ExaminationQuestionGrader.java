package inheritance_polymorphism.class_problems;

import java.util.*;
import java.util.regex.*;

public class ExaminationQuestionGrader {

    static abstract class Question {
        String correct, student;
        double points;

        Question(String correct, String student, double points) {
            this.correct = correct;
            this.student = student;
            this.points = points;
        }

        abstract double grade();
    }

    static class MCQ extends Question {
        MCQ(String c, String s, double p) {
            super(c, s, p);
        }

        double grade() {
            return student.equals(correct) ? points : 0;
        }
    }

    static class TF extends Question {
        TF(String c, String s, double p) {
            super(c, s, p);
        }

        double grade() {
            return student.equals(correct) ? points : 0;
        }
    }

    static class Essay extends Question {
        Essay(String c, String s, double p) {
            super(c, s, p);
        }

        double grade() {
            int count = 0;
            String answer = student.toLowerCase();

            for (String key : correct.split(",")) {
                if (answer.contains(key.trim().toLowerCase()))
                    count++;
            }

            if (count >= 2)
                return points * 0.75;
            if (count == 1)
                return points * 0.50;
            return 0;
        }
    }

    static String[] parse(String line) {
        Matcher m = Pattern.compile("\"([^\"]*)\"|(\\S+)").matcher(line);
        ArrayList<String> a = new ArrayList<>();

        while (m.find())
            a.add(m.group(1) != null ? m.group(1) : m.group(2));

        return a.toArray(new String[0]);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        sc.nextLine();

        double total = 0;

        for (int i = 0; i < n; i++) {
            String[] p = parse(sc.nextLine());

            String type = p[0];
            Question q;

            if (type.equals("MCQ"))
                q = new MCQ(p[2], p[3], Double.parseDouble(p[4]));
            else if (type.equals("TF"))
                q = new TF(p[2], p[3], Double.parseDouble(p[4]));
            else
                q = new Essay(p[2], p[3], Double.parseDouble(p[4]));

            double score = q.grade();

            System.out.printf("%s: %.2f%n", type, score);
            total += score;
        }

        System.out.printf("Total Score: %.2f%n", total);
    }
}