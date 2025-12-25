import java.util.Scanner;

public class FrequencyLoop {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = sc.nextLine();

        // Call the method to find frequencies
        String[] frequencyResults = findFrequency(userInput);

        //  Display the result
        System.out.println("Character Frequency Result:");
    
        for (String result : frequencyResults) {
            if (result != null) {
                System.out.println(result);
            }
        }
        
        sc.close();
    }

    // Method to find frequency
    public static String[] findFrequency(String text) {
        char[] charArray = text.toCharArray();
        int[] freqArray = new int[charArray.length];
        
        // Loop to count frequencies
        for (int i = 0; i < charArray.length; i++) {
           
            if (charArray[i] == '0') {
                continue;
            }
            
            freqArray[i] = 1;
            
            for (int j = i + 1; j < charArray.length; j++) {
                if (charArray[i] == charArray[j]) {
                    freqArray[i]++; 
                    charArray[j] = '0'; 
                }
            }
        }

        String[] results = new String[charArray.length];
        int count = 0;
        for (int i = 0; i < charArray.length; i++) {
            
            if (charArray[i] != '0' && charArray[i] != ' ') {
                results[count++] = charArray[i] + " occurs " + freqArray[i] + " times";
            }
        }
        
        return results;
    }
}