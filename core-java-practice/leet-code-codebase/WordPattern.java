class Solution {
    public boolean wordPattern(String pattern, String s) {
        Map<Character, String> mpPattern = new HashMap<>();
        Map<String, Character> mpS = new HashMap<>();

        String[] arr = s.split(" ");

        if(pattern.length() != arr.length) return false;

        int idx = 0;
        for(char ch : pattern.toCharArray()) {
            if(mpPattern.containsKey(ch)) {
                if(!((mpPattern.get(ch)).equals(arr[idx]))) return false;                
            }

            mpPattern.put(ch, arr[idx]);
            idx++;

        }

        idx = 0;
        for(String str : arr) {
            if(mpS.containsKey(str)) {
                if(!(mpS.get(str) == pattern.charAt(idx))) return false;
            }

            mpS.put(str, pattern.charAt(idx));
            idx++;
        }

        return true;
    }
}