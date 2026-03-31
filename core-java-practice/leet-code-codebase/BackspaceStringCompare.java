class Solution {
    public boolean backspaceCompare(String s, String t) {
        String str1 = helper( s);
        String str2 = helper( t);

        return str1.equals(str2);
    }
   public static String helper(String str) {
    StringBuilder result = new StringBuilder();

    for (int i = 0; i < str.length(); i++) {
        if (str.charAt(i) == '#') {
            if (result.length() > 0) {
                result.deleteCharAt(result.length() - 1);
            }
        } else {
            result.append(str.charAt(i));
        }
    }

    return result.toString();
}

}