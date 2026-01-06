class Solution {
    public String removeDuplicates(String s) {
        Stack<Character> stash = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (!stash.isEmpty() && stash.peek() == ch) {
                stash.pop();
            } else {
                stash.push(ch);
            }
        }

        StringBuilder result = new StringBuilder();
        for (char c : stash) {
            result.append(c);
        }

        return result.toString();
    }
}