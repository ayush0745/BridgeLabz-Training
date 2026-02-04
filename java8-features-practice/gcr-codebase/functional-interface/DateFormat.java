import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateFormat {

    // Interface with static date formatter method
    interface DateUtils {

        static String formatDate(LocalDate date, String pattern) {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern(pattern);
            return date.format(formatter);
        }
    }

    // Main method
    public static void main(String[] args) {

        LocalDate invoiceDate = LocalDate.now();

        System.out.println("DD-MM-YYYY : "
                + DateUtils.formatDate(invoiceDate, "dd-MM-yyyy"));

        System.out.println("YYYY/MM/DD : "
                + DateUtils.formatDate(invoiceDate, "yyyy/MM/dd"));

        System.out.println("Month DD, YYYY : "
                + DateUtils.formatDate(invoiceDate, "MMMM dd, yyyy"));
    }
}
