import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Player implements Comparable<Player> {
    String name;
    int matchesPlayed;
    double battingAverage;
    boolean injured;

    public Player(String name, int matchesPlayed, double battingAverage, boolean injured) {
        this.name = name;
        this.matchesPlayed = matchesPlayed;
        this.battingAverage = battingAverage;
        this.injured = injured;
    }

    @Override
    public int compareTo(Player other) {
        // Rank by batting average descending (acting as fantasy points)
        return Double.compare(other.battingAverage, this.battingAverage);
    }
}

public class FantasyDraftEngine {

    public static boolean isDraftable(int matchesPlayed) {
        return matchesPlayed >= 10;
    }

    public static boolean isDraftable(int matchesPlayed, boolean injured) {
        return matchesPlayed >= 5 && !injured;
    }

    public static String draftAndRank(Player[] players) {
        List<Player> draftableList = new ArrayList<>();

        for (Player p : players) {
            if (isDraftable(p.matchesPlayed) || isDraftable(p.matchesPlayed, p.injured)) {
                draftableList.add(p);
            }
        }

        Player[] sortedArray = draftableList.toArray(new Player[0]);
        Arrays.sort(sortedArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortedArray.length; i++) {
            sb.append((i + 1)).append(". ").append(sortedArray[i].name);
            if (i < sortedArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Player[] players = {
            new Player("Virat", 15, 48.0, false),
            new Player("Rahul", 7, 55.0, false),
            new Player("Sameer", 3, 60.0, false),
            new Player("Dev", 12, 20.0, true)
        };

        String result = draftAndRank(players);
        System.out.println(result);
    }
}