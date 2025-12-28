class Solution {
    public boolean canConstruct(String rn, String mg) {
        Map<Character, Integer> mp = new HashMap<>();

        for(char ch : mg.toCharArray()) {
            mp.put(ch, mp.getOrDefault(ch, 0) + 1);
        }

        for(char ch : rn.toCharArray()) {
            
            if(!mp.containsKey(ch)) return false;

            int ans = mp.get(ch);
            mp.put(ch, ans - 1);
            if(mp.get(ch) == 0) {
                mp.remove(ch);
            }
        }
        return true;
    }
}