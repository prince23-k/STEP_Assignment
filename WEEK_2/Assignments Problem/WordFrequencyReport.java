import java.util.*;

public class WordFrequencyReport {

    public static void printFilteredWordFrequency(String feedback) {
        if (feedback == null || feedback.isEmpty()) {
            return;
        }

        Set<String> stopWords = new HashSet<>(Arrays.asList("the", "was", "and", "a", "is", "of", "in"));

        // Normalize: lowercase, strip periods and commas
        String cleaned = feedback.toLowerCase().replace(".", "").replace(",", "");
        String[] words = cleaned.split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();

        for (String word : words) {
            if (!word.isEmpty() && !stopWords.contains(word)) {
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        // Sort by frequency count in descending order
        List<Map.Entry<String, Integer>> list = new ArrayList<>(freqMap.entrySet());
        list.sort((a, b) -> b.getValue().compareTo(a.getValue()));

        for (Map.Entry<String, Integer> entry : list) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter feedback paragraph: ");
        String feedback = scanner.nextLine();

        printFilteredWordFrequency(feedback);

        scanner.close();
    }
}