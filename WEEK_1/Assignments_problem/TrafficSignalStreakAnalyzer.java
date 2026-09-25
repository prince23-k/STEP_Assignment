import java.util.Scanner;

public class TrafficSignalStreakAnalyzer {

    static void findLongestStreak(String signalLog) {

        int currentStreak = 1;
        int longestStreak = 1;

        char currentColor = signalLog.charAt(0);
        char longestColor = signalLog.charAt(0);

        for (int i = 1; i < signalLog.length(); i++) {

            if (signalLog.charAt(i) == signalLog.charAt(i - 1)) {
                currentStreak++;
            } else {

                if (currentStreak > longestStreak) {
                    longestStreak = currentStreak;
                    longestColor = signalLog.charAt(i - 1);
                }

                currentStreak = 1;
            }
        }

        // Check the final streak
        if (currentStreak > longestStreak) {
            longestStreak = currentStreak;
            longestColor = signalLog.charAt(signalLog.length() - 1);
        }

        System.out.println("Longest Streak: '" + longestColor
                + "' repeated " + longestStreak + " times");
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter signal log: ");
        String signalLog = sc.nextLine();

        findLongestStreak(signalLog);

        sc.close();
    }
}