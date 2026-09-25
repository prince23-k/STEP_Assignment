public class WordLengthProfiler {

    public static void classifyWordLengths(String review) {
        if (review == null || review.trim().isEmpty()) {
            System.out.println("Short: 0 | Medium: 0 | Long: 0");
            return;
        }

        // Split the review into words based on whitespace
        String[] words = review.trim().split("\\s+");
        
        int shortCount = 0;
        int mediumCount = 0;
        int longCount = 0;

        for (String word : words) {
            // Optional: Strip punctuation to measure the actual alphabetical word length accurately
            String cleanedWord = word.replaceAll("[^a-zA-Z]", "");
            int len = cleanedWord.length();

            if (len > 0) {
                if (len <= 4) {
                    shortCount++;
                } else if (len <= 8) {
                    mediumCount++;
                } else {
                    longCount++;
                }
            }
        }

        // Print the final result in the requested format
        System.out.println("Short: " + shortCount + " | Medium: " + mediumCount + " | Long: " + longCount);
    }

    public static void main(String[] args) {
        String sampleInput = "This movie was absolutely fantastic and thrilling";
        classifyWordLengths(sampleInput);
    }
}