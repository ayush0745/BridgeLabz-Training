public class Exception {
    public static void main(String[] args) {
       
        System.out.println("Generating Exception...");
      

        
        System.out.println("Handling Exception...");
        handleException();
        
        System.out.println("Program finished safely.");
    }

    // Method that causes a crash
    public static void generateException() {
        String text = null;
        System.out.println(text.length());
    }

    // Method that uses try-catch to prevent the crash
    public static void handleException() {
        String text = null;
        try {
            System.out.println(text.length());
        } catch (NullPointerException e) {
            System.out.println("Error caught: You cannot call methods on a null string!");
        }
    }
}