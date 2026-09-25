import java.util.Scanner;

public class LibraryIsbnValidator {

    public static String normalizeCode(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;

        String pubCode = trimmed.substring(0, 3).toUpperCase();
        String body = trimmed.substring(3);

        return pubCode + body;
    }

    public static String validateAndFormat(String code) {
        if (code.length() != 13) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(code.charAt(i))) {
                return "Invalid: publisher code must be 3 letters";
            }
        }

        for (int i = 3; i < 13; i++) {
            if (!Character.isDigit(code.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String pubCode = code.substring(0, 3);
        String yearPart = code.substring(3, 7);
        String catalogPart = code.substring(7, 13);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(pubCode).append("] YEAR: ")
          .append(yearPart).append(" | CATALOG: ").append(catalogPart);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter raw ISBN code: ");
        String raw = scanner.nextLine();

        String normalized = normalizeCode(raw);
        String result = validateAndFormat(normalized);

        System.out.println(result);

        scanner.close();
    }
}