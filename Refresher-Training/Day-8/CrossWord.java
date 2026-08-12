import java.io.*;
import java.util.*;
import java.util.stream.*;

class Result {

    public static List<String> crosswordPuzzle(List<String> crossword, String words) {

        char[][] board = new char[10][10];

        for (int i = 0; i < 10; i++) {
            board[i] = crossword.get(i).toCharArray();
        }

        String[] wordList = words.split(";");

        solve(board, wordList, 0);

        List<String> result = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            result.add(new String(board[i]));
        }

        return result;
    }

    public static boolean solve(char[][] board, String[] words, int index) {

        if (index == words.length) {
            return true;
        }

        String word = words[index];

        for (int row = 0; row < 10; row++) {
            for (int col = 0; col < 10; col++) {

                if (canPlaceHorizontal(board, word, row, col)) {

                    boolean[] changed = placeHorizontal(board, word, row, col);

                    if (solve(board, words, index + 1)) {
                        return true;
                    }

                    removeHorizontal(board, word, row, col, changed);
                }

                if (canPlaceVertical(board, word, row, col)) {

                    boolean[] changed = placeVertical(board, word, row, col);

                    if (solve(board, words, index + 1)) {
                        return true;
                    }

                    removeVertical(board, word, row, col, changed);
                }
            }
        }

        return false;
    }

    public static boolean canPlaceHorizontal(
            char[][] board, String word, int row, int col) {

        if (col + word.length() > 10) {
            return false;
        }

        if (col > 0 && board[row][col - 1] != '+') {
            return false;
        }

        if (col + word.length() < 10 &&
                board[row][col + word.length()] != '+') {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {

            if (board[row][col + i] != '-' &&
                    board[row][col + i] != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean canPlaceVertical(
            char[][] board, String word, int row, int col) {

        if (row + word.length() > 10) {
            return false;
        }

        if (row > 0 && board[row - 1][col] != '+') {
            return false;
        }

        if (row + word.length() < 10 &&
                board[row + word.length()][col] != '+') {
            return false;
        }

        for (int i = 0; i < word.length(); i++) {

            if (board[row + i][col] != '-' &&
                    board[row + i][col] != word.charAt(i)) {
                return false;
            }
        }

        return true;
    }

    public static boolean[] placeHorizontal(
            char[][] board, String word, int row, int col) {

        boolean[] changed = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {

            if (board[row][col + i] == '-') {
                board[row][col + i] = word.charAt(i);
                changed[i] = true;
            }
        }

        return changed;
    }

    public static boolean[] placeVertical(
            char[][] board, String word, int row, int col) {

        boolean[] changed = new boolean[word.length()];

        for (int i = 0; i < word.length(); i++) {

            if (board[row + i][col] == '-') {
                board[row + i][col] = word.charAt(i);
                changed[i] = true;
            }
        }

        return changed;
    }

    public static void removeHorizontal(
            char[][] board, String word, int row, int col,
            boolean[] changed) {

        for (int i = 0; i < word.length(); i++) {

            if (changed[i]) {
                board[row][col + i] = '-';
            }
        }
    }

    public static void removeVertical(
            char[][] board, String word, int row, int col,
            boolean[] changed) {

        for (int i = 0; i < word.length(); i++) {

            if (changed[i]) {
                board[row + i][col] = '-';
            }
        }
    }
}

public class Solution {

    public static void main(String[] args) throws IOException {

        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));

        BufferedWriter bufferedWriter =
                new BufferedWriter(
                        new FileWriter(System.getenv("OUTPUT_PATH")));

        List<String> crossword = IntStream.range(0, 10)
                .mapToObj(i -> {
                    try {
                        return bufferedReader.readLine();
                    } catch (IOException ex) {
                        throw new RuntimeException(ex);
                    }
                })
                .collect(Collectors.toList());

        String words = bufferedReader.readLine();

        List<String> result =
                Result.crosswordPuzzle(crossword, words);

        bufferedWriter.write(
                result.stream()
                        .collect(Collectors.joining("\n"))
                        + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }
}