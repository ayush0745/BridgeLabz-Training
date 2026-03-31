public class LicensePlateValidator {

    public static boolean isValidPlate(String plate) {
        return plate.matches("^[A-Z]{2}[0-9]{4}$");
    }

    public static void main(String[] args) {

        String[] plates = {"AB1234", "A12345", "ab1234"};

        for (String p : plates) {
            if (isValidPlate(p))
                System.out.println(p + " → Valid");
            else
                System.out.println(p + " → Invalid");
        }
    }
}
