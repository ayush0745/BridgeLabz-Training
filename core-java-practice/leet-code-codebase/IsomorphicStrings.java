class Solution {
    public boolean isIsomorphic(String s, String t) {
      
        int[] mapS = new int[256];
        int[] mapT = new int[256];

        for (int i = 0; i < s.length(); i++) {
            char charS = s.charAt(i);
            char charT = t.charAt(i);

           
            if (mapS[charS] != mapT[charT]) {
                return false;
            }
            mapS[charS] = i + 1;
            mapT[charT] = i + 1;
        }

        return true;
    }
}
// to find strings are isomorphic or not
//means same pattern and same frequency
//ex: aab - yyg