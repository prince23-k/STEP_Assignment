import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

class Candidate implements Comparable<Candidate> {
    String name;
    double cgpa;
    int codingScore;

    public Candidate(String name, double cgpa, int codingScore) {
        this.name = name;
        this.cgpa = cgpa;
        this.codingScore = codingScore;
    }

    public double getCompositeScore() {
        return (cgpa * 10.0) + (codingScore / 2.0);
    }

    @Override
    public int compareTo(Candidate other) {
        // Descending order ranking
        return Double.compare(other.getCompositeScore(), this.getCompositeScore());
    }
}

public class PlacementEngine {

    public static boolean isEligible(double cgpa) {
        return cgpa >= 7.5;
    }

    public static boolean isEligible(double cgpa, int codingScore) {
        return cgpa >= 6.5 && codingScore >= 60;
    }

    public static String shortlistAndRank(Candidate[] candidates) {
        List<Candidate> shortlisted = new ArrayList<>();

        for (Candidate c : candidates) {
            if (isEligible(c.cgpa) || isEligible(c.cgpa, c.codingScore)) {
                shortlisted.add(c);
            }
        }

        Candidate[] sortedArray = shortlisted.toArray(new Candidate[0]);
        Arrays.sort(sortedArray);

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < sortedArray.length; i++) {
            Candidate c = sortedArray[i];
            sb.append((i + 1)).append(". ").append(c.name)
              .append(" (").append(c.getCompositeScore()).append(")");
            if (i < sortedArray.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }

    public static void main(String[] args) {
        Candidate[] candidates = {
            new Candidate("Aisha", 8.2, 40),
            new Candidate("Rohit", 6.8, 65),
            new Candidate("Meena", 6.0, 90),
            new Candidate("Karan", 7.5, 20)
        };

        String result = shortlistAndRank(candidates);
        System.out.println(result);
    }
}