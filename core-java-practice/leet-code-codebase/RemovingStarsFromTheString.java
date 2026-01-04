class Solution {
    public String removeStars(String s) {
        Stack<Character> stash = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '*') {
                stash.pop();
            } else {
                stash.push(s.charAt(i));
            }
        }

        StringBuilder result = new StringBuilder();
        for (char ch : stash) {
            result.append(ch);
        }

        return result.toString();
    }
}
