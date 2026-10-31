package data_structures.assignment_problems;

public class ClassAttendanceTracker {

    static void attendanceSummary(int[] days) {
        int present = 0, streak = 0, longest = 0;

        for (int day : days) {
            if (day == 1) {
                present++;
                streak++;

                if (streak > longest)
                    longest = streak;
            } else {
                streak = 0;
            }
        }

        System.out.println("Present: " + present +
                ", Longest streak: " + longest);
    }

    public static void main(String[] args) {
        int[] days1 = {1, 1, 0, 1, 1, 1, 0, 1};
        int[] days2 = {0, 0, 0};

        attendanceSummary(days1);
        attendanceSummary(days2);
    }
}