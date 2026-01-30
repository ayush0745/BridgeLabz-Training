public class CreditCard {

    public static boolean isValidCard(String cardNumber) {
        return cardNumber.matches("^(4\\d{15}|5\\d{15})$");
    }

    public static void main(String[] args) {

        String[] cards = {
            "4111111111111111", // Visa
            "5111111111111111", // MasterCard
            "6111111111111111", // Invalid
            "41234"             // Invalid
        };

        for (String card : cards) {
            System.out.println(card + " → " +
                (isValidCard(card) ? "Valid" : "Invalid"));
        }
    }
}
