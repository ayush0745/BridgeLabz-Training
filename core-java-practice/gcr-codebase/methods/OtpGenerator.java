import java.util.Scanner;

public class OtpGenerator {

    public static void main(String[] args) {
        int[] otpLibrary = new int[10];

        System.out.println("Generating 10 OTPs...");

        // Generate 10 OTPs and store them
        for (int i = 0; i < 10; i++) {
            otpLibrary[i] = generateSixDigitOtp();
            System.out.println("OTP " + (i + 1) + ": " + otpLibrary[i]);
        }

        //  Validate uniqueness
        boolean allUnique = areOtpsUnique(otpLibrary);

        System.out.println("\n--- Validation Result ---");
        if (allUnique) {
            System.out.println("Success: All generated OTPs are unique.");
        } else {
            System.out.println("Warning: Duplicate OTPs were detected!");
        }
    }

   // Generates a random number between 100000 and 999999.
    
    public static int generateSixDigitOtp() {
        
        return (int) (Math.random() * 900000) + 100000;
    }

    // Checks if all numbers in the array are unique.
     
    public static boolean areOtpsUnique(int[] otps) {
        for (int i = 0; i < otps.length; i++) {
            for (int j = i + 1; j < otps.length; j++) {
                // If any two elements match, they are not unique
                if (otps[i] == otps[j]) {
                    return false;
                }
            }
        }
        return true;
    }
}