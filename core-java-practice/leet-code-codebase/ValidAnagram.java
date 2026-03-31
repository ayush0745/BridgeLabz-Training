class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) return false;
        
        Map<Character, Integer> charCounts = new HashMap<>();
        
        for (char c : s.toCharArray()) {
            charCounts.put(c, charCounts.getOrDefault(c, 0) + 1);
        }
        
        for (char a : t.toCharArray()) {
            if (!charCounts.containsKey(a) || charCounts.get(a) == 0) {
                return false;
            }
            charCounts.put(a, charCounts.get(a) - 1);
        }
        
      
        for (int count : charCounts.values()) {
            if (count != 0) {
                return false;
            }
        }
        
        return true;
    }
}