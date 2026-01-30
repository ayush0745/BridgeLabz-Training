public class HexColourValidator {

    public static boolean isValidHexColor(String color) {
        return color.matches("^#[0-9A-Fa-f]{6}$");
    }

    public static void main(String[] args) {

        String[] colors = {"#FFA500", "#ff4500", "#123"};

        for (String c : colors) {
            if (isValidHexColor(c))
                System.out.println(c + " → Valid");
            else
                System.out.println(c + " → Invalid");
        }
    }
}
