class Solution {
    class Pair{
        char a;
        int count;

        Pair(char a, int count){
            this.a = a;
            this.count = count;
        }

    }
    public String removeDuplicates(String s, int k) {
        Stack<Pair> stash = new Stack<>();

        for( int i = 0; i < s.length(); i++){
            if(stash.size() > 0 && stash.peek().a == s.charAt(i)){
                int temp = stash.pop().count;

                if(temp != k-1){
                    stash.push(new Pair(s.charAt(i),temp+1));
                }
            }
            else{
                 stash.push(new Pair(s.charAt(i),1));
            }
        }

        System.out.println(stash.size());
        StringBuilder  str = new StringBuilder();
        for( Pair l: stash){
            for(int i = 1; i <= l.count; i++)
                str.append(l.a);
        }

        return str.toString();
    }
}