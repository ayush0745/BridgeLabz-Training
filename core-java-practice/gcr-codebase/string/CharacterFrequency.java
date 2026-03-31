import java.util.Scanner;

public class CharacterFrequency {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter a string: ");
        String userInput = sc.nextLine();

        // 2D array
        String[][] frequencyData = getFrequencyArray(userInput);

        // Display the result
        System.out.println("\nCharacter Frequency Table:");
        System.out.println("Character\tFrequency");
   
        for (int i = 0; i < frequencyData.length; i++) {
            System.out.println(frequencyData[i][0] + "   " + frequencyData[i][1]);
        }
        
        sc.close();
    }

    // Method to find unique characters
    public static char[] uniqueCharacters(String text) {
        int n = text.length();
        char[] tempUnique = new char[n];
        int uniqueCount = 0;

        for (int i = 0; i < n; i++) {
            char current = text.charAt(i);
            boolean isAlreadySeen = false;
            
            for (int j = 0; j < i; j++) {
                if (text.charAt(j) == current) {
                    isAlreadySeen = true;
                    break;
                }
            }

            if (!isAlreadySeen) {
                tempUnique[uniqueCount++] = current;
            }
        }

     
        char[] finalUnique = new char[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            finalUnique[i] = tempUnique[i];
        }
        return finalUnique;
    }

    // Method to find frequency and return a 2D String array
    public static String[][] getFrequencyArray(String text) {
     
        int[] asciiCounts = new int[256];
        for (int i = 0; i < text.length(); i++) {
            char ch = text.charAt(i);
            asciiCounts[ch]++; 
        }

       
        char[] uniqueChars = uniqueCharacters(text);
        
      
        String[][] report = new String[uniqueChars.length][2];
        for (int i = 0; i < uniqueChars.length; i++) {
            char uc = uniqueChars[i];
            report[i][0] = String.valueOf(uc);
            report[i][1] = String.valueOf(asciiCounts[uc]);
        }

        return report;
    }
}