import java.util.Scanner;

public class Words {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a sentence:");
        String text = sc.nextLine();

        String[] words = customSplit(text);
        String[][] wordData = getWordData(words);
        
        // indices[0] = index of shortest, indices[1] = index of longest
        int[] indices = findShortestLongest(wordData);

        System.out.println("Shortest word: " + wordData[indices[0]][0] + " (Length: " + wordData[indices[0]][1] + ")");
        System.out.println("Longest word: " + wordData[indices[1]][0] + " (Length: " + wordData[indices[1]][1] + ")");
    }

    public static int findLen(String s) {
        int count = 0;
        try {
            while (true) { s.charAt(count); count++; }
        } catch (Exception e) { return count; }
    }

    public static String[] customSplit(String text) {
        int len = findLen(text);
        int spaces = 0;
        for (int i = 0; i < len; i++) if (text.charAt(i) == ' ') spaces++;
        
        String[] words = new String[spaces + 1];
        String temp = "";
        int idx = 0;
        for (int i = 0; i < len; i++) {
            if (text.charAt(i) == ' ') {
                words[idx++] = temp;
                temp = "";
            } else { temp += text.charAt(i); }
        }
        words[idx] = temp;
        return words;
    }

    public static String[][] getWordData(String[] words) {
        String[][] data = new String[words.length][2];
        for (int i = 0; i < words.length; i++) {
            data[i][0] = words[i];
            data[i][1] = String.valueOf(findLen(words[i]));
        }
        return data;
    }

    public static int[] findShortestLongest(String[][] data) {
        int shortIdx = 0, longIdx = 0;
        for (int i = 1; i < data.length; i++) {
            int currentLen = Integer.parseInt(data[i][1]);
            if (currentLen < Integer.parseInt(data[shortIdx][1])) shortIdx = i;
            if (currentLen > Integer.parseInt(data[longIdx][1])) longIdx = i;
        }
        return new int[]{shortIdx, longIdx};
    }
}