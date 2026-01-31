import java.util.*;

public class Program {

    //method to check vowels
    private static boolean isVowel(char ch) {
        return "AEIOU".indexOf(ch) != -1;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the first word");
        String first = sc.nextLine();

        //more than one word
        if (first.trim().contains(" ")) {
            System.out.println(first + " is an invalid word");
            return;
        }

        System.out.println("Enter the second word");
        String second = sc.nextLine();

        if (second.trim().contains(" ")) {
            System.out.println(second + " is an invalid word");
            return;
        }

        // Check if second is reverse of first
        String reversedFirst =
                new StringBuilder(first).reverse().toString();

        if (reversedFirst.equalsIgnoreCase(second)) {

            //reverse + lowercase
            String result = reversedFirst.toLowerCase();

            // replace vowels with '@'
            result = result.replaceAll("[aeiou]", "@");

            
            System.out.println(result);

        } else {

            // Combine and uppercase
            String combined = (first + second).toUpperCase();

            int vowelCount = 0, consonantCount = 0;

            for (char ch : combined.toCharArray()) {
                if (isVowel(ch)) {
                    vowelCount++;
                } else if (Character.isLetter(ch)) {
                    consonantCount++;
                }
            }

            if (vowelCount > consonantCount) {
                // Print first 2 unique vowels
                LinkedHashSet<Character> set = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (isVowel(ch)) {
                        set.add(ch);
                    }
                }
                printFirstTwo(set);

            } else if (consonantCount > vowelCount) {
                // Print first 2 unique consonants
                LinkedHashSet<Character> set = new LinkedHashSet<>();
                for (char ch : combined.toCharArray()) {
                    if (!isVowel(ch) && Character.isLetter(ch)) {
                        set.add(ch);
                    }
                }
                printFirstTwo(set);

            } else {
                System.out.println("Vowels and consonants are equal");
            }
        }

        sc.close();
    }

    //print first two characters from a set
    private static void printFirstTwo(LinkedHashSet<Character> set) {
        int count = 0;
        StringBuilder sb = new StringBuilder();
        for (char ch : set) {
            sb.append(ch);
            count++;
            if (count == 2) break;
        }
        System.out.println(sb.toString());
    }
}
