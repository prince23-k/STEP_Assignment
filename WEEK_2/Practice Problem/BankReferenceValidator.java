import java.util.Scanner;

public class BankReferenceValidator {

    public static String normalizeReference(String raw) {
        if (raw == null) return "";
        String trimmed = raw.trim();
        if (trimmed.length() < 3) return trimmed;

        String bankCode = trimmed.substring(0, 3).toUpperCase();
        String body = trimmed.substring(3);

        return bankCode + body;
    }

    public static String validateAndFormat(String reference) {
        if (reference.length() != 14) {
            return "Invalid: wrong length";
        }

        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(reference.charAt(i))) {
                return "Invalid: bank code must be 3 letters";
            }
        }

        for (int i = 3; i < 14; i++) {
            if (!Character.isDigit(reference.charAt(i))) {
                return "Invalid: non-digit body";
            }
        }

        String bankCode = reference.substring(0, 3);
        String datePart = reference.substring(3, 9);
        String seqPart = reference.substring(9, 14);

        String formattedDate = datePart.substring(0, 2) + "/" + 
                               datePart.substring(2, 4) + "/" + 
                               datePart.substring(4, 6);

        StringBuilder sb = new StringBuilder();
        sb.append("[").append(bankCode).append("] DATE: ")
          .append(formattedDate).append(" | SEQ: ").append(seqPart);

        return sb.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter raw transaction reference: ");
        String raw = scanner.nextLine();

        String normalized = normalizeReference(raw);
        String result = validateAndFormat(normalized);
        
        System.out.println(result);

        scanner.close();
    }
}