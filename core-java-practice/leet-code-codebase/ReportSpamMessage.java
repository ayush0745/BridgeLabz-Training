class Solution {
    public boolean reportSpam(String[] message, String[] bannedWords) {
        Set<String> set = new HashSet<>(Arrays.asList(bannedWords));
        int c = 0;
        for( String str : message){
            if(set.contains(str)) c++;

            if(c > 1) return true;
        }
    return false;
    }
}