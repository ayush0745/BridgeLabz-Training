class Solution {
    public String convert(String s, int numRows) {
        if (numRows == 1 || s.length() <= numRows) return s;

        StringBuilder[] arr = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            arr[i] = new StringBuilder();
        }

        boolean down = true;
        int row = 0;

        for (int i = 0; i < s.length(); i++) {
            arr[row].append(s.charAt(i));

            if (row == numRows - 1) down = false;
            else if (row == 0) down = true;

            row += down ? 1 : -1;
        }

        StringBuilder result = new StringBuilder();
        for (StringBuilder sb : arr) {
            result.append(sb);
        }

        return result.toString();
    }
}
